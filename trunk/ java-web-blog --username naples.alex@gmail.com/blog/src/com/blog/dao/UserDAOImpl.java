package com.blog.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.blog.po.User;

public class UserDAOImpl extends HibernateDaoSupport implements UserDAO {
    //添加用户
    public void add(User user) {
        this.getHibernateTemplate().save(user);
    }
    
    //删除用户
    public void delete(User user) {
        
    }
    
    //更新用户
    public void update(User user) {
        
    }
    
    //查询所有用户
    public List queryAll() {
        // TODO Auto-generated method stub
        return null;
    }

    //按ID查询用户
	public User queryByID(String username) {
		List list = this.getHibernateTemplate().find("select user from User user where user.username = '" + username + "'");
		
		if (list.size() == 0) {
			return null;
		} else {
			return (User)list.get(0);
		}
	}
}
