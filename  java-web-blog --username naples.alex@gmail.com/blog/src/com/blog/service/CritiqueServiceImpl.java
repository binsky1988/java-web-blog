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

    //添加评论
    public void addCritique(Critique critique) {
        critiqueDAO.addCritique(critique);
    }
    
    //分页显示评论
    public Result showCritiqueByPage(int AId,Page page) {
        page = PageUtil.createPage(page,critiqueDAO.queryCritiqueCount(AId));
        List<Critique> all = critiqueDAO.queryByPage(AId, page);
        Result result = new Result();
        result.setPage(page);
        result.setList(all);
        
        return result;
    }
    
    //获得指定文章的评论数
    public int getCritiqueCount(int AId) {
        return critiqueDAO.queryCritiqueCount(AId);
    }
}
