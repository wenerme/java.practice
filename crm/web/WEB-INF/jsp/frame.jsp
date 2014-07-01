<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <base href="/"/>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>CRM系统</title>
</head>

<frameset rows="90,*" framespacing="0px" frameborder="no">
    <frame src="frame/top.jsp" scrolling="no"/>
    <frameset id="main" cols="170,9,*" framespacing="0px" frameborder="no">
        <frameset rows="30,*,40" framespacing="0px" frameborder="no">
            <frame src="frame/left1.html" scrolling="no"/>
            <frame src="frame/left.html" scrolling="no"/>
            <frame src="frame/left2.html" scrolling="no"/>
        </frameset>
        <frame src="frame/control.html" scrolling="no"/>
        <frame src="frame/right.html" name="right" scrolling="no"/>
    </frameset>
</frameset>
</html>
