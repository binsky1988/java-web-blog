<%@ page language="java" contentType="text/html; charset=utf-8"
		pageEncoding="utf-8"%>
<%@ taglib uri="http://java.fckeditor.net" prefix="FCK"%>		
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="en" xml:lang="en">
<head>
	<title>修改文章</title>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<link type="text/css" rel="stylesheet" href="../css/main.css" media="all" />
	<!--[if IE 6]><link type="text/css" rel="stylesheet" href="css/ie6.css" media="all" /><![endif]-->
	<script type="text/javascript" src="../js/mootools.js"></script>
	<script type="text/javascript" src="../js/site.js"></script>
</head>
<body>
	<div id="wrapper">
		<div id="container">
			<div id="scene"> <img src="../images/scene.jpg" alt="" />
				<h1>${empty sessionScope.blogtitle ? "博客网站系统":sessionScope.blogtitle} <br/>
						<font size="8">${empty sessionScope.idiograph ? "我的签名":sessionScope.idiograph}</font>
						</h1>
				<div id="scale_area">
					<div id="scale_knob">&raquo; Font Size &laquo;</div>
				</div>
				<div id="menu">
					<div class="holder"> <a href="../showAllArticle.action">博客首页</a> </div>
					<div class="holder"> <a href="showUserAllArticle.action">用户首页</a> </div>
					<div class="holder"> <a href="editbloginfo.jsp">个性化设置</a> </div>
					<div class="holder"> <a href="addArticle.jsp">写日志</a> </div>
					<div class="holder"> <a href="showPhoto.action">相册</a> </div>
				</div>
			</div>
			<div id="content">
				<div id="col_left">
					<div class="post">
						<div class="meta"></div>
						<div class="comments"><div class="comment"></div>
							<h2>修改文章</h2>
							<%
							    //从表单获得数据
                                String username = request.getParameter("username");
                                int id = Integer.parseInt(request.getParameter("id"));
                                String title = request.getParameter("title");
                                String content = request.getParameter("content");
                            %>
							<form class = "h" action = "updateArticle.action?username=<%= username%>&id=<%= id%>" method = "post">
								<div>
									<label>标题：</label>
									<input type="text" name="title" value="<%=title%>"/>
								</div>
								<div>
									<label>内容：</label>
									<FCK:editor instanceName="content" basePath="/user/fckeditor" toolbarSet="myToolbar" height="400" value = "<%=content%>"></FCK:editor>
								</div>
								<div>
									<label></label>
									<div class="clear"> </div>
								</div>
								<div class="button_wrapper">
									<input name="提交" type="submit" class="button" value="提交" />
								</div>
							</form>
						</div>
					</div>
				</div>
				<div id="col_right">
					<div id="search_box">
						<form action="http://www.865171.cn/" method="post">
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
							<li><a href="../showAllArticle.action">博客首页</a></li>
						<li><a href="showUserAllArticle.action">用户首页</a></li>
						<li><a href="editbloginfo.jsp">个性化设置</a></li>
						<li><a href="addArticle.jsp">写日志</a></li>
				 		<li><a href="showPhoto.action">相册</a></li>
						</ul>
					</div>
				</div>
				<div class="clear"> </div>
			</div>
			<div id="footer">
				<div class="clear"> </div>
				<hr />
				<p class="credit">博客网站系统</p>
			</div>
		</div>
	</div>
</body>
</html>
