<%@page language="java" contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="me" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="s" uri="/struts-tags" %>

<me:CommonEdit title="正式学员" base="admin/student/school">
    <jsp:body>
        <tr>
            <td width="8%" align="left">姓名：</td>
            <td width="19%" align="left"><s:textfield name="name"/></td>
            <td width="7%" align="left">QQ：</td>
            <td width="19%" align="left"><s:textfield name="QQ"/></td>
            <td width="7%" align="left">学校：</td>
            <td width="40%" align="left"><s:textfield name="school"/></td>
        </tr>
        <tr>
            <td align="left">年龄：</td>
            <td align="left"><s:textfield name="age"/></td>
            <td align="left">性别：</td>
            <td align="left"><me:Sex/></td>
            <td align="left">电话：</td>
            <td align="left"><s:textfield name="phone"/></td>
        </tr>
        <tr>
            <td align="left">联系地址：</td>
            <td align="left"><s:textfield name="address"/></td>
            <td align="left">专业：</td>
            <td align="left"><s:textfield name="major"/></td>
            <td align="left">学历：</td>
            <td align="left"><s:textfield name="education"/></td>
        </tr>
        <tr>
            <td colspan="6"><br/>班级：</td>
        </tr>
        <tr>
            <td colspan="6" align="left">
                <table width="73%" class="emp_table" style="width:50%; border:1px solid #CCC; margin-left:0"
                       align="left">
                    <tr>
                        <td width="7%" align="center">&nbsp;</td>
                        <td width="20%" align="center">班级名称</td>
                        <td width="21%" align="center">开班时间</td>
                        <td width="18%" align="center">课程</td>
                        <td width="34%" align="center">已报人数</td>
                    </tr>
                    <tr>
                        <td align="center"><input type="radio"/></td>
                        <td align="center">&nbsp;</td>
                        <td align="center">&nbsp;</td>
                        <td align="center">&nbsp;</td>
                        <td align="center">&nbsp;</td>
                    </tr>
                    <tr>
                        <td align="center"><input type="radio"/></td>
                        <td align="center">&nbsp;</td>
                        <td align="center">&nbsp;</td>
                        <td align="center">&nbsp;</td>
                        <td align="center">&nbsp;</td>
                    </tr>
                    <tr>
                        <td align="center"><input type="radio"/></td>
                        <td align="center">&nbsp;</td>
                        <td align="center">&nbsp;</td>
                        <td align="center">&nbsp;</td>
                        <td align="center">&nbsp;</td>
                    </tr>
                    <tr>
                        <td align="center">&nbsp;</td>
                        <td align="center">&nbsp;</td>
                        <td align="center">&nbsp;</td>
                        <td align="center">&nbsp;</td>
                        <td align="center">&nbsp;</td>
                    </tr>
                </table>
            </td>
        </tr>
        <tr>
            <td height="38">&nbsp;</td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
        </tr>
        <tr>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
        </tr>
    </jsp:body>
</me:CommonEdit>

