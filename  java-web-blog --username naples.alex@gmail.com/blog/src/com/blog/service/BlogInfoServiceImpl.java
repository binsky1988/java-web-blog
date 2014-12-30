package com.blog.service;

import com.blog.dao.BlogInfoDAO;
import com.blog.po.BlogInfo;

public class BlogInfoServiceImpl implements BlogInfoService {
    private BlogInfoDAO blogInfoDAO;
    
    public BlogInfoDAO getBlogInfoDAO() {
        return blogInfoDAO;
    }

    public void setBlogInfoDAO(BlogInfoDAO blogInfoDAO) {
        this.blogInfoDAO = blogInfoDAO;
    }

    //���ò��͸��Ի�����
    public void setBlogInfo(BlogInfo blogInfo) {
        blogInfoDAO.save(blogInfo);
    }
    
    //��ò��͸��Ի�����
    public BlogInfo getBlogInfo(String username) {
        return blogInfoDAO.get(username);
    }
}
