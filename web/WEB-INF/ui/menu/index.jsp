<!DOCTYPE html>
<html lang="zh" class="page-menu">
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">

	<link href="/assets/metro/css/metro-bootstrap.css" rel="stylesheet">
	<link href="/assets/metro/css/metro-bootstrap-responsive.css" rel="stylesheet">

	<!--<link href="assets/bootstrap/css/bootstrap-combined.min.css" rel="stylesheet">-->
	<link href="/assets/bootstrap/css/metro-bootstrap.css" rel="stylesheet">

	<link href="/assets/js/jquery/layout-default-latest.css" rel="stylesheet">

	<link href="/assets/iconFont.css" rel="stylesheet">
	<link href="/assets/font-awesome.min.css" rel="stylesheet">

	<link href="/style/main.less" rel="stylesheet/less">

	<!-- Load JavaScript Libraries -->
	<script src="/assets/js/jquery/jquery.min.js"></script>
	<script src="/assets/js/jquery/jquery.ui.js"></script>
	<script src="/assets/js/jquery/jquery.widget.min.js"></script>
	<script src="/assets/js/jquery/jquery.mousewheel.js"></script>
	<script src="/assets/js/jquery/jquery.layout-latest.js"></script>
	<script src="/assets/bootstrap/js/bootstrap.min.js"></script>

	<script src="/assets/js/less.min.js"></script>

	<script src="/js/main.js"></script>

	<title>客户关系管理系统</title>
	<script>
		window.METRO_AUTO_REINIT = true;
		$(function ()
		{
			var option = {north: {}, west: {}};
			option.north.spacing_open = 0;
			option.north.size = 50;
			option.west.size = 250;
			$('body').layout(option);
			$('body > .ui-layout-center').layout(option);
		});
	</script>
</head>
<body class="metro">
<!--main banner-->

<div class="ui-layout-center no-padding">

	<!--center-->
	<div id="center-part" class="ui-layout-center">

	</div>
	<!--/end center-->

	<!--north-->
	<div id="north-part" class="ui-layout-north">
		<div class="times inverse inline-block pull-right" data-role="times" data-blink="false"></div>

		<div class="inline-block">
			管理员 xxx 你好
			<button class="">退出登录</button>
		</div>

		<button class="page-nav-backward"><i class="icon-arrow-left"></i></button>
		<button class="page-nav-forward"><i class="icon-arrow-right"></i></button>
		<button class="page-nav-refresh"><i class="fa fa-refresh"></i></button>
	</div>
	<!--/north-->
</div>
<!--/Center-->

<!--west-->
<div id="west-part" class="ui-layout-west no-padding">
	<nav class="sidebar dark">
		<ul>
			<li class="title">客户关系管理</li>
			<li class="active"><a href=dashbboard" class="page-url"><i class="icon-home"></i>主面板</a></li>
			<li class="stick bg-yellow">
				<a class="dropdown-toggle" href="#"><i class="icon-tree-view"></i>日常管理</a>
				<ul class="dropdown-menu" data-role="dropdown">
					<li><a href="/sys/user/list" class="page-url"><i class="fa fa-user"></i>人事管理</a></li>
					<li><a href="/sys/group/list" class="page-url"><i class="fa fa-users"></i>部门管理</a></li>
					<li class="divider"></li>
					<li><a href="#">其他管理</a></li>
				</ul>
			</li>
			<li><a href="faq" class="page-url"><i class="fa fa-question-circle"></i>常见问题</a></li>
		</ul>
	</nav>
</div>
<!--/west-->


<script src="/assets/metro/js/metro.min.js"></script>

</body>
</html>