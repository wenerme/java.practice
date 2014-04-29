<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="me" tagdir="/WEB-INF/tags" %>
<me:CommonList title="课程类别" base="admin/lesson"
               withAdd="true" withSearch="true">

    <jsp:attribute name="thead">
        <td width="14%" align="center">名称</td>
        <td width="33%" align="center">简介</td>
        <td width="13%" align="center">总学时</td>
        <td width="18%" align="center">收费标准</td>
    </jsp:attribute>

    <jsp:attribute name="tbody">
        <td align="center">${item.name}</td>
        <td align="center">${item.description}</td>
        <td align="center">${item.period}</td>
        <td align="center">${item.cost}</td>
    </jsp:attribute>

</me:CommonList>