<%@ page language="java" contentType="text/html; charset=gb2312"
	pageEncoding="gb2312"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv = "Content-Type" content = "text/html; charset = gb2312">
    <title>博客系统首页</title>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<link type="text/css" rel="stylesheet" href="css/main.css" media="all" />
	<!--[if IE 6]><link type="text/css" rel="stylesheet" href="css/ie6.css" media="all" /><![endif]-->
    <script type="text/javascript" src="js/mootools.js"></script>
    <script type="text/javascript" src="js/site.js"></script>
</head>
<body>
	<div id = "wrapper">
		<div id = "container">
			<div id = "scene"><img src="images/scene.jpg" alt="" />
				<h1>博客网站系统</h1>
      			<div id="scale_area">
        			<div id="scale_knob">&raquo; Font Size &laquo;</div>
      			</div>
      			<div id="menu">
        			<div class="holder"> <a href="showAllArticle.action">博客首页</a> </div>
        			<div class="holder"> <a href="register.jsp">新博客注册</a> </div>
        			<div class="holder"> <a href="login.jsp">博客登录</a> </div>
      			</div>
			</div>
			<div id = "content">
				<div id = "col_left">
					<div class = "post">
						<div class = "meta"><a class="title" href="">博客系统首页</a>
							<div class="clear"></div>
						</div>
						<!-- 从数据库中取出文章 -->
						<s:iterator value = "#request.all" id = "art" status = "sta">
							<div class = "comments">
								<div class = "comment">
									<div class="meta"> 
										<span >
											<a href = "user/showArticle.action?username = <s:property value = '#art.username'/> &id = <s:property value = '#art.id'/>"><s:property value="#art.title"/></a> <small>:</small>
										</span>
										<div class="clear"> </div>
									</div>
								</div>
								<div class = "comment alt">
									<div class = "meta">
										<span class = "datetime">
											发表于:
											<s:date name="#art.date"/>
											|评论数:<s:property value = "#request.critiqueCounts[#sta.index]"/>|点击数:<s:property value="#art.hasread"/>|作者:<s:property value="#art.username"/>
										</span>
										<div class="clear"> </div>
									</div>
								</div>
							</div>
						</s:iterator>
						<div class = "comment" align = "center">
							当前第${page.currentPage}页，共${page.totalPage}页，每页显示${page.everyPage}条记录
							<s:if test = "#request.page.hasPrePage">
								<a href = "showAllArticle.action?currentPage = 1">首页</a>
								<a href = "showAllArticle.action?currentPage = ${page.currentPage - 1}">上一页</a>
							</s:if>
							<s:else>
								首页
								上一页
							</s:else>
							<s:if test = "#request.page.hasNextPage">
								<a href = "showAllArticle.action?currentPage = ${page.currentPage + 1}">下一页</a>
								<a href = "showAllArticle.action?currentPage = ${page.totalPage}">尾页</a>
							</s:if>
							<s:else>
								下一页
								尾页
							</s:else>
						</div>
					</div>
				</div>
				<div id = "col_right">
					<div id="search_box">
						<form action = "http://www.baidu.com" method = "post">
							<div>
              					<input type="text" name="search" />
            				</div>
            				<div class="button_wrapper">
              					<input type="submit" value="Search" class="button" />
            				</div>
            				<div class="clear"> </div>
						</form>
					</div>
					<div id="sidebar">
						<h2>页面导航</h2>
          					<ul>
            					<li><a href="showAllArticle.action">博客首页</a></li>
            					<li><a href="register.jsp">新博客注册</a></li>
            					<li><a href="login.jsp">博客登录</a></li>
          					</ul>
					</div>
				</div>
				<div class="clear"> </div>
				<div id = "footer">
					<div class="clear"> </div>
      					<hr />
      					<p class="credit">博客网站系统</p>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
