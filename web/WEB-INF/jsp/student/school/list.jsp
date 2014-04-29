<%@page language="java" contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="me" tagdir="/WEB-INF/tags" %>
<me:CommonList title="在校学生管理" base="admin/student/school"
               withAdd="true" withSearch="true" withView="true">

    <jsp:attribute name="thead">
        <td width="10%" align="center">姓名</td>
        <td width="10%" align="center">班级</td>
        <td width="10%" align="center">QQ</td>
        <td width="10%" align="center">联系电话</td>
    </jsp:attribute>

    <jsp:attribute name="tbody">
        <td align="center">${item.name}</td>
        <td align="center">${item.clazz.name}</td>
        <td align="center">${item.QQ}</td>
        <td align="center">${item.phone}</td>
    </jsp:attribute>

</me:CommonList>
