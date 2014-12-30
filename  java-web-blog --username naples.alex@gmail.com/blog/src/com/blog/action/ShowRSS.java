package com.blog.action;

import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.blog.page.Page;
import com.blog.page.Result;
import com.blog.po.Article;
import com.blog.rss.CreateRss;
import com.blog.service.ArticleService;
import com.opensymphony.xwork2.ActionSupport;

public class ShowRSS extends ActionSupport {
    private ArticleService articleService;

    public ArticleService getArticleService() {
        return articleService;
    }

    public void setArticleService(ArticleService articleService) {
        this.articleService = articleService;
    }
    
    public String execute() throws Exception {
        Page page = new Page();     //��ҳ��Ϣ
        page.setCurrentPage(0);     //���õ�ǰҳΪ��һҳ
        page.setEveryPage(10);      //ÿҳ��ʾ10����¼
        Result result = articleService.
            showArticleByPage(page);//ͨ������ҵ���߼��������ɲ�ѯ
        page = result.getPage();
        List<Article> all = result.getList();//������½����
        String filePath = ServletActionContext.
            getServletContext().getRealPath("/rss.xml");//���ö����ļ���ַ
        CreateRss.publishRss(all, filePath);//д�붩���ļ�
        return this.SUCCESS;
    }
}
