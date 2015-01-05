package com.blog.service;

import java.util.List;

import com.blog.action.UpdateArticle;
import com.blog.page.Page;
import com.blog.page.Result;
import com.blog.po.Article;

public interface ArticleService {
    //保存文章
    public void addArticle(Article article);
    
    //取出用户所有文章
    public List<Article> showUserAllArticle(String username);
    
    //分页显示用户文章
    public Result showUserArticleByPage(String username, Page page);
    
    //分页显示全部文章
    public Result showArticleByPage(Page page);
    
    //显示文章
    public Article showArticle(int id);
    
    //获得评论数
    public int getCritiqueCount(int AId);
    
    //更新文章
    public Article updateArticle(String username, int id);
}
