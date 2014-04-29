<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <base href="/"/>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>无标题文档</title>
    <link href="css/sys.css" type="text/css" rel="stylesheet"/>

</head>

<body class="emp_body">
<table border="0" cellspacing="0" cellpadding="0" width="100%">
    <tr>
        <td class="topg"></td>
    </tr>
</table>
<form action="/admin/employee/edit" method="POST">
    <s:fielderror/>

    <s:hidden name="id"/>
    <table border="0" cellspacing="0" cellpadding="0" class="wukuang" width="100%">
        <tr>
            <td width="1%"><img src="images/tleft.gif"/></td>
            <td width="44%" align="left">[员工管理]</td>

            <td width="52%" align="right">
                <button class="btn-img" type="submit"><img src="images/button/save.gif"/></button>
                <s:a  onclick="window.history.go(-1)" action="list" namespace="/admin/employee"><img src="images/button/tuihui.gif"/></s:a>

            </td>
            <td width="3%" align="right"><img src="images/tright.gif"/></td>
        </tr>
    </table>

    <table width="88%" border="0" class="emp_table" style="width:80%;">
        <tr>
            <td>姓名：</td>
            <td><s:textfield name="name"/></td>
            <td>性别：</td>
            <td><s:select list="#{'Male':'男','Female':'女'}" name="sex"/></td>
        </tr>
        <tr>
            <td width="10%">出生日期：</td>
            <td width="20%"><s:textfield name="birthday"/></td>
            <td width="8%">入职时间：</td>
            <td width="62%"><s:textfield name="joinDate"/></td>
        </tr>
        <tr>
            <td width="10%">所属部门：</td>
            <td width="20%">
                <s:select name="department.id"
                          headerValue="------请选择------" headerKey=""
                        list="departments" listValue="name" listKey="id"/>
            </td>
            <td width="8%">编号：</td>
            <td width="62%"><s:textfield name="number"/></td>
        </tr>
    </table>
</form>
</body>
</html>
