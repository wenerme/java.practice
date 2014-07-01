<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <base href="/"/>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <link rel="stylesheet" href="css/sys.css" type="text/css"/>
    <title>班级管理</title>
</head>

<body>
<!--距离页面顶端5px-->
<table border="0" cellspacing="0" cellpadding="0">
    <tr>
        <td class="topg"> <s:fielderror/> </td>
    </tr>
</table>
<form name="createForm" action="" method="post">
    <table border="0" cellspacing="0" cellpadding="0" class="wukuang">
        <tr>
            <td width="1%"><img src="images/tleft.gif"/></td>
            <td width="20%" align="left">[班级管理]</td>
            <td width="42%" align="center">&nbsp;</td>
            <td width="36%" align="right">
                <a href="clazz/add"><img src="images/button/tianjia.gif" class="img"/></a>
                <a href="clazz/search"><img src="images/button/gaojichaxun.gif" class="img"/></a>
            </td>
            <td width="1%"><img src="images/tright.gif"/></td>
        </tr>
    </table>
</form>
<table border="0" cellspacing="0" cellpadding="0">
    <tr>
        <td class="topg"></td>
    </tr>
</table>
<table border="0" cellspacing="0" cellpadding="0">
    <tr>
        <td><img src="images/result.gif"/></td>
    </tr>
</table>
<table width="97%" border="1">
    <thead>
    <tr class="henglan" style="font-weight:bold;">
        <th width="10%" align="center">班级名称</th>
        <th width="10%" align="center">所属课程</th>
        <th width="10%" align="center">开班时间</th>
        <th width="10%" align="center">毕业时间</th>
        <th width="10%" align="center">状态</th>
        <th width="10%" align="center">学生总数</th>
        <th width="5%" align="center">编辑</th>
        <th width="5%" align="center">查看</th>
    </tr>
    </thead>
    <tbody>

    <s:iterator value="#session.page.items" var="item" status="s">
        <tr class="tabtd<s:property value="(#s.count%2) + 1"/>">
            <td align="center">${item.name}</td>
            <td align="center">${item.lesson.name}</td>
            <td align="center">${item.startDate}</td>
            <td align="center">${item.endDate}</td>
            <td align="center">${item.state}</td>
            <td align="center">${fn:length(item.students)}</td>
            <td width="7%" align="center">
                <a href="admin/clazz/edit?ids=${item.id}"><img src="images/button/modify.gif" class="img"></a>
                <a  onclick="return window.confirm('确定删除 [ ${item.name} ] 么?')"
                    href="admin/clazz/delete?ids=${item.id}"><img src="images/button/delete.gif" class="img"></a>
            </td>
            <td align="center">
                <a href="admin/clazz/view?ids=${item.id}"><img src="images/button/view.gif" class="img"></a>
            </td>
        </tr>
    </s:iterator>

    </tbody>
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
