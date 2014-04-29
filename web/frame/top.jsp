<%@ page import="java.util.Date" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<HTML>
<HEAD>
    <meta http-equiv="Content-Language" content="zh-cn">
    <TITLE></TITLE>
    <META http-equiv=Content-Type content="text/html; charset=gb2312">
    <LINK href="../../css/style.css" type=text/css rel=stylesheet>
    <base target="_self">
    <script>
        function modifypsw()
        {
            var dw = window.showModalDialog('/crm/html/staff/updPwd.html', '', 'dialogHeight:180px; dialogWidth:260px; dialogLeft:500px; dialogTop:220px;edge:sunken;center:yes;location:no;help:no;resizable:no;status:no;scroll:no');
        }
    </script>

</HEAD>
<BODY bgColor=#CEEBFF leftMargin=0 topMargin=0 marginheight="0" marginwidth="0">

<table border="0" width="100%" cellspacing="0" cellpadding="0" id="table1" height="27">
    <tr>
        <td>
            <table border="0" width="100%" cellspacing="0" cellpadding="0" id="table2">
                <tr>
                    <td width="420">
                        <img border="0" src="../../images/topbg.jpg" width="436" height="80"></td>
                    <td background="../../images/topbg.jpg" valign="bottom">
                        <div align="right">
                            <table border="0" width="145" id="table7" cellspacing="0" cellpadding="0">
                                <tr>
                                    <td width="150" height="24"></td>
                                </tr>
                                <tr>
                                    <td width="150" height="35"><p align="right"><font
                                            color="#FFFFFF">欢迎您：<b>${user.name == null?user.account:user.name}</b></font></td>
                                </tr>
                            </table>
                        </div>
                    </td>
                    <td width="374" background="../../images/topright.jpg" valign="top">
                        <table border="0" width="100%" cellspacing="0" cellpadding="0" id="table4">
                            <tr>
                                <td>
                                    <div align="right">
                                        <table border="0" width="100%" cellspacing="0" cellpadding="0" id="table5">
                                            <tr>
                                                <td height="19">
                                                    <p align="center">
                                                        <img border="0" src="../../images/calendar.gif" align="right">&nbsp;
                                                </td>
                                                <td width="250"><font color="#ffffff">
                                                    <fmt:formatDate value="<%=new Date() %>" pattern="yyyy 年 MM 月 dd 日 E HH:mm:ss" />
                                                </font></td>
                                            </tr>
                                        </table>
                                    </div>
                                </td>
                            </tr>
                            <tr>
                                <td height="20">　</td>
                            </tr>
                            <tr>
                                <td>
                                    <div align="right">
                                        <table border="0" width="215" cellspacing="0" cellpadding="0" id="table6"
                                               height="23">
                                            <tr>
                                                <td width="31"><p align="center"><img border="0"
                                                                                      src="../../images/login.gif"></td>
                                                <td width="55" valign="middle"><a href="../login.html"
                                                                                  target="_top"><font color="ffffff"><s:a namespace="/admin" action="logout">重新登录</s:a> </font></a>
                                                </td>
                                            </tr>
                                        </table>
                                    </div>
                                </td>
                            </tr>
                        </table>
                    </td>
                </tr>
            </table>
        </td>
    </tr>
</table>
<table border="0" width="100%" cellspacing="0" cellpadding="0" height="10" id="table3">
    <tr>
        <td style="border-bottom: 1px solid #ffffff; filter: progid:dximagetransform.microsoft.gradient(startcolorstr='#0075C4', endcolorstr='#ffffff', gradienttype='1'">
            　
        </td>
    </tr>
</table>

</BODY>
</HTML>