<%@page import="training.entity.Product"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Spring MVC Demo</title>
</head>
<body>
	<h1>Spring MVC Demo</h1>
	<hr />
	<div>
		<h2>Product list</h2>
		<a href="/springmvc/">Home</a>
		
		<div>
		<ul>
		<%
			@SuppressWarnings("unchecked")
			List<Product> list = (List<Product>) request.getAttribute("data");
			for(Product p: list){
				out.println("<li>" + p.getProductName() + " - $" + p.getUnitPrice() + "</li>");
			}
		%>
		</ul>
		</div>
	</div>
</body>
</html>






