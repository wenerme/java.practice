<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html lang="zh" class="page-login">
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">

	<link href="/assets/metro/css/metro-bootstrap.css" rel="stylesheet">
	<link href="/assets/metro/css/metro-bootstrap-responsive.css" rel="stylesheet">

	<link href="/assets/bootstrap/css/metro-bootstrap.css" rel="stylesheet">

	<link href="/assets/iconFont.css" rel="stylesheet">
	<link href="/assets/font-awesome.min.css" rel="stylesheet">

	<link href="/style/main.less" rel="stylesheet/less">

	<!-- Load JavaScript Libraries -->
	<script src="/assets/js/jquery/jquery.min.js"></script>
	<script src="/assets/js/jquery/jquery.widget.min.js"></script>
	<script src="/assets/js/jquery/jquery.mousewheel.js"></script>

	<script src="/assets/bootstrap/js/bootstrap.min.js"></script>

	<script src="/assets/js/less.min.js"></script>
	<script src="/js/main.js"></script>
	<title>极限-客户关系管理系统</title>
</head>
<body class="metro">
<!--main banner-->
<div class="bg-cyan main-container">

	<!--图片显示区域-->
	<div class="image-holder">
		<div class="container" style="padding: 50px 20px">
			<h1 class="fg-white">Extreme CRM v1.0</h1>

			<h2 class="fg-white">
				Extreme CRM is a set of excellent tool,<br/> to manage you custom relationship.
			</h2>

			<a href="#"
			   class="place-left button bg-darkRed bg-hover-red fg-white fg-hover-white bd-orange"
			   style="margin-top: 10px">
				<h3 style="margin: 10px 40px">Know More<span class="icon-user-3 on-right"></span></h3>
			</a>
		</div>

	</div>
	<!--/图片显示区域-->

	<div class="bg-cyan">
		<div class="container action-row">

			<!--操作栏-->
            <form action="<s:url action="login" />" method="post">
			<div class="col-sm-4 pull-right padding10">
				<div class="input-control text" data-role="input-control">
					<input type="text" name="username" placeholder="请输入帐号..." autofocus="">
					<button class="btn-clear" tabindex="-1" type="button"></button>
				</div>

				<div class="input-control password" data-role="input-control">
					<input type="password" name="password" placeholder="请输入密码...">
					<button class="btn-reveal" tabindex="-1" type="button"></button>
				</div>

				<div>
					<div class="form-group col-sm-6 no-padding">
						<input class="col-sm-6" name="verifyCode" type="text" placeholder="验证码...">
						<%--<input class="col-sm-6" type="text" placeholder="1234">--%>
                        <img src="/image.jsp"
                             onclick="this.src='/image.jsp?t='+Math.random()"
                             title="点击更换"
                             style="cursor: pointer;height: 26px;">
					</div>
					<div class="text-right pull-right">
						<input type="submit" value="登录">
						<input type="reset" value="重置">
					</div>
				</div>

			</div>
            </form>
			<!--/操作栏-->

			<!--版权文字-->
			<div class="copy-text fg-grayLighter col-sm-4">
				<span>
					&copy; Developed & Designed by <a class="fg-violet bold" href="http://wener.me">wener</a>
					at <i class="fa fa-github-alt"></i><a href="http://wener.me" class="fg-violet">
					github</a>
				</span>
			</div>

		</div>

	</div>
</div>

<script src="/assets/metro/js/metro.min.js"></script>

</body>
</html>