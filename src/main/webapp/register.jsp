<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<jsp:include page="elements/index_head.jsp"></jsp:include>
<script type="text/javascript">
	//全部输入项非空检查
	//检查用户名是否存在
	function isUsernameLegal(){
		var username = document.getElementById("username").value;
		var usernull = document.getElementById("usernull");
		//使用Ajax检查用户是否存在		
		if(username == null || username == ""){
			usernull.innerHTML = "<font color=\"red\">用户名不能为空！</font>"
			return false;
		}
		isUserExsit();
		return true;
	} 
	//检查密码内容位数
	function isPasswordLegal(){
		var password = document.getElementById("password").value;
		var pwdnull = document.getElementById("nullpassword");
		
		if(password == null || password == ""){
			pwdnull.innerHTML = "<font color=\"red\">密码不能为空！</font>"
			return false;
		}else if(password.length < 8){
			pwdnull.innerHTML = "<font color=\"red\">密码长度小于8位！！</font>"
			return false;
		}else
			pwdnull.innerHTML = ""
		return true;
	}
	//检查密码是否一致
	function isRepasswordLegal(){
		var repassword = document.getElementById("rePassword").value;
		var password = document.getElementById("password").value;
		var pwdnull = document.getElementById("nullrePassword");
		
		if(repassword == null || repassword == ""){
			pwdnull.innerHTML = "<font color=\"red\">确认密码不能为空！</font>"
			return false;
		}else if(repassword != password){
			pwdnull.innerHTML = "<font color=\"red\">两次密码输入不一致！</font>"
			return false;
		}else
			pwdnull.innerHTML = ""
		return true;
	}
	//检查邮箱格式是否正确
	function isEmailLegal(){
		var email = document.getElementById("email").value;
		var emailnull = document.getElementById("nullemail");
		
		var regEx = /^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\.[a-zA-Z_-]+)+$/;
		
		if(email == null || email == ""){
			emailnull.innerHTML = "<font color=\"red\">邮箱不能为空！</font>"
			return false;
		}else if(!regEx.test(email)){
			emailnull.innerHTML = "<font color=\"red\">邮箱格式不正确！</font>"
			return false;
		}else
			emailnull.innerHTML = ""
		return true;
	}
		
</script>

<body>
<div id="header" class="wrap">
	<div id="logo">北大青鸟网上书城</div>
	<div id="navbar">
	</div>
</div>
<div id="register">
	<div class="title">
		<h2>欢迎注册北大青鸟网上书城</h2>
	</div>
	<div class="steps">
		<ul class="clearfix">
			<li class="current">1.填写注册信息</li>
			<li class="unpass">2.注册成功</li>
		</ul>
	</div>
	<form method="post" action="registerServlet" "  >
		<dl>
			<dt>用 户 名：</dt>
			<dd><input class="input-text" type="text" id="username" name="username" onblur="isUsernameLegal()"/><span id="usernull"></span><span id="alreadyExsits"></span></dd>
			<dt>密　　码：</dt>
			<dd><input class="input-text" type="password" id="password" name="password" onblur="isPasswordLegal()" /><span id="nullpassword"><font color=\"green\">密码至少8位</font></span><span id="simplepassword"></span></dd>
			<dt>确认密码：</dt>
			<dd><input class="input-text" type="password" id="rePassword" name="rePassword" onblur="isRepasswordLegal()" /><span id="nullrePassword"></span><span id="uneq"></span></dd>
			<dt>Email地址：</dt>
			<dd><input class="input-text" type="text" id="email" name="email" onblur="isEmailLegal()" /><span id="nullemail"><font color=\"green\">请输入正确格式的邮箱</font></span><span id="errorInput"></span></dd>
			<dt></dt>
			<dd class="button"><input class="input-reg" type="submit" name="register" value="" /></dd>
		</dl>
	</form>
</div>	
<jsp:include page="elements/index_bottom.html"></jsp:include>
