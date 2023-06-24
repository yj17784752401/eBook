<%@ page language="java" import="java.util.*" pageEncoding="gbk" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%
	String username = (String)session.getAttribute("loginuser");
	if(username == null)
		response.sendRedirect("login.jsp");
%>
<jsp:include page="elements/main_head.html"/>
<script type="text/javascript">
	//�޸�����ʱ������Ajax�ı乺�ﳵ�ڵ���Ϣ
	function modify(size_str, i , bid_str){
		
		var xmlHttp;
		//���ݲ�ͬ�������ʼ��xmlHttp
		try{
			//IE 6+
			xmlHttp = new ActiveXObject("Msxml2.XMLHTTP");				
		}catch(e){
			try{
				//FireFox
				xmlHttp = new XMLHttpRequest();		
			}catch(e){
				try{
					//IE 5.5+
					xmlHttp =  new ActiveXObject("Microsoft.XMLHTTP");
				}catch(e){
					alert("�����������֧��Ajax��");
				}
			}
		}
		var num_str = document.getElementById("nums_" + i);	
		xmlHttp.open("GET", "alterShopListServlet?action=modify&bid="+bid_str+"&count="+num_str.value, true);		
		xmlHttp.send(null);	
		xmlHttp.onreadystatechange = function()
		{
			if( xmlHttp.readyState == 4 )
			{
				count(size_str);
			}
		}
	}
	//���㹺�ﳵ�ڼ۸���Ϣ
	function count(size_str){
		var size = parseFloat(size_str);
		var total_price = 0;
		for(var i = 1; i <= size; i++ ){			
			var num_str = document.getElementById("nums_" + i);
			var price = document.getElementById("price_" + i);
			var hidden_price = document.getElementById("hidden_book_total_price_" + i);
			var book_price_str = document.getElementById("hidden_" + i);
			var num = parseFloat(num_str.value);
			var book_price = parseFloat(book_price_str.value);
			price.innerHTML = num * book_price;
			hidden_price.value = num * book_price;
			total_price = total_price + num * book_price;
		}
		var hidden_total_price = document.getElementById("hidden_total_price");
		hidden_total_price.value = total_price;
		document.getElementById("total_price").innerHTML = total_price;
	}
	//�ӹ��ﳵ���Ƴ��鼮
	function remove(bid_str, NO, size_str){		
		var xmlHttp;
		//���ݲ�ͬ�������ʼ��xmlHttp
		try{
			//IE 6+
			xmlHttp = new ActiveXObject("Msxml2.XMLHTTP");				
		}catch(e){
			try{
				//FireFox
				xmlHttp = new XMLHttpRequest();		
			}catch(e){
				try{
					//IE 5.5+
					xmlHttp =  new ActiveXObject("Microsoft.XMLHTTP");
				}catch(e){
					alert("�����������֧��Ajax��");
				}
			}
		}		
		xmlHttp.open("GET", "alterShopListServlet?action=remove&bid="+bid_str, true);		
		xmlHttp.send(null);	
		xmlHttp.onreadystatechange = function()
		{
			if( xmlHttp.readyState == 4 )
			{
				document.getElementById("remove_" + NO).innerHTML = "<font color=\"green\">�Ƴ����</font>";
				document.getElementById("nums_" + NO).value = "0";
				document.getElementById("nums_" + NO).disabled="disabled";
				count(size_str, 0 ,0);
			}
		}
	
	

	}
	
</script>
<body onload="count(${books_in_cart_count})">
<jsp:include page="elements/main_menu.jsp"/>
<div id="content" class="wrap">
	<div class="list bookList">
		<form method="post" name="shoping" action="addItemServlet">
			<table>
				<tr class="title">
					<th class="view">ͼƬԤ��</th>
					<th>����</th>
					<th class="nums">����</th>
					<th class="price">�۸�</th>
					<th class="nums">����</th>
				</tr>
				<c:set value="1" var="count" />
				<c:forEach var="book" items="${books_in_cart}" >
					<tr>
						<input type="hidden" id="hidden_bid_${count}" name="hidden_bid_${count}" value="${book.bid}"/>
						<td class="thumb"><img src="${book.image}" /></td>
						<td class="title">"${book.bookname }"</td>
						<td><input class="input-text" type="text" id="nums_${count}" name="nums_${count}" value="${book.count}"  onchange="modify(${books_in_cart_count}, ${count}, ${book.bid})"/></td>
						<input type="hidden" id="hidden_${count}" name="hidden_${count}" value="${book.b_price}"/>
						<td>��<span id="price_${count}"></span></td>
						<input type="hidden" id="hidden_book_total_price_${count}" name="hidden_book_total_price_${count}"/>
						<td><span id="remove_${count}"><a href="#" onclick="remove(${book.bid}, ${count}, ${books_in_cart_count})">�Ƴ�</a></span></td>
					</tr>
					<c:set value="${count+1}" var="count" />
				</c:forEach></table>
				<input type="hidden" id="count" name="count" value="${count}"/>
			<div class="button">
				<h4>�ܼۣ���<span id="total_price"></span>Ԫ</h4>
				<input type="hidden" id="hidden_total_price" name="hidden_total_price"/>
				<input class="input-chart" type="submit" name="submit" value="" />
			</div>
		</form>
	</div>
</div>
<script type="text/javascript">
document.write(${book.b_price});
</script>
</body>
<jsp:include page="elements/main_bottom.html"/>
