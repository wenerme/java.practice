<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../../baselist.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title></title>

<script language="javascript">
	function preSubmit(serviceName){
		if(serviceName=="查看"||serviceName=="修改"||serviceName=="删除"||serviceName=="删除1"){
			if(_CheckAll(true,serviceName) == false){
	            return false;
	 		}
			if(serviceName=="删除"){
				return confirm("您确定要将所选记录删除吗?\n单击【确定】将删除所选记录! 单击【取消】将终止删除操作!");
			}
		}
	}
	
	function preCheck(serviceName) {
		var msg = ""; 
		if(serviceName=="查看"||serviceName=="修改"||serviceName=="删除1"){
			msg = onlySelect(serviceName,"id",1);
			if(msg){
				return msg;
			}
		}
		if(serviceName=="查看"||serviceName=="修改"||serviceName=="删除"||serviceName=="删除1"){
			if(msg){
	    		msg += "<br />";
	    		msg +=  mustSelect(serviceName,"id");
			}else{
				msg =  mustSelect(serviceName,"id");
			}
			if(msg){
				return msg;
			}
		}
	}
</script>	
</head>

<body>
<form name="icform" method="post">

<div id="menubar">
<div id="middleMenubar">
<div id="innerMenubar">
  <div id="navMenubar">
<ul>
<%--<li id="view"><a href="#" onclick="_Submit('toview.action',null,'查看');this.blur();">查看</a></li>--%>
<%--<li id="new"><a href="#" onclick="formSubmit('create.action','_self');this.blur();">新增</a></li>--%>
<li id="new"><a href="create" >新增</a></li>
<%--<li id="update"><a href="#" onclick="_Submit('edit.action',null,'修改');this.blur();">修改</a></li>--%>
<%--<li id="delete"><a href="#" onclick="_Submit('delete.action',null,'删除1');this.blur();">删除1</a></li>--%>
<li id="delete"><a href="#" onclick="formSubmit('delete.action','_self');this.blur();">删除</a></li>
<li id="new"><a href="#" onclick="formSubmit('enable.action','_self');this.blur();">启用</a></li>
<li id="new"><a href="#" onclick="formSubmit('disable.action','_self');this.blur();">停用</a></li>
</ul>
  </div>
</div>
</div>
</div>
   
<div class="textbox" id="centerTextbox">
  <div class="textbox-header">
  <div class="textbox-inner-header">
  <div class="textbox-title">
    生产厂家列表
  </div> 
  </div>
  </div>
  
<div>

<div class="eXtremeTable" >
<table id="ec_table" class="tableRegion" width="98%" >
	<thead>
	<tr>
		<td class="tableHeader"><input type="checkbox" name="selid" onclick="checkAll('id',this)"></td>
		<td class="tableHeader">序号</td>
		<td class="tableHeader">厂家全称</td>
		<td class="tableHeader">缩写</td>
		<td class="tableHeader">联系人</td>
		<td class="tableHeader">电话</td>
		<td class="tableHeader">手机</td>
		<td class="tableHeader">验货员</td>
		<td class="tableHeader">状态</td>
		<td class="tableHeader">操作</td>
	</tr>
	</thead>
	<tbody class="tableBody" >
	
	<c:forEach items="${items}" var="o" varStatus="status">
	<tr class="odd" onmouseover="this.className='highlight'" onmouseout="this.className='odd'" >
		<td><input type="checkbox" name="ids" value="${o.id}"/></td>
		<td>${status.index+1}</td>
		<td><a href="view/${o.id}">${o.fullName}</a></td>
		<td>${o.factoryName}</td>
		<td>${o.contacts}</td>
		<td>${o.phone}</td>
		<td>${o.mobile}</td>
		<td>${o.inspector}</td>
		<td>
			<c:if test="${o.state==1}"><a href="disable/${o.id}" title="点击设置为停用">启用</a></c:if>
			<c:if test="${o.state==0}"><a href="enable/${o.id}" title="点击设置为启用"><font color="orange">停用</font></a></c:if>
		</td>
        <td>
            <a href="view/${o.id}" title="点击查看">查看</a>
            <a href="edit/${o.id}" title="点击编辑">编辑</a>
        </td>
	</tr>
	</c:forEach>
	
	</tbody>
</table>
</div>
 
</div>
 
 
</form>
</body>
</html>

