package com.blog.dao;

import java.util.List;

import com.blog.page.Page;
import com.blog.po.Critique;

public interface CritiqueDAO {
    //�������
    public void addCritique(Critique critique);
    
    //���ָ�����µ�������
    public int queryCritiqueCount(int AId);
    
    //����Page��ָ����ѯ���µ�������
    public List<Critique> queryByPage(int AId, Page page);
}
