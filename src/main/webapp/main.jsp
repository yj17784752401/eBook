<%@ page language="java" import="java.util.*" pageEncoding="utf-8" isELIgnored="false"%>
<%@page import="cn.wenli.yujiang.util.PageTools"%>
<%@page import="cn.wenli.yujiang.entity.Books"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<jsp:include page="elements/main_head.html"/>
<%
	String username = (String)session.getAttribute("loginuser");
	if(username == null)
		response.sendRedirect("login.jsp");
%>
 <%
	int currentPage = 0;
	int totalPage = 0;
	List<Books> books = (List<Books>)request.getAttribute("books");
	if(request.getAttribute("current_page") != null){
		currentPage = (Integer)request.getAttribute("current_page");
		totalPage = (Integer)request.getAttribute("totalPage");
	}
%> 
<body>
<jsp:include page="elements/main_menu.jsp"/> 
<div id="content" class="wrap">
	<div class="list bookList">
		<form method="post" name="shoping" action="/yujiang/shopListServlet">
			<table>
				<tr class="title">
					<th class="checker"></th>
					<th>书名</th>
					<th class="price">价格</th>
					<th class="store">库存</th>
					<th class="view">图片预览</th>
				</tr>
				<c:forEach var="book" items="${books}">
					<tr>
						<td><input type="checkbox" name="bookId" value="${book.bid}" /></td>
						<td class="title">${book.bookname}</td>
						<input type="hidden" name="title" value = "${book.bid}:${book.bookname}"/>
						<td>￥${book.b_price}</td>
						<input type="hidden" name="price" value = "${book.bid}:${book.b_price}"/>
						<td>${book.stock}</td>
						<input type="hidden" name="stock" value = "${book.bid}:${book.stock}"/>
						<td class="thumb"><img src="${book.image}" /></td>
						<input type="hidden" name="image" value = "${book.bid}:${book.image}"/>
					</tr>
				</c:forEach>
			</table>
		 	<%if(request.getAttribute("current_page") != null){ %>
			<div class="page-spliter">
				<a href="bookServlet?current_page=<%=1%>">首页</a>
					<%for(int i = 1; i <=totalPage ; i++){ %>
						<%if(i == currentPage){ %>
							<span class="current"><%=i %></span>
						<%continue;}%>
						<a href="bookServlet?current_page=<%=i %>"><%=i %></a>
					<%} %>
				<a href="bookServlet?current_page=<%=totalPage %>">尾页</a>
			</div>
			<%} %> 
			<div class="button"><input class="input-btn" type="submit" name="submit" value="" /></div>
		</form>
	</div>
</div>
</body>
<jsp:include page="elements/main_bottom.html"/>