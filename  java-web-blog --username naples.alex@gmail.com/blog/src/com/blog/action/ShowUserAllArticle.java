package com.blog.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.blog.page.Page;
import com.blog.page.Result;
import com.blog.po.Article;
import com.blog.service.ArticleService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ShowUserAllArticle extends ActionSupport {
    private ArticleService articleService;
    private int currentPage;
    private String username;
    
    public ArticleService getArticleService() {
        return articleService;
    }
    public void setArticleService(ArticleService articleService) {
        this.articleService = articleService;
    }
    public int getCurrentPage() {
        return currentPage;
    }
    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    
    public String execute() throws Exception {
        if(username == null || "".equals(username)) {
            //首先要获得session
            Map session = ActionContext.getContext().getSession();
            //获得username
            username = (String) session.get("username");
        }
        
        //通过调用业务逻辑组件来完成查询
        Page page = new Page();
        page.setCurrentPage(this.getCurrentPage());
        page.setEveryPage(5);
        
        Result result = articleService.showUserArticleByPage(username, page);
        page = result.getPage();
        List<Article> all = result.getList();
        List critiqueCounts = new ArrayList();
        
        for(Article article : all) {
            critiqueCounts.add(articleService.getCritiqueCount(article.getId()));
        }
        
        //把查询到的结果保存在一个范围，request
        HttpServletRequest request = ServletActionContext.getRequest();
        request.setAttribute("all", all);
        request.setAttribute("page", page);
        request.setAttribute("critiqueCounts",critiqueCounts);
        return this.SUCCESS;
    }
}
