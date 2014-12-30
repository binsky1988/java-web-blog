package com.blog.dao;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.blog.po.ViewRate;

public class ViewRateDAOImpl extends HibernateDaoSupport implements ViewRateDAO {
    //ָ�����¡���IP����ʱ��ķ��ʼ�¼
    public List queryById(int AId, String IP, Date time) {
        return this.getHibernateTemplate().executeFind(new HibernateCallback() {
            public Object doInHibernate(Session session) throws HibernateException, SQLException {
                Query query = session.createQuery("select vr from ViewRate vr where vr.AId = ? and vr.ip = ? and vr.time = ?");
                //���ò���
                query.setParameter(0, AId);
                query.setParameter(1, IP);
                query.setParameter(2, time);
                
                return query.list();
            }
        });
    }
    
    //��ӷ��ʼ�¼
    public void addRecord(ViewRate views) {
        this.getHibernateTemplate().save(views);
    }
}
