package com.blog.dao;

import java.util.List;

import com.blog.po.User;

public interface UserDAO {
    //����û�
    public void add(User user);
    
    //ɾ���û�
    public void delete(User user);
    
    //�����û�
    public void update(User user);
    
    //��ѯ�����û�
    public List queryAll();
    
    //��ID��ѯ�û�
    public User queryByID(String username);
}
