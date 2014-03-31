<%@ page language="java" pageEncoding="UTF-8"%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title>CRM客户关系管理系统</title>
		<link href="${pageContext.request.contextPath}/ui/css/style_cn.css"
			rel="stylesheet" type="text/css">
		<script src="${pageContext.request.contextPath}/ui/js/jquery-1.4.2.js"
			type="text/javascript"></script>
		<script src="${pageContext.request.contextPath}/ui/js/win.js"
			type="text/javascript"></script>
		<style>
			.font {
				color: #000000;
				font-size: 9pt;
				font-family: "宋体"
			}
			
			.td {
				font-size: 9pt;
				font-family: "宋体";
				height: 25px;
			}
			
			INPUT {
				background-color: #FFFFFF;
			}
			
			body {
				margin: 0px;
			}
	</style>
	<script type="text/javascript" src="js/jquery-1.8.2.js"></script>
	<script type="text/javascript">
		function changeCheckNum(){
			//局部刷新
			document.getElementById("checkNumImage").src = "${pageContext.request.contextPath}/image.jsp";
		}
		function checkSubmit(){
			var username = $("#name").val();
			var password = $("#password").val();
			var checkNum = $("#checkNum").val();
			username = $.trim(username);
			password = $.trim(password);
			checkNum = $.trim(checkNum);
			if(username.length>0){
				if(/^[\u4E00-\uFA29]+$/.test(username)){
					if(password.length>0){
						if(/^[0-9]{6}$/.test(password)){
							if(checkNum.length>0){
								document.forms[0].submit();	
							}else{
								window.alert("验证码必填");
								$("#checkNum").focus();
								$("#checkNum").val("");
							}
						}else{
							window.alert("密码必须使用6位数字");
							$("#password").focus();
							$("#password").val("");
						}
					}else{
						window.alert("密码必填");
						$("#password").focus();
						$("#password").val("");
					}
				}else{
					window.alert("用户帐号必须使用中文");
					$("#name").focus();
					$("#name").val("");
				}
			}else{
				window.alert("用户帐号必填");
				$("#name").focus();
				$("#name").val("");
			}
		}
	</script>
	</head>
		<BODY topmargin="0" leftmargin="0">
		<form name="form1" method="post"
			action="${pageContext.request.contextPath}/AdminAction?action=login">
			<TABLE width="100%" cellpadding="0" cellspacing="0" id="header">
				<TR>
					<TD>
						<TABLE height="80" cellpadding="0" cellspacing="0" width="100%">
							<TR>
								<TD width="225">
									<img
										src="${pageContext.request.contextPath}/ui/images/ban_1.gif">
								</TD>
								<TD
									background="${pageContext.request.contextPath}/ui/images/ban_2.gif">
									&nbsp;
								</TD>
								<TD width="181"
									background="${pageContext.request.contextPath}/ui/images/ban_2.gif"></TD>
							</TR>
						</TABLE>
					</TD>
				</TR>
				<TR>
					<TD height="119"
						background="${pageContext.request.contextPath}/ui/images/bg.gif">
						&nbsp;
					</TD>
				</TR>
				<TR>
					<TD height="300">
						<TABLE width="100%" cellpadding="0" cellspacing="0">
							<TR>
								<TD valign="top" align="center">
									<img
										src="${pageContext.request.contextPath}/ui/images/logo.gif">
								</TD>
								<TD width="44" height="200"
									background="${pageContext.request.contextPath}/ui/images/line.png">
									&nbsp;
								</TD>
								<TD width="540" valign="top">
									<TABLE width="100%" cellpadding="0" cellspacing="0">
										<TR>
											<TD height="140" valign="top">
												<br>
												<font color="#FF0000"></font>
												<br>
												<TABLE cellpadding="0" cellspacing="0">
													<TR>
														<TD class="td">
															管理员：
														</TD>
														<TD class="td">
															<input name="username" type="text" value=""
																id="name" />
														</TD>
													</TR>
													<TR>
														<TD class="td">
															登录密码：
														</TD>
														<TD class="td">
															<input name="password" type="password" value=""
																id="password">
														</TD>
													</TR>
													<TR>
														<TD class="td">
															验&nbsp;证&nbsp;码：
														</TD>
														<TD class="td">
															<input name="checkNum" type="text" value="" id="checkNum"
																style="width: 80">
															<img id="checkNumImage"
																src="${pageContext.request.contextPath}/image.jsp"
																height="19" align="absmiddle" onClick="changeCheckNum()"
																title="点击换一张" style="cursor: hand">
														</TD>
													</TR>
												</TABLE>
											</TD>
										</TR>
										<TR>
											<TD>
												<img
													src="${pageContext.request.contextPath}/ui/images/login.png"
													id="login" onClick="checkSubmit()" style="cursor: hand">
												&nbsp;&nbsp;
												<img
													src="${pageContext.request.contextPath}/ui/images/reset.png"
													id="reset" onClick="" style="cursor: hand">
											</TD>
										</TR>
									</TABLE>
								</TD>
							</TR>
						</TABLE>
					</TD>
				</TR>
				<TR>
					<TD align="center">
						<br>
						<a href="http://www.itcast.cn" target="_blank">北京传智播客教育科技有限公司</a>
					</TD>
				</TR>
				<TR>
					<TD height="5">
						&nbsp;
					</TD>
				</TR>
			</TABLE>
		</form>
		<script type="text/javascript">
			$(function(){
				$("#name").focus();
			});
		</script>
	</BODY>
</html>