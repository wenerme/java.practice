<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
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
            font-family: 微 软 雅 黑;
        }

        .login_msg .btn
        {
            background-color: #9be;
            width: 73px;
            font-size: 18px;
            font-family: 微 软 雅 黑;
        }

        .register_title
        {
            font-size: 32px;
            font-family: "微软雅黑";
            color: #02d;
        }

        .login_msg_field
        {
            font-family: "微软雅黑";
        }
    </STYLE>

    <TITLE></TITLE>
    <META http-equiv=Content-Type content="text/html; charset=utf-8">
    <LINK href="css/style.css" type=text/css rel=stylesheet>
    <META content="MSHTML 6.00.2600.0" name=GENERATOR>
</HEAD>
<BODY leftMargin=0 topMargin=0 marginwidth="0" marginheight="0" background="images/rightbg.jpg">
<div ALIGN="center">
    <table border="0" width="1140px" cellspacing="0" cellpadding="0" id="table1">
        <tr>
            <td height="93"></td>
            <td><!-- 显示错误信息 --><s:fielderror /></td>
        </tr>
        <tr>
            <td background="images/right.jpg" width="740" height="412"></td>
            <td class="login_msg" width="400">
                <form class="login_msg_field" action="admin/register" method="post">
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="register_title">新用户注册</span><br/><br/>
                    用&nbsp;&nbsp;户&nbsp;&nbsp;名：<s:textfield name="account" cssClass="msg" /><br/><br/>
                    密&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码：<s:password cssClass="msg" name="password"/><br/><br/>
                    姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名：<s:textfield name="name" cssClass="msg" /><br/><br/>
                    性&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;别：
                    <s:select list="#{'Male':'男','Female':'女'}" name="sex"/><br/><br/>
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    <input class="btn" type="submit" value=" 注册 "/>

                    <input class="btn" type="button" value=" 取消 " onclick="document.location='/admin/login'"/>

                </form>
            </td>
        </tr>
    </table>
</div>
</BODY>
</HTML>