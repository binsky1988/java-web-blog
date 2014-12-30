package com.blog.dao;

import com.blog.po.BlogInfo;

public interface BlogInfoDAO {
    //设置个性化内容
    public void save(BlogInfo info);
    
    //获得博客信息
    public BlogInfo get(String username);
}
