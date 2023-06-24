<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<jsp:include page="elements/index_head.jsp"></jsp:include>
<%
	String username = (String)session.getAttribute("loginuser");
	if(username != null)
		response.sendRedirect("bookServlet");
%>

<script type="text/javascript">
	//非空检查
	function isUsernameNull(){
		var username = document.getElementById("username").value;
		var usernull = document.getElementById("usernull");
		
		if(username == null || username == ""){
			usernull.innerHTML = "<font color=\"red\">用户名不能为空！</font>"
			return false;
		}else
			usernull.innerHTML = ""
		return true;
	}
	function isPasswordNull(){
		var password = document.getElementById("password").value;
		var pwdnull = document.getElementById("pwdnull");
		
		if(password == null || password == ""){
			pwdnull.innerHTML = "<font color=\"red\">密码不能为空！</font>"
			return false;
		}else
			pwdnull.innerHTML = ""
		return true;
	}
</script>

<body>
<div id="header" class="wrap">
	<div id="logo">北大青鸟网上书城</div>
	<div id="navbar">
	</div>
</div>
<div id="login">
	<h2>用户登陆</h2>
	<form method="post" action="loginServlet" >
		<dl>
			<dt>用户名：</dt>
			<dd><input class="input-text" type="text" id="username" name="username" onblur="isUsernameNull()"/><span id="usernull"></span></dd>
			<dt>密　码：</dt>
			<dd><input class="input-text" type="password" id="password" name="password" onblur="isPasswordNull()"/><span  id="pwdnull"></span></dd>
			<dt>&nbsp;</dt>
			<dd class="button"><input class="input-btn" type="submit" name="submit" value="" /><input class="input-reg" type="button" name="register" value="" onclick="window.location='register.jsp';" /></dd>
		</dl>
	</form>
</div>
<jsp:include page="elements/index_bottom.html"></jsp:include>

