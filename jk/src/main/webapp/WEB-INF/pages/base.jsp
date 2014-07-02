<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>

<link rel="stylesheet" rev="stylesheet" type="text/css" href="${ctx}/skin/default/css/default.css" media="all"/>
<script language="javascript" src="${ctx}/js/common.js"></script>

<script language="javascript" src="${ctx}/validator/CheckImp.js"></script>
<script language="javascript" src="${ctx}/validator/CheckErrControl.js"></script>
<script language="javascript" src="${ctx}/validator/CheckFrame.js"></script>

<div id="ErrDIV" style="overflow:hidden;FILTER: alpha(opacity=80);position:absolute;left:807px;top:58px;width:300;height:150;z-index:15;display:none; margin-right:0; margin-bottom:0" ondragstart="start(event.x, event.y)" ondrag="move(event.x, event.y)" ondragend="end()">
	<IFrame id="ErrFrame" frameborder="0" src="${ctx}/validator/ErrMsg.html" style="overflow:hidden"></IFrame>
</div>
