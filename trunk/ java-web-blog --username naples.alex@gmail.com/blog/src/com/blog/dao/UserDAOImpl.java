package com.blog.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.blog.po.User;

public class UserDAOImpl extends HibernateDaoSupport implements UserDAO {
    //����û�
    public void add(User user) {
        this.getHibernateTemplate().save(user);
    }
    
    //ɾ���û�
    public void delete(User user) {
        
    }
    
    //�����û�
    public void update(User user) {
        
    }
    
    //��ѯ�����û�
    public List queryAll() {
        // TODO Auto-generated method stub
        return null;
    }

    //��ID��ѯ�û�
	public User queryByID(String username) {
		List list = this.getHibernateTemplate().find("select user from User user where user.username = '" + username + "'");
		
		if (list.size() == 0) {
			return null;
		} else {
			return (User)list.get(0);
		}
	}
}
