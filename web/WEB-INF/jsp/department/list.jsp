<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <base href="/"/>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>ACTION:<s:property value="#context['struts.actionMapping'].name"/> </title>

    <link href="css/sys.css" type="text/css" rel="stylesheet"/>

</head>

<body>
<table border="0" cellspacing="0" cellpadding="0" width="100%">
    <tr>
        <td class="topg"> <s:fielderror/> </td>
    </tr>
</table>

<table border="0" cellspacing="0" cellpadding="0" class="wukuang" width="100%">
    <tr>
        <td width="1%"><img src="images/tleft.gif"/></td>
        <td width="39%" align="left">[部门管理]</td>

        <td width="57%" align="right">
            <a href="admin/department/add"><img src="images/button/tianjia.gif"/></a>
            <%--<a href="admin/department/search"><img src="images/button/gaojichaxun.gif"/></a>--%>
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
        <td width="6%" align="center">部门名称</td>
        <td width="7%" align="center">编辑</td>
    </tr>

    <s:iterator value="#session.page.items" var="item" status="s">
        <tr class="tabtd<s:property value="(#s.count%2) + 1"/>">
            <td align="center">${item.name}</td>
            <td width="7%" align="center">
                <a href="admin/department/edit?ids=${item.id}"><img src="images/button/modify.gif" class="img"></a>
                <a  onclick="return window.confirm('确定删除 [ ${item.name} ] 么?')"
                    href="admin/department/delete?ids=${item.id}"><img src="images/button/delete.gif" class="img"></a>
            </td>
        </tr>
    </s:iterator>

</table>
<table border="0" cellspacing="0" cellpadding="0" align="center">
    <tr>
        <td align="right">
            <span>第1/3页</span>
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
