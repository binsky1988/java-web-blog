package com.blog.service;

import com.blog.page.Page;
import com.blog.page.Result;
import com.blog.po.Critique;

public interface CritiqueService {
    //�������
    public void addCritique(Critique critique);
    
    //��ҳ��ʾ����
    public Result showCritiqueByPage(int AId,Page page);
    
    //���ָ�����µ�������
    public int getCritiqueCount(int AId);
}
