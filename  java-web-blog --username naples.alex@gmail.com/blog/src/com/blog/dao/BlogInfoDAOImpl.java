package com.blog.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.blog.po.BlogInfo;

public class BlogInfoDAOImpl extends HibernateDaoSupport implements BlogInfoDAO {
    //设置个性化内容
    public void save(BlogInfo info) {
        this.getHibernateTemplate().saveOrUpdate(info);
    }
    
    //获得博客信息
    public BlogInfo get(String username) {
        List list = this.getHibernateTemplate().find("select bloginfo from BlogInfo bloginfo where bloginfo.username=?", username);
        if (list.size() == 0) {
            return null;
        } else {
            return (BlogInfo)list.get(0);
        }
    }
}
