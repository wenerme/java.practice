<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<html>
<head>
<title>客户关系管理系统</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="${pageContext.request.contextPath}/menu/css/top.css"
	rel="stylesheet" type="text/css">
</head>
<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0">
	<table width="100%" height="100%" border="0" cellpadding="0"
		cellspacing="0" class="top">
		<tr>
			<td class="logo">
				<div class="subNav">
					<br>管理员<font color="red">${admin.username}</font>，欢迎您！现在是：
					<fmt:formatDate value="<%=new Date() %>" pattern="yyyy 年 MM 月 dd 日 E HH:mm:ss" />
					| <a
						href="${pageContext.request.contextPath}/menu/logout"
						target="_parent">退出 
						</a>
				</div>
			</td>
		</tr>
	</table>
</body>
</html>
