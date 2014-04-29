<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="me" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<me:CommonForm title="查询课程" base="admin/lesson">
    <jsp:attribute name="submitButton">
        <button type="submit" class="btn-img"><img src="images/button/find.gif"/></button>
    </jsp:attribute>

    <jsp:body>
        <tr>
            <td width="10%">课程名称：</td>
            <td><s:textfield name="searcher.name"/></td>
        </tr>
        <tr>
            <td>课程简介：</td>
            <td><s:textfield name="searcher.description"/></td>
        </tr>
        <tr>
            <td>总学时：</td>
            <td><input type="text" size="12"/> 至 <input type="text" size="12"/></td>
        </tr>
        <tr>
            <td>课程费用：</td>
            <td><input type="text" size="12"/> 至 <input type="text" size="12"/></td>
        </tr>
    </jsp:body>

</me:CommonForm>

