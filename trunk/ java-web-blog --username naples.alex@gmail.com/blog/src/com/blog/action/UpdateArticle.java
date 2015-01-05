package com.blog.action;

import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.blog.po.Article;
import com.blog.service.ArticleService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class UpdateArticle extends ActionSupport {
    private int id;
    private String title;
    private String content;
    private ArticleService articleService;
    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public ArticleService getArticleService() {
        return articleService;
    }
    public void setArticleService(ArticleService articleService) {
        this.articleService = articleService;
    }
    
    public String execute() throws Exception {
        HttpServletRequest request = ServletActionContext.getRequest();
    	String username = request.getParameter("username");
    	int id = Integer.parseInt(request.getParameter("id"));
    	String title = request.getParameter("title");
    	String content = request.getParameter("content");
    	   	
        //根据用户名和博客文章标题查找文章
        Article article = articleService.updateArticle(username, id);
        //修改文章，封装PO类
        article.setTitle(title);
        article.setContent(content);
        article.setUsername(username);
        article.setDate(new Date());
        article.setHasread(0);
        articleService.addArticle(article);
        return this.SUCCESS;
    }
}
