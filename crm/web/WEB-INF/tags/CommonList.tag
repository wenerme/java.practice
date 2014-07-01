<%@tag description="通用的 List 页面" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@attribute name="title" required="true" %>
<%@attribute name="base" required="true" %>
<%@attribute name="withOperactionCoulumn" type="java.lang.Boolean" description="显示操作列, 默认为显示" %>
<%@attribute name="withSearch" %>
<%@attribute name="withAdd" %>
<%@attribute name="withView" description="附带浏览操作" %>
<%@attribute name="thead" required="true" fragment="true" %>
<%@attribute name="tbody" required="true" fragment="true" %>
<%@attribute name="extraOperaction" fragment="true" description="额外的操作,显示在操作列上" %>
<%@attribute name="extraTitleOperaction" fragment="true" description="额外的操作,显示在标题上" %>

<c:if test="${withOperactionCoulumn == null}"><c:set var="withOperactionCoulumn" value="${true}" /></c:if>

<!DOCTYPE html>
<html lang="zh">
<head>
    <base href="/"/>
    <meta charset="utf-8">
    <title></title>
    <link href="css/sys.css" type="text/css" rel="stylesheet"/>

</head>
<body>
<table border="0" cellspacing="0" cellpadding="0" width="100%">
    <tr>
        <td class="topg"><s:fielderror/></td>
    </tr>
</table>

<table border="0" cellspacing="0" cellpadding="0" class="wukuang" width="100%">
    <tr>
        <td width="1%"><img src="images/tleft.gif"/></td>
        <td width="39%" align="left">
            <%--显示标题--%>
            [<c:out value="${title}"/>]
        </td>

        <td width="57%" align="right">

            <%--特定操作的实现--%>
            <c:if test="${withAdd}">
                <a href="<c:out value="${base}"/>/add"><img src="images/button/tianjia.gif"/></a>
            </c:if>
            <c:if test="${withSearch}">
                <a href="<c:out value="${base}"/>/search"><img src="images/button/gaojichaxun.gif"/></a>
            </c:if>
            <%--在这里显示额外的标题操作--%>
            <jsp:invoke fragment="extraTitleOperaction"/>

        </td>
        <td width="3%" align="right"><img src="images/tright.gif"/></td>
    </tr>
</table>
<table border="0" cellspacing="0" cellpadding="0" style="margin-top:5px;">
    <tr>
        <td><img src="images/result.gif"/></td>
    </tr>
</table>
<table width="97%" border="1">

    <tr class="henglan" style="font-weight:bold;">
        <%--指定需要显示的列--%>
        <jsp:invoke fragment="thead"/>
        <%--额外的操作列--%>
        <c:if test="${withOperactionCoulumn}">
            <td width="11%" align="center">操作</td>
        </c:if>
    </tr>

    <s:iterator value="#session.page.items" var="item" status="s">
        <tr class="tabtd<s:property value="(#s.count%2) + 1"/>">

            <%--指定需要显示的内容--%>
            <jsp:invoke fragment="tbody"/>

            <%--显示操作列的具体操作--%>
            <c:if test="${withOperactionCoulumn}">

                <td align="center" class="operation-column">
                    <a title="编辑" href="<c:out value="${base}"/>/edit?ids=${item.id}">
                        <img src="images/button/modify.gif" class="img">
                    </a>

                    <a title="删除" onclick="return window.confirm('确定删除 [ ${item.name} ] 么?')"
                       href="<c:out value="${base}"/>/delete?ids=${item.id}">
                        <img src="images/button/delete.gif" class="img">
                    </a>

                    <c:if test="${withView}">
                        <a title="查看" href="<c:out value="${base}"/>/delete?ids=${item.id}">
                            <img src="images/button/view.gif" class="img"></a>
                    </c:if>

                    <%--在这里显示额外的列操作--%>
                    <jsp:invoke fragment="extraOperaction"/>

                </td>
            </c:if>
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
