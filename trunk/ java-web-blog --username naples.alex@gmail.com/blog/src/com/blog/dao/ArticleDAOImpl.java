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

    //实现add方法
    public void add(Article article) {
        this.getHibernateTemplate().saveOrUpdate(article);
    }
    
    //定义一个queryUserAll,用来取出用户的所有文章
    public List<Article> queryUserAll(String username) {
        List find = this.getHibernateTemplate().find("select art from Article art where art.username = ? order by art.date desc", username);
        List<Article> list = find;
        return list;
    }
    
    //获得用户文章总记录数
    public int queryUserAllCount(String username) {
        List find = this.getHibernateTemplate().find("select count(*) from Article art where art.username = ?",username);
        return ((Long)find.get(0)).intValue();
    }
    
    //按分页信息查询用户的记录
	public List<Article> queryByPage(final String username, final Page page) {
        return this.getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
			    Query query = session.createQuery("select art from Article art where art.username = ? order by art.date desc");
                //设置参数
                query.setParameter(0, username);
                //设置每页显示多少个，设置多大结果
                query.setMaxResults(page.getEveryPage());
                //设置起点
                query.setFirstResult(page.getBeginIndex());
                return query.list();
			}
        });
    }
    
    //获得所有文章的总记录数
    public int queryAllCount() {
        List find = this.getHibernateTemplate().find("select count(*) from Article art");
        return ((Long)find.get(0)).intValue();
    }
    
    //按分页信息查询记录
	public List<Article> queryAllByPage(final Page page) {
		return this.getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				Query query = session.createQuery("select art from Article art order by art.date desc");
				//设置每页显示多少个，设置多大结果。
				query.setMaxResults(page.getEveryPage());
				//设置起点
				query.setFirstResult(page.getBeginIndex());
				return query.list();
			}
			
		});
	}

    //按ID查询文章
    public Article queryById(int id) {
        List find = this.getHibernateTemplate().find("select art from Article art where art.id = ?", id);
        return (Article) find.get(0);
    }
    
    //按用户名和文章标题查询文章
    public Article updateArticle(String username, int id) {
        Article article = new Article();
        List list = this.getHibernateTemplate().executeFind(new HibernateCallback() {
            public Object doInHibernate(Session session) throws HibernateException, SQLException {
                Query query = session.createQuery("select art from Article art where art.username = ? and art.id = ?");
                //设置参数
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
    
    //删除文章
    public void delArticle(String username, int id) {
        List list = this.getHibernateTemplate().executeFind(new HibernateCallback() {
            public Object doInHibernate(Session session) throws HibernateException, SQLException {
                //先删除点击记录
                Query delViewRate = session.createQuery("delete ViewRate as vr where vr.AId = ?");
                delViewRate.setInteger(0, id);
                delViewRate.executeUpdate();
                session.beginTransaction().commit();
                
                //然后删除文章对应的评论
                Query delCritique = session.createQuery("delete Critique as ctq where ctq.AId = ?");
                delCritique.setInteger(0, id);
                delCritique.executeUpdate();
                session.beginTransaction().commit();
                
                //再删除文章本身
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
