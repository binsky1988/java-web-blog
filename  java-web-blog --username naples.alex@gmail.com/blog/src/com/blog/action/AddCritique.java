package com.blog.action;

import java.util.Map;

import com.blog.po.Critique;
import com.blog.service.CritiqueService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class AddCritique extends ActionSupport {
    private CritiqueService critiqueService;
    private int id;
    private String content;
    
    public CritiqueService getCritiqueService() {
        return critiqueService;
    }
    public void setCritiqueService(CritiqueService critiqueService) {
        this.critiqueService = critiqueService;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    } 
    
    public String execute() throws Exception {
        Map session = ActionContext.getContext().getSession();
        String username = (String) session.get("username");
        Critique critique = new Critique();
        if(username == null || "".equals(username)) {
            critique.setUsername("ÄäÃû");
        } else {
            critique.setUsername(username);
        }
        critique.setAId(id);
        critique.setContent(content);

        // ±£´æÆÀÂÛ
        this.critiqueService.addCritique(critique);

        return this.SUCCESS;
    }
}
