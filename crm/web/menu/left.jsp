<%@ page language="java" pageEncoding="UTF-8"%>
<html>
	<head>
		<title>菜单</title>
		<link rel="stylesheet"
			href="${pageContext.request.contextPath}/menu/css/jquery.treeview.css" />
		<link rel="stylesheet"
			href="${pageContext.request.contextPath}/menu/css/screen.css" />
		<script
			src="${pageContext.request.contextPath}/menu/js/jquery-1.4.2.js"
			type="text/javascript"></script>
		<script
			src="${pageContext.request.contextPath}/menu/js/jquery.treeview.js"
			type="text/javascript"></script>
		<script type="text/javascript">
	$( function() {
		$("#tree").treeview( {
			collapsed : true,
			animated : "medium",
			control : "#sidetreecontrol",
			persist : "location"
		});
	})
</script>

	</head>
	<body ondblclick="ToggleNav();">
		<div id="main">
			<div id="sidetree">
				<div class="treeheader">
					操作菜单
				</div>

				<div id="sidetreecontrol">
					<a href="#">全收起</a> |
					<a href="#">全展开</a>
				</div>
				<ul id="tree">
					<li>
						<img
							src="${pageContext.request.contextPath}/ui/images/menu/xtsz.png"
							width="17" height="17">
						<strong>系统设置</strong>
						<ul>
							<li>
								<img
									src="${pageContext.request.contextPath}/ui/images/menu/bmsz.png"
									width="17" height="17">
								<a href="${pageContext.request.contextPath}/GroupAction?action=list"
									target="rightFrame">部门设置</a>
							</li>
							<li>
								<img
									src="${pageContext.request.contextPath}/ui/images/menu/rsgl.png"
									width="17" height="17">
								<a href="${pageContext.request.contextPath}/UserAction?action=list"
									target="rightFrame">人事管理</a>
							</li>
						</ul>
					</li>
	</body>
</html>


