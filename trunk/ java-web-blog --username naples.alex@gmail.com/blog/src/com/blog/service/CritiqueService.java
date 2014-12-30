package com.blog.service;

import com.blog.page.Page;
import com.blog.page.Result;
import com.blog.po.Critique;

public interface CritiqueService {
    //添加评论
    public void addCritique(Critique critique);
    
    //分页显示评论
    public Result showCritiqueByPage(int AId,Page page);
    
    //获得指定文章的评论数
    public int getCritiqueCount(int AId);
}
