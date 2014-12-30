package com.blog.dao;

import java.util.List;

import com.blog.page.Page;
import com.blog.po.Critique;

public interface CritiqueDAO {
    //添加评论
    public void addCritique(Critique critique);
    
    //获得指定文章的评论数
    public int queryCritiqueCount(int AId);
    
    //根据Page来指定查询文章的评论数
    public List<Critique> queryByPage(int AId, Page page);
}
