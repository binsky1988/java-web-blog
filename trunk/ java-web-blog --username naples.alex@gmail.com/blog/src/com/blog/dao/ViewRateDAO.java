package com.blog.dao;

import java.util.Date;
import java.util.List;

import com.blog.po.ViewRate;

public interface ViewRateDAO {
    //ָ�����¡���IP����ʱ��ķ��ʼ�¼
    public List queryById(int AId, String IP, Date time);
    
    //��ӷ��ʼ�¼
    public void addRecord(ViewRate views);
}
