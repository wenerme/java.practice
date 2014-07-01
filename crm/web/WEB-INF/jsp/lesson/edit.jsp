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

<s:form action="%{#action}" namespace="/admin/lesson" method="POST">
    <s:if test="#action == 'edit'">
        <s:hidden name="id"/>
    </s:if>

    <table border="0" cellspacing="0" cellpadding="0" class="wukuang" width="100%">
        <tr>
            <td width="1%"><img src="images/tleft.gif"/></td>
            <td width="44%" align="left">[ <s:property value='#action == "add"?"添加":"编辑" '/>课程 ]</td>

            <td width="52%" align="right">
                <!--<a href="listLog.html"><img src="images/button/find.gif" class="img"/></a>
                <a href="addLog.html"><img src="images/button/add.gif" class="img"/></a>~-->

                <!-- <a href="#"><img src="images/button/close.gif" class="img"/></a>-->
                <button type="submit" class="btn-img"><img src="images/button/save.gif"/></button>
                <a href="#" onclick="history.go(-1)"><img src="images/button/tuihui.gif"/></a>

            </td>
            <td width="3%" align="right"><img src="images/tright.gif"/></td>
        </tr>
    </table>

    <table width="88%" border="0" class="emp_table" style="width:80%;">
        <tr>
            <td width="10%">课程类别：</td>
            <td width="20%"><s:textfield name="name"/> </td>
            <td width="8%">总学时：</td>
            <td width="62%"><s:textfield name="period"/></td>
        </tr>
        <tr>
            <td>课程费用：</td>
            <td><s:textfield name="cost"/></td>
            <td>课程简介：</td>
            <td><s:textfield name="description"/> </td>
        </tr>
    </table>
</s:form>
</body>
</html>
