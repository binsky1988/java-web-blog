package com.blog.dao;

import com.blog.po.BlogInfo;

public interface BlogInfoDAO {
    //���ø��Ի�����
    public void save(BlogInfo info);
    
    //��ò�����Ϣ
    public BlogInfo get(String username);
}
