package com.blog.action;

import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.blog.page.Page;
import com.blog.page.Result;
import com.blog.po.Article;
import com.blog.rss.CreateRss;
import com.blog.service.ArticleService;
import com.opensymphony.xwork2.ActionSupport;

public class ShowRSS extends ActionSupport {
    private ArticleService articleService;

    public ArticleService getArticleService() {
        return articleService;
    }

    public void setArticleService(ArticleService articleService) {
        this.articleService = articleService;
    }
    
    public String execute() throws Exception {
        Page page = new Page();     //分页信息
        page.setCurrentPage(0);     //设置当前页为第一页
        page.setEveryPage(10);      //每页显示10条记录
        Result result = articleService.
            showArticleByPage(page);//通过调用业务逻辑组件来完成查询
        page = result.getPage();
        List<Article> all = result.getList();//获得文章结果集
        String filePath = ServletActionContext.
            getServletContext().getRealPath("/rss.xml");//设置订阅文件地址
        CreateRss.publishRss(all, filePath);//写入订阅文件
        return this.SUCCESS;
    }
}
