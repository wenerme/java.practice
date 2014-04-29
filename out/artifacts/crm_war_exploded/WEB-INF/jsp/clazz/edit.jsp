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
        <td class="topg"></td>
    </tr>
</table>

<s:form action="%{#action}" namespace="/admin/clazz" method="POST">
    <s:if test="#action == 'edit'">
        <s:hidden name="id"/>
    </s:if>

    <table border="0" cellspacing="0" cellpadding="0" class="wukuang" width="100%">
        <tr>
            <td width="1%"><img src="images/tleft.gif"/></td>
            <td width="44%" align="left">[编辑班级]</td>

            <td width="52%" align="right">
                <!--<a href="listLog.html"><img src="images/button/find.gif" class="img"/></a>
                <a href="addLog.html"><img src="images/button/add.gif" class="img"/></a>~-->

                <!-- <a href="#"><img src="images/button/close.gif" class="img"/></a>-->
                <button class="btn-img" type="submit"><img src="images/button/save.gif"/></button>
                <a onclick="history.go(-1)" href="#"><img src="images/button/tuihui.gif"/></a>

            </td>
            <td width="3%" align="right"><img src="images/tright.gif"/></td>
        </tr>
    </table>

    <table width="88%" border="0" class="emp_table" style="width:80%;">
        <tr>
            <td width="10%">班级名称：</td>
            <td width="20%"><s:textfield name="name"/></td>
            <td width="8%">所属课程：</td>
            <td width="62%">
                <s:select name="lesson.id"
                          headerKey=""
                          headerValue="------请选择------"
                          list="lessonList"
                          listTitle="description"
                          listKey="id"
                          listValue="name"/>
            </td>
        </tr>
        <tr>
            <td>开课时间：</td>
            <td><s:textfield name="startDate" value="%{getFormatted(endDate,'yyyy-MM-dd')}"/></td>
            <td>结业时间：</td>
            <td><s:textfield name="endDate" value="%{getFormatted(endDate,'yyyy-MM-dd')}"/></td>
        </tr>
        <tr>
            <td>状态：</td>
            <td><s:textfield name="state"/></td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
        </tr>

    </table>
</s:form>

</body>
</html>
