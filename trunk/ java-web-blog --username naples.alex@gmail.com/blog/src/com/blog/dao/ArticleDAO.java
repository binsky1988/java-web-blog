package com.blog.dao;

import java.util.List;

import com.blog.page.Page;
import com.blog.po.Article;

public interface ArticleDAO {
    //�������·���
    public void add(Article article);
    
    //ȡ���û��������·���
    public List<Article> queryUserAll(String username);
    
    //����û������ܼ�¼������
    public int queryUserAllCount(String username);
    
    //��ҳ��ѯ�û���¼
    public List<Article> queryByPage(String username, Page page);
    
    //������������ܼ�¼������
    public int queryAllCount();
    
    //����ҳ��Ϣ��ѯ��¼
    public List<Article> queryAllByPage(Page page);
    
    //��ID��ѯ����
    public Article queryById(int id);
    
    //��������
    public Article updateArticle(String username, int id);
}
