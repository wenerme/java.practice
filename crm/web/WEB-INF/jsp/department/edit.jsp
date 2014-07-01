<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<s:set var="action" value="#context['struts.actionMapping'].name"/>

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
        <td class="topg"> <s:fielderror/> </td>
    </tr>
</table>

<s:form action="%{#action}" namespace="/admin/department" method="POST">
    <s:if test="#action == 'edit'">
        <s:hidden name="id"/>
    </s:if>

    <table border="0" cellspacing="0" cellpadding="0" class="wukuang" width="100%">
        <tr>
            <td width="1%"><img src="images/tleft.gif"/></td>
            <td width="44%" align="left">
                [ <s:property value='#action == "add"?"添加":"编辑" '/>部门 ]
            </td>

            <td width="52%" align="right">
                <button class="btn-img" type="submit"><img src="images/button/save.gif"/></button>
                <a onclick="window.history.go(-1)" href="#"><img src="images/button/tuihui.gif"/></a>

            </td>
            <td width="3%" align="right"><img src="images/tright.gif"/></td>
        </tr>
    </table>

    <table width="88%" border="0" class="emp_table" style="width:80%;">
        <tr>
            <td>部门名称：</td>
            <td><s:textfield name="name"/></td>
        </tr>
        <tr>
            <td width="10%">部门介绍：</td>
            <td></td>
        </tr>
        <tr>
            <td width="10%"></td>
            <td>
                <s:textarea name="description"/>
            </td>
        </tr>
    </table>

</s:form>
</body>
</html>
