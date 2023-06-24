<%@ page language="java" import="java.util.*" pageEncoding="utf-8" isELIgnored="false"%>
<%
	String username = (String)session.getAttribute("loginuser");
	if(username == null)
		response.sendRedirect("login.jsp");
%>
<jsp:include page="elements/main_head.html"/>
<body>
<jsp:include page="elements/main_menu.jsp"/>
<div id="content" class="wrap">
	<div class="success">
		<div class="information">
			<p>恭喜：添加成功！</p>
			<p><a href="shopping.jsp">点此查看购物车详情&gt;&gt;</a></p>
		</div>
	</div>
</div>
</body>
<jsp:include page="elements/main_bottom.html"/>
