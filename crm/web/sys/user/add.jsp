<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
	<head>
		<title>人员添加</title>
		<link href="${pageContext.request.contextPath}/ui/css/style_cn.css" rel="stylesheet" type="text/css">
		<!--处理日期 开始 -->
		<script src="${pageContext.request.contextPath}/ui/js/jquery-1.4.2.js"
			type="text/javascript"></script>
		<script type="text/javascript"
			src="${pageContext.request.contextPath}/ui/js/date_input/jquery.datepick.js"></script>
		<script type="text/javascript"
			src="${pageContext.request.contextPath}/ui/js/date_input/jquery.datepick-zh-CN.js"></script>
		<script type="text/javascript"
			src="${pageContext.request.contextPath}/ui/js/date_input/calendar.js"></script>
		<link rel="stylesheet"
			href="${pageContext.request.contextPath}/ui/js/date_input/jquery.datepick.css"
			type="text/css">
		<!--处理日期结束  -->
		<script type="text/javascript">
			function forward(url){
				window.location.href = url;
			}
			function addUser(){
				window.alert("保存");
				//提交表单
				document.form1.submit();
			}
		</script>
	</head>
	<body>
		<form name="form1" method="post" action="${pageContext.request.contextPath}/UserAction?action=add">
			<div class="mtitle">
				<div class="mtitle-row">
					&nbsp;
				</div>
				人员-添加
			</div>
			<br>
			<div class="control">
				<button type='button' class='button'
					onMouseOver="this.className='button_over';"
					onMouseOut="this.className='button';"
					onClick="addUser()">
					<img
						src="${pageContext.request.contextPath}/ui/images/button/baocun.png"
						border='0' align='absmiddle'>
					&nbsp;保存
				</button>
				<button type='button' class='button'
					onMouseOver="this.className='button_over';"
					onMouseOut="this.className='button';"
					onClick="forward('list.jsp')">
					<img
						src="${pageContext.request.contextPath}/ui/images/button/fanhui.png"
						border='0' align='absmiddle'>
					&nbsp;返回
				</button>
			</div>

			<table width="100%" border="0" cellspacing="0" class="tabForm">
				<tr>
					<th colspan="4" align="left" class="th_head">
						<div id="menuArrow1"
							style="background: url(${pageContext.request.contextPath}/ui/images/down.gif) no-repeat center; float: left;">
							&nbsp;
						</div>
						<div id="menuTitle1" style="font-weight: bold">
							基本信息
						</div>
					</th>
				</tr>
				<tr>
					<td>
						<div id="menu1">
							<table width="100%" border="0" cellspacing="0" cellpadding="0">
								<tr>
									<td width="16%"></td>
									<td width="34%"></td>
									<td width="16%"></td>
									<td width="34%"></td>
								</tr>
								<tr>
									<td class="red">
										英文名*：
									</td>
									<td>
										<input name="enname" type="text" id="name" style="width: 90%"
											value="">
									</td>
									<td class="red">
										中文名*：
									</td>
									<td>
										<input name="cnname" type="text" class="input" id="cnname"
											style="width: 90%" value="">
									</td>
								</tr>
								<tr>
									<td class="red">
										密码*：
									</td>
									<td>
										<input name="password" type="password" id="password"
											style="width: 90%" value="">
									</td>
									<td>
										推荐人：
									</td>
									<td>
										<input name="commendman" type="text" class="input"
											id="commendman" style="width: 90%" value="">
									</td>
								</tr>
								<tr>
									<td>
										移动电话：
									</td>
									<td>
										<input name="movetelePhone" type="text" class="input"
											id="movetelePhone" style="width: 90%" value="">
									</td>
									<td class="red">
										电子邮件*：
									</td>
									<td>
										<input name="email" type="text" class="input" id="email"
											style="width: 90%" value="">
									</td>
								</tr>
								<tr>
									<td>
										家庭地址：
									</td>
									<td>
										<input name="address" type="text" class="input" id="address"
											style="width: 90%" value="">
									</td>
									<td>
										家庭电话：
									</td>
									<td>
										<input name="telephone" type="text" class="input"
											id="telephone" style="width: 90%" value="">
									</td>
								</tr>
								<tr>
									<td>
										现住宅地址：
									</td>
									<td>
										<input name="nowAddress" type="text" class="input"
											id="nowAddress" style="width: 90%" value="">
									</td>
									<td>
										现住宅电话：
									</td>
									<td>
										<input name="nowtelePhone" type="text" class="input"
											id="nowtelePhone" style="width: 90%" value="">
									</td>
								</tr>
								<tr>
									<td>
										身份证号码：
									</td>
									<td>
										<input name="identityCode" type="text" class="input"
											id="identityCode" style="width: 90%" value="">
									</td>
									<td>
										社会保险号：
									</td>
									<td>
										<input name="insuranceCode" type="text" class="input"
											id="insuranceCode" style="width: 90%" value="">
									</td>
								</tr>
								<tr>
									<td>
										紧急联系人：
									</td>
									<td>
										<input name="instancyLinkman" type="text" class="input"
											id="instancyLinkman" style="width: 90%" value="">
									</td>
									<td>
										紧急联系电话：
									</td>
									<td>
										<input name="instancytelePhone" type="text" class="input"
											id="instancytelePhone" style="width: 90%" value="">
									</td>
								</tr>
								<tr>
									<td class="red">
										起始有效期*：
									</td>
									<td>
										<input type='text' id='beginDate' name='beginDate'
											class="dateClassStyle" value='' style='width: 90%'>
									</td>
									<td class="red">
										终止有效期*：
									</td>
									<td>
										<input type='text' id='endDate' name='endDate'
											class="dateClassStyle" value='' style='width: 90%'>
									</td>
								</tr>
								<tr>
									<td class="red"><br></td>
									<td><br></td>
									<td class="red">
										所属部门*：
									</td>
									<td>
										<select id="groupId" name="group.id" style='width: 90%'>
											
												<!-- data -->
											
												<option value="1">
													财务部
												</option>
												
												<option value="2">
													开发部
												</option>
												
												<option value="3">
													市场部
												</option>
												
												<!-- data -->
											
										</select>
									</td>
								</tr>
								<tr>
									<td class="red">
										状态*：
									</td>
									<td>
										<input type='radio' name='enabled' id='status' value='true'
											class='radio' checked="checked">
										启用
										<input type='radio' name='enabled' id='status' value='false'
											class='radio'>
										停用
									</td>
								</tr>

							</table>
						</div>
					</td>
				</tr>
			</table>
			<br>
			<table width="100%" border="0" cellspacing="0" class="tabForm">
				<tr>
					<th colspan="4" align="left" class="th_head">
						<div id="menuArrow2"
							style="background: url(${pageContext.request.contextPath}/ui/images/down.gif) no-repeat center; float: left;">
							&nbsp;
						</div>
						<div id="menuTitle2" style="font-weight: bold">
							详细信息
						</div>
					</th>
				</tr>
				<tr>
					<td>
						<div id="menu2">
							<table width="100%" border="0" cellspacing="0" cellpadding="0">
								<tr>
									<td width="16%"></td>
									<td width="34%"></td>
									<td width="16%"></td>
									<td width="34%"></td>
								</tr>
								<tr>
									<td>
										性别：
									</td>
									<td>
										<input type='radio' name='sex' id='status' value='男'
											class='radio' checked="checked">
										男
										<input type='radio' name='sex' id='status' value='女'
											class='radio'>
										女
									</td>
									<td>
										出生日期：
									</td>
									<td>
										<input type='text' id='birthday' name='birthday'
											class="dateClassStyle" value='' style='width: 90%'>
									</td>
								</tr>
								<tr>
									<td>
										职员类别：
									</td>
									<td>
										<input type='radio' name='personnelType' id='status'
											value='全职' class='radio'>
										全职
										<input type='radio' name='personnelType' id='status'
											value='兼职' class='radio'>
										兼职
									</td>
									<td>
										职务：
									</td>
									<td>
										<input name="duty" type="text" class="input" id="duty"
											style="width: 90%" value="">
									</td>
								</tr>
								<tr>
									<td>
										入职时间：
									</td>
									<td>
										<input type='text' id='workDate' name='workDate'
											class="dateClassStyle" value='' style='width: 90%'>
									</td>
									<td>
										最高学历：
									</td>
									<td>
										<input name="highSchool" type="text" class="input"
											id="highSchool" style="width: 90%" value="">
									</td>
								</tr>
								<tr>
									<td>
										毕业学校：
									</td>
									<td>
										<input name="finishSchool" type="text" class="input"
											id="finishSchool" style="width: 90%" value="">
									</td>
									<td>
										毕业时间：
									</td>
									<td>
										<input type='text' id='finishSchoolDate'
											name='finishSchoolDate' class="dateClassStyle" value=''
											style='width: 90%'>
									</td>
								</tr>
								<tr>
									<td>
										配偶姓名：
									</td>
									<td>
										<input name="consortName" type="text" class="input"
											id="consortName" style="width: 90%" value="">
									</td>
									<td>
										子女姓名：
									</td>
									<td>
										<input name="youngoneName" type="text" class="input"
											id="youngoneName" style="width: 90%" value="">
									</td>
								</tr>
								<tr>
									<td>
										办公电话：
									</td>
									<td>
										<input name="officetelePhone" type="text" class="input"
											id="officetelePhone" style="width: 90%" value="">
									</td>
									<td>
										配偶电话：
									</td>
									<td>
										<input name="consorttelePhone" type="text" class="input"
											id="consorttelePhone" style="width: 90%" value="">
									</td>
								</tr>
								<tr>
									<td>
										业余爱好：
									</td>
									<td colspan="3">
										<input name="avocation" type="text" class="input"
											id="avocation" style="width: 96%" value="">
									</td>
								</tr>
								<tr>
									<td>
										配偶工作单位：
									</td>
									<td colspan="3">
										<input name="consortCompany" type="text" class="input"
											id="consortCompany" style="width: 96%" value="">
									</td>
								</tr>
	</table>
						</div>
					</td>
				</tr>
			</table>
			<br>
			<table width="100%" border="0" cellspacing="0" class="tabForm">
				<tr>
					<th colspan="4" align="left" class="th_head">
						<div id="menuArrow3"
							style="background: url(${pageContext.request.contextPath}/ui/images/down.gif) no-repeat center; float: left;">
							&nbsp;
						</div>
						<div id="menuTitle3" style="font-weight: bold">
							职业技能
						</div>
					</th>
				</tr>
				<tr>
					<td>
						<div id="menu3">
							<table width="100%" border="0" cellspacing="0" cellpadding="0">
								<tr>
									<td width="16%"></td>
									<td width="34%"></td>
									<td width="16%"></td>
									<td width="34%"></td>
								</tr>
								<tr>
									<td>
										偏好特长：
									</td>
									<td>
										<textarea name="strongSuit" id="strongSuit" rows="3"
											style="width: 90%"></textarea>
									</td>
									<td>
										信息沟通：
									</td>
									<td>
										<textarea name="commUniCate" id="commUniCate" rows="3"
											style="width: 90%"></textarea>
									</td>
								</tr>
								<tr>
									<td>
										培训情况：
									</td>
									<td>
										<textarea name="bringup" id="bringup" rows="3"
											style="width: 90%"></textarea>
									</td>
									<td>
										组织能力：
									</td>
									<td>
										<textarea name="organise" id="organise" rows="3"
											style="width: 90%"></textarea>
									</td>
								</tr>
								<tr>
									<td>
										分析能力：
									</td>
									<td>
										<textarea name="analyse" id="analyse" rows="3"
											style="width: 90%"></textarea>
									</td>
									<td>
										计划能力：
									</td>
									<td>
										<textarea name="planing" id="planing" rows="3"
											style="width: 90%"></textarea>
									</td>
								</tr>
								<tr>
									<td>
										人员开发：
									</td>
									<td>
										<textarea name="empolder" id="empolder" rows="3"
											style="width: 90%"></textarea>
									</td>
									<td>
										人际关系：
									</td>
									<td>
										<textarea name="relation" id="relation" rows="3"
											style="width: 90%"></textarea>
									</td>
								</tr>
							</table>
						</div>
					</td>
				</tr>
			</table>
			<br>
			<table width="100%" border="0" cellspacing="0" class="tabForm">
				<tr>
					<th colspan="4" align="left" class="th_head"><br></th>
				</tr>
				<tr>
					<td><br></td>
				</tr>
			</table>
			<br>
		</form>
		<script src="${pageContext.request.contextPath}/ui/js/menu.js"
			type="text/javascript">
		</script>
	</body>
</html>