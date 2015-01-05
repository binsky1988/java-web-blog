package com.blog.service;

import java.util.List;

import com.blog.action.UpdateArticle;
import com.blog.page.Page;
import com.blog.page.Result;
import com.blog.po.Article;

public interface ArticleService {
    //��������
    public void addArticle(Article article);
    
    //ȡ���û���������
    public List<Article> showUserAllArticle(String username);
    
    //��ҳ��ʾ�û�����
    public Result showUserArticleByPage(String username, Page page);
    
    //��ҳ��ʾȫ������
    public Result showArticleByPage(Page page);
    
    //��ʾ����
    public Article showArticle(int id);
    
    //���������
    public int getCritiqueCount(int AId);
    
    //��������
    public Article updateArticle(String username, int id);
}