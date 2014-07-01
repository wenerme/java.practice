<%@page language="java" contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="me" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<me:CommonEdit title="${action == 'edit'? '编辑':'添加'}咨询学生" base="admin/student/counsel">
    <jsp:body>
        <tr>
            <td width="7%" height="35" align="left">姓名：</td>
            <td width="18%" align="left"><s:textfield name="name"/></td>
            <td width="8%" align="left">联系地址：</td>
            <td width="19%" align="left"><s:textfield name="address"/></td>
            <td width="7%" align="left">意向班级：</td>
            <td width="41%" align="left">
                <s:select name="intentionClass.id"
                   headerKey=""
                   headerValue="------请选择------"
                   list="classList"
                   listTitle="description"
                   listKey="id"
                   listValue="name"/>
            </td>
        </tr>
        <tr>
            <td height="25" align="left">学校：</td>
            <td align="left"><s:textfield name="school"/></td>
            <td align="left">QQ：</td>
            <td align="left"><s:textfield name="QQ"/></td>
            <td align="left">电话：</td>
            <td align="left"><s:textfield name="phone"/></td>
        </tr>
        <tr>
            <td height="28" align="left">年龄：</td>
            <td align="left"><s:textfield name="age"/></td>
            <td align="left">性别：</td>
            <td align="left"><me:Sex/></td>
            <td align="left">学历：</td>
            <td align="left"><s:textfield name="education"/></td>
        </tr>
        <tr>
            <td height="27">备注：</td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
        </tr>
        <tr>
            <td height="77">&nbsp;</td>
            <td colspan="5"><s:textarea name="remark"/></td>
        </tr>
        <tr>
            <td>&nbsp;</td>
            <td colspan="5" style="padding-left:250px;"></td>
        </tr>
    </jsp:body>
</me:CommonEdit>

