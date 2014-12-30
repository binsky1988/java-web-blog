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

    //设置博客个性化内容
    public void setBlogInfo(BlogInfo blogInfo) {
        blogInfoDAO.save(blogInfo);
    }
    
    //获得博客个性化内容
    public BlogInfo getBlogInfo(String username) {
        return blogInfoDAO.get(username);
    }
}
