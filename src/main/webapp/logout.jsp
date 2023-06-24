<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	request.getSession().removeAttribute("loginuser");
	request.getSession().removeAttribute("books_in_cart");
	request.getSession().removeAttribute("books_in_cart_count");
	response.sendRedirect("login.jsp");
%>

