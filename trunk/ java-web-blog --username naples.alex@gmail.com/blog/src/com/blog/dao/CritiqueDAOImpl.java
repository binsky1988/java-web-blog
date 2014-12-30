package com.blog.dao;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.blog.page.Page;
import com.blog.po.Critique;

public class CritiqueDAOImpl extends HibernateDaoSupport implements CritiqueDAO {
    //添加评论
    public void addCritique(Critique critique) {
        this.getHibernateTemplate().save(critique);
    }
    
    //获得指定文章的评论数
    public int queryCritiqueCount(int AId) {
        List find = this.getHibernateTemplate().find("select count(*) from Critique cri where cri.AId = ?",AId);
        return ((Long)find.get(0)).intValue();
    }
    
    //根据Page来查询指定文章的评论
    public List<Critique> queryByPage(final int AId,Page page) {
        return this.getHibernateTemplate().executeFind(new HibernateCallback() {
            public Object doInHibernate(Session session) throws HibernateException, SQLException {
                Query query = session.createQuery("select cri from Critique cri where cri.AId = ?");
                query.setParameter(0, AId);
                
                //设置每页显示多少个，设置多大结果。
                query.setMaxResults(page.getEveryPage());
                
                //设置起点
                query.setFirstResult(page.getBeginIndex());
                
                return query.list();
            }
        });
    }
    
}
