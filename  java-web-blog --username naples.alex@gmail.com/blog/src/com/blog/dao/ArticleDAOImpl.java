package com.blog.dao;

import java.sql.SQLException;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.blog.page.Page;
import com.blog.po.Article;
public class ArticleDAOImpl extends HibernateDaoSupport implements ArticleDAO {

    //ʵ��add����
    public void add(Article article) {
        this.getHibernateTemplate().saveOrUpdate(article);
    }
    
    //����һ��queryUserAll,����ȡ���û�����������
    public List<Article> queryUserAll(String username) {
        List find = this.getHibernateTemplate().find("select art from Article art where art.username = ? order by art.date desc", username);
        List<Article> list = find;
        return list;
    }
    
    //����û������ܼ�¼��
    public int queryUserAllCount(String username) {
        List find = this.getHibernateTemplate().find("select count(*) from Article art where art.username = ?",username);
        return ((Long)find.get(0)).intValue();
    }
    
    //����ҳ��Ϣ��ѯ�û��ļ�¼
	public List<Article> queryByPage(final String username, final Page page) {
        return this.getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
			    Query query = session.createQuery("select art from Article art where art.username = ? order by art.date desc");
                //���ò���
                query.setParameter(0, username);
                //����ÿҳ��ʾ���ٸ������ö����
                query.setMaxResults(page.getEveryPage());
                //�������
                query.setFirstResult(page.getBeginIndex());
                return query.list();
			}
        });
    }
    
    //����������µ��ܼ�¼��
    public int queryAllCount() {
        List find = this.getHibernateTemplate().find("select count(*) from Article art");
        return ((Long)find.get(0)).intValue();
    }
    
    //����ҳ��Ϣ��ѯ��¼
	public List<Article> queryAllByPage(final Page page) {
		return this.getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				Query query = session.createQuery("select art from Article art order by art.date desc");
				//����ÿҳ��ʾ���ٸ������ö������
				query.setMaxResults(page.getEveryPage());
				//�������
				query.setFirstResult(page.getBeginIndex());
				return query.list();
			}
			
		});
	}

    //��ID��ѯ����
    public Article queryById(int id) {
        List find = this.getHibernateTemplate().find("select art from Article art where art.id = ?", id);
        return (Article) find.get(0);
    }
    
    //���û��������±����ѯ����
    public Article updateArticle(String username, int id) {
        Article article = new Article();
        List list = this.getHibernateTemplate().executeFind(new HibernateCallback() {
            public Object doInHibernate(Session session) throws HibernateException, SQLException {
                Query query = session.createQuery("select art from Article art where art.username = ? and art.id = ?");
                //���ò���
                query.setParameter(0, username);
                query.setParameter(1, id);
                
                return query.list();
            }
        });
        
        for (Iterator ite = list.iterator(); ite.hasNext();) {
            article = (Article) ite.next();
        }
        
        return article;
    }
    
    //ɾ������
    public void delArticle(String username, int id) {
        List list = this.getHibernateTemplate().executeFind(new HibernateCallback() {
            public Object doInHibernate(Session session) throws HibernateException, SQLException {
                //��ɾ�������¼
                Query delViewRate = session.createQuery("delete ViewRate as vr where vr.AId = ?");
                delViewRate.setInteger(0, id);
                delViewRate.executeUpdate();
                session.beginTransaction().commit();
                
                //Ȼ��ɾ�����¶�Ӧ������
                Query delCritique = session.createQuery("delete Critique as ctq where ctq.AId = ?");
                delCritique.setInteger(0, id);
                delCritique.executeUpdate();
                session.beginTransaction().commit();
                
                //��ɾ�����±���
                Query delArticle = session.createQuery("delete Article as art where art.username = ? and art.id = ?");
                delArticle.setParameter(0, username);
                delArticle.setInteger(1, id);
                delArticle.executeUpdate();
                session.beginTransaction().commit();
                
                return null;
            }
        });
    }
}
