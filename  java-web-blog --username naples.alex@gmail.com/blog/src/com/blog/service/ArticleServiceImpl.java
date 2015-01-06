package com.blog.service;

import java.util.List;

import com.blog.dao.ArticleDAO;
import com.blog.dao.CritiqueDAO;
import com.blog.page.Page;
import com.blog.page.PageUtil;
import com.blog.page.Result;
import com.blog.po.Article;

public class ArticleServiceImpl implements ArticleService {
    private ArticleDAO articleDAO;
    private CritiqueDAO critiqueDAO;
    
    
    public ArticleDAO getArticleDAO() {
        return articleDAO;
    }

    public void setArticleDAO(ArticleDAO articleDAO) {
        this.articleDAO = articleDAO;
    }

    public CritiqueDAO getCritiqueDAO() {
        return critiqueDAO;
    }

    public void setCritiqueDAO(CritiqueDAO critiqueDAO) {
        this.critiqueDAO = critiqueDAO;
    }

    //��������
    public void addArticle(Article article) {
        articleDAO.add(article);
    }
    
    //ȡ���û���������
    public List<Article> showUserAllArticle(String username) {
        System.out.println(articleDAO.queryUserAllCount(username));
        return articleDAO.queryUserAll(username);
    }
    
    //��ҳ��ʾ�û�����
    public Result showUserArticleByPage(String username, Page page) {
        page = PageUtil.createPage(page,articleDAO.queryUserAllCount(username));
        List<Article> all = articleDAO.queryByPage(username, page);
        Result result = new Result();
        result.setPage(page);
        result.setList(all);
        
        return result;
    }
    
    //��ҳ��ʾȫ������
    public Result showArticleByPage(Page page) {
        page = PageUtil.createPage(page,articleDAO.queryAllCount());
        List<Article> all = articleDAO.queryAllByPage(page);
        Result result = new Result();
        result.setPage(page);
        result.setList(all);
        
        return result;
    }
    
    //��ʾ����
    public Article showArticle(int id) {
        return articleDAO.queryById(id);
    }
    
    //���������
    public int getCritiqueCount(int AId) {
        return critiqueDAO.queryCritiqueCount(AId);
    }
    
    //��������
    public Article updateArticle(String username, int id) {
        return articleDAO.updateArticle(username, id);
    }
    
    //ɾ������
    public void delArticle(String username, int id) {
        articleDAO.delArticle(username, id);
    }
}
