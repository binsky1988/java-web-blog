package com.blog.dao;

import java.util.List;

import com.blog.page.Page;
import com.blog.po.Article;

public interface ArticleDAO {
    //保存文章方法
    public void add(Article article);
    
    //取出用户所有文章方法
    public List<Article> queryUserAll(String username);
    
    //获得用户文章总记录数方法
    public int queryUserAllCount(String username);
    
    //分页查询用户记录
    public List<Article> queryByPage(String username, Page page);
    
    //获得所有文章总记录数方法
    public int queryAllCount();
    
    //按分页信息查询记录
    public List<Article> queryAllByPage(Page page);
    
    //按ID查询文章
    public Article queryById(int id);
    
    //更新文章
    public Article updateArticle(String username, int id);
}
