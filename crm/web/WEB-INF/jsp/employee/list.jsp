<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <base href="/"/>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>无标题文档</title>

    <link href="css/sys.css" type="text/css" rel="stylesheet"/>
</head>

<body>
<table border="0" cellspacing="0" cellpadding="0" width="100%">
    <tr>
        <td class="topg"></td>
    </tr>
</table>

<table border="0" cellspacing="0" cellpadding="0" class="wukuang" width="100%">
    <tr>
        <td width="1%"><img src="images/tleft.gif"/></td>
        <td width="39%" align="left">[员工管理]</td>

        <td width="57%" align="right">
            <a href="admin/employee/search"><img src="images/button/gaojichaxun.gif"/></a>
        </td>
        <td width="3%" align="right"><img src="images/tright.gif"/></td>
    </tr>
</table>
<table border="0" cellspacing="0" cellpadding="0" style="margin-top:5px;">
    <tr>
        <td><img src="images/result.gif"/></td>
    </tr>
</table>
<table width="100%" border="1">
    <tr class="henglan" style="font-weight:bold;">
        <td width="10%" align="center">编号</td>
        <td width="10%" align="center">员工姓名</td>
        <td width="6%" align="center">性别</td>
        <td width="12%" align="center">出生日期</td>
        <td width="12%" align="center">入职时间</td>
        <td width="15%" align="center">所属部门</td>
        <td width="10%" align="center">编辑</td>
    </tr>

    <s:iterator value="#session.page.items" var="item" status="s">
        <tr class="tabtd<s:property value="(#s.count%2) + 1"/>">
            <td align="center">${item.number}</td>
            <td align="center">${item.name}</td>
            <td align="center">${item.sex.text}</td>
            <td align="center">
                <fmt:formatDate value="${item.birthday}" pattern="yyyy年MM月dd日" />
            </td>
            <td align="center">
                <fmt:formatDate value="${item.joinDate}" pattern="yyyy年MM月dd日" />
            </td>
            <td align="center">
                    ${item.department.name}
            </td>
            <td width="7%" align="center">
                <a href="admin/employee/edit?ids=${item.id}"><img src="images/button/modify.gif" class="img"></a>
                <a onclick="return window.confirm('确定删除 [ ${item.name} ] 么?')"
                   href="admin/employee/delete?ids=${item.id}"><img src="images/button/delete.gif" class="img"></a>
            </td>
        </tr>
    </s:iterator>

</table>
<table border="0" cellspacing="0" cellpadding="0" align="center">
    <tr>
        <td align="right">
            <span>共${page.itemCount}个结果 当前第${page.currentPage + 1}/${page.pageCount}页</span>
        <span>
        	<a href="#">[首页]</a>&nbsp;&nbsp;
            <a href="#">[上一页]</a>&nbsp;&nbsp;
            <a href="#">[下一页]</a>&nbsp;&nbsp;
            <a href="#">[尾页]</a>
        </span>
        </td>
    </tr>
</table>
</body>
</html>
