package com.blog.service;

import java.util.Date;

import com.blog.dao.ViewRateDAO;
import com.blog.po.ViewRate;

public class ViewRateServiceImpl implements ViewRateService {
    private ViewRateDAO viewsRateDAO;
    
    public ViewRateDAO getViewRateDAO() {
        return viewsRateDAO;
    }

    public void setViewRateDAO(ViewRateDAO viewsRateDAO) {
        this.viewsRateDAO = viewsRateDAO;
    }

    public boolean isVistor(int AId, String IP, Date time) {
        if (viewsRateDAO.queryById(AId, IP, time).size() != 0) {
            System.out.println("该IP今天已经点击过了");
            //表示用户已经点击过了
            return true;
        } else {
            System.out.println("该IP今天没有点击过");
            ViewRate viewrate = new ViewRate();
            viewrate.setAId(AId);
            viewrate.setIp(IP);
            viewrate.setTime(time);
            
            //保存记录
            viewsRateDAO.addRecord(viewrate);
            return false;
        }
    }
}
