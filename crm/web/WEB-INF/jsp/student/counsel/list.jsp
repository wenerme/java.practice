<%@page language="java" contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="me" tagdir="/WEB-INF/tags" %>

<me:CommonList title="咨询学生管理" base="admin/student/counsel"
               withAdd="true" withSearch="true" withView="true">

    <jsp:attribute name="thead">
        <td width="8%" align="center">姓名</td>
        <td width="6%" align="center">性别</td>
        <td width="9%" align="center">电话</td>
        <td width="11%" align="center">QQ</td>
        <td width="15%" align="center">班级意向</td>
    </jsp:attribute>

    <jsp:attribute name="tbody">
        <td align="center">${item.name}</td>
        <td align="center">${item.sex.text}</td>
        <td align="center">${item.phone}</td>
        <td align="center">${item.QQ}</td>
        <td align="center">${item.intentionClass.name}</td>
    </jsp:attribute>

    <jsp:attribute name="extraOperaction">
        <%--入学编班操作--%>
        <a href="${base}/arrange?ids=${item.id}" title="入学编班">
            <img src="images/button/modify.gif" class="img">
        </a>
    </jsp:attribute>

</me:CommonList>
