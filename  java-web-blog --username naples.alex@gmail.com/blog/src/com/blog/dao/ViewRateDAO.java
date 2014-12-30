package com.blog.dao;

import java.util.Date;
import java.util.List;

import com.blog.po.ViewRate;

public interface ViewRateDAO {
    //指定文章、该IP、该时间的访问记录
    public List queryById(int AId, String IP, Date time);
    
    //添加访问记录
    public void addRecord(ViewRate views);
}
