<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML>
<HTML>
<HEAD>
    <base href="/"/>
    <STYLE>
        .cla1
        {
            FONT-SIZE: 12px;
            COLOR: #4b4b4b;
            LINE-HEIGHT: 18px;
            TEXT-DECORATION: none
        }

        .login_msg
        {
            font-family: serif;
        }

        .login_msg .msg
        {
            background-color: #acf;
        }

        .login_msg .btn
        {
            background-color: #9be;
            width: 73px;
            font-size: 18px;
            font-family: 微 软 雅 黑;
        }
    </STYLE>
    <TITLE>${pageContext.request.contextPath}</TITLE>
    <META http-equiv=Content-Type content="text/html; charset=utf-8">
    <LINK href="css/style.css" type=text/css rel=stylesheet>
</HEAD>
<BODY leftMargin=0 topMargin=0 marginwidth="0" marginheight="0" background="images/rightbg.jpg">
<div ALIGN="center">
    <table border="0" width="1140px" cellspacing="0" cellpadding="0" id="table1">
        <tr>
            <td height="93"></td>
            <td><!-- 显示错误信息 --><s:fielderror /> </td>
        </tr>
        <tr>
            <td background="images/right.jpg" width="740" height="412"></td>
            <td class="login_msg" width="400">
                <form action="admin/login" method="post" >
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src="images/title.png" width="185" height="26"/><br/><br/>
                    用户名：<input class="msg" name="account" type="text"><br/><br/>
                    密&nbsp;&nbsp;码：<input class="msg" name="password" type="text"><br/><br/>
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    <input class="btn" type="submit" value=" 登录 "/>

                    <input class="btn" type="button" value=" 注册 "
                           onclick="document.location='/admin/register'"/>

                </form>
            </td>
        </tr>
    </table>
</div>
</BODY>
</HTML>