package com.blog.service;

import java.util.List;

import com.blog.dao.CritiqueDAO;
import com.blog.page.Page;
import com.blog.page.PageUtil;
import com.blog.page.Result;
import com.blog.po.Article;
import com.blog.po.Critique;

public class CritiqueServiceImpl implements CritiqueService {
    private CritiqueDAO critiqueDAO;
    
    
    public CritiqueDAO getCritiqueDAO() {
        return critiqueDAO;
    }

    public void setCritiqueDAO(CritiqueDAO critiqueDAO) {
        this.critiqueDAO = critiqueDAO;
    }

    //�������
    public void addCritique(Critique critique) {
        critiqueDAO.addCritique(critique);
    }
    
    //��ҳ��ʾ����
    public Result showCritiqueByPage(int AId,Page page) {
        page = PageUtil.createPage(page,critiqueDAO.queryCritiqueCount(AId));
        List<Critique> all = critiqueDAO.queryByPage(AId, page);
        Result result = new Result();
        result.setPage(page);
        result.setList(all);
        
        return result;
    }
    
    //���ָ�����µ�������
    public int getCritiqueCount(int AId) {
        return critiqueDAO.queryCritiqueCount(AId);
    }
}
