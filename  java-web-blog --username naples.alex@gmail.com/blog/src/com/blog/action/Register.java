package com.blog.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.blog.po.User;
import com.blog.service.UserService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class Register extends ActionSupport {
    private String username;
    private String password;
    private String repassword;
    private String nickname;
    private String question;
    private String answer;
    private UserService userService;
    
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getRepassword() {
        return repassword;
    }
    public void setRepassword(String repassword) {
        this.repassword = repassword;
    }
    public String getNickname() {
        return nickname;
    }
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
    public String getQuestion() {
        return question;
    }
    public void setQuestion(String question) {
        this.question = question;
    }
    public String getAnswer() {
        return answer;
    }
    public void setAnswer(String answer) {
        this.answer = answer;
    }
    public UserService getUserService() {
        return userService;
    }
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
    
    public String execute() throws Exception {
        //封装一个user对象
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setNickname(nickname);
        user.setQuestion(question);
        user.setAnswer(answer);
        
        //获得request
        HttpServletRequest request = ServletActionContext.getRequest();
        if (userService.registerUser(user)) {
            request.setAttribute("url", "login.jsp");
            request.setAttribute("info", "注册成功");
            return SUCCESS;
        } else {
            request.setAttribute("url", "register.jsp");
            request.setAttribute("info", "注册失败");
            return ERROR;
        }
    }

}
