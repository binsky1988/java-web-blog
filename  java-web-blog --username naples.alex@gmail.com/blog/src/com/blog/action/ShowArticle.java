package com.blog.action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.blog.page.Page;
import com.blog.page.Result;
import com.blog.po.Article;
import com.blog.po.BlogInfo;
import com.blog.service.ArticleService;
import com.blog.service.BlogInfoService;
import com.blog.service.CritiqueService;
import com.blog.service.ViewRateService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ShowArticle extends ActionSupport {
    // 业务逻辑组件属性
    private ArticleService articleService;
    // id属性
    private int id;
    // 点击量的业务逻辑组件
    private ViewRateService viewRateService;
    // 评论的业务逻辑组件
    private CritiqueService critiqueService;
    //设置当前页
    private int currentPage;
    //username
    private String username;
    //博客信息服务
    private BlogInfoService blogInfoService;
    
    public ArticleService getArticleService() {
        return articleService;
    }
    public void setArticleService(ArticleService articleService) {
        this.articleService = articleService;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public ViewRateService getViewRateService() {
        return viewRateService;
    }
    public void setViewRateService(ViewRateService viewRateService) {
        this.viewRateService = viewRateService;
    }
    public CritiqueService getCritiqueService() {
        return critiqueService;
    }
    public void setCritiqueService(CritiqueService critiqueService) {
        this.critiqueService = critiqueService;
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
    public BlogInfoService getBlogInfoService() {
        return blogInfoService;
    }
    public void setBlogInfoService(BlogInfoService blogInfoService) {
        this.blogInfoService = blogInfoService;
    }
    
    public String execute() throws Exception {
        // 将文章设置到request范围
        HttpServletRequest request = ServletActionContext.getRequest();
        // 按ID查询文章
        Article article = articleService.showArticle(id);
        // 获得用户IP
        String IP = request.getRemoteAddr();
        // 获得当前时间
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String stime = sdf.format(new Date());
        Date time = sdf.parse(stime);

        if (!viewRateService.isVistor(id, IP, time)) {
            // 点击量增加
            article.setHasread(article.getHasread() + 1);
        }
        // 将更新的Article保存到数据表中
        articleService.addArticle(article);
        
        
        //显示评论
        Page page = new Page();
        page.setCurrentPage(this.getCurrentPage());
        page.setEveryPage(5);
        
        Result result = critiqueService.showCritiqueByPage(id, page);
        
        request.setAttribute("page", result.getPage());
        request.setAttribute("allCri", result.getList());
        request.setAttribute("article", article);
        
        //取得个性化设置
        //通过业务逻辑组件来查询
        if(username != null || !"".equals(username)) {
            Map session = ActionContext.getContext().getSession();
            BlogInfo bloginfo  = blogInfoService.getBlogInfo(username);
            if(bloginfo != null) {
                session.put("blogtitle", bloginfo.getBlogtitle());
                session.put("idiograph", bloginfo.getIdiograph());
            }
        }
        return this.SUCCESS;
    }
}
