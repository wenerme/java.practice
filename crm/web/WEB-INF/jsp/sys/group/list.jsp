<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
	<head>
		<title>部门设置</title>
		<script src="${pageContext.request.contextPath}/ui/js/jquery-1.4.2.js"
			type="text/javascript"></script>
		<link href="${pageContext.request.contextPath}/ui/css/style_cn.css"
			rel="stylesheet" type="text/css">
		<script src="${pageContext.request.contextPath}/ui/js/win.js"
			type="text/javascript"></script>
		<script type="text/javascript">
			function forward(url){
				window.location.href = url;
			}
			function deleteIds(){
				//window.alert("删除操作");
				window.document.form2.submit();
			}
			function toSearch(){
				//window.alert("搜索操作");	
				window.document.form1.submit();			
			}
		</script>		
	</head>
	<body>
		<div class="mtitle">
			<div class="mtitle-row">
				&nbsp;
			</div>
			<span class="menu_selected">部门设置</span>
		</div>
		<br>
		<table width="100%" border="0" cellspacing="0" cellpadding="0"
			class="tabForm">
			<tr>
				<th class="th_head">
					<div id="menuArrow1"
						style="background:url(${pageContext.request.contextPath}/ui/images/down.gif) no-repeat center; float: left;">
						&nbsp;
					</div>
					<div id="menuTitle1" style="font-weight: bold">
						部门搜索
					</div>
				</th>
				<th class="th_head">
				</th>
			</tr>
			<tr>
				<td colspan="2">
					<form name="form1" method="post"
						action="${pageContext.request.contextPath}/GroupAction?action=searchByDepartment">
						<table width="100%" border="0" cellspacing="0" cellpadding="0"
							name="base" id="base">
							<tr>
								<td width="38%" nowrap="nowrap">
									部门名称：
									<input name="department" type="text" id="name" value="${department}"
										style="width: 140px">
								</td>
								<td width="39%" nowrap="nowrap">
									&nbsp;
								</td>
								<td width="23%" align="center">
									<div class="control">
										<button type='button' class='button'
											onMouseOver="this.className='button_over';"
											onMouseOut="this.className='button';" onClick="toSearch()">
											<img
												src="${pageContext.request.contextPath}/ui/images/button/sousuo.png"
												border='0' align='absmiddle'>
											&nbsp;搜索
										</button>
									</div>
								</td>
							</tr>
						</table>
					</form>
				</td>
			</tr>
		</table>
		<br>
		<h3>
			<img src="${pageContext.request.contextPath}/ui/images/menu/khlb.png"
				border="0">
			&nbsp;部门列表
		</h3>
		<div class="control">

			<button type='button' class='button'
				onMouseOver="this.className='button_over';"
				onMouseOut="this.className='button';"
				onClick="forward('${pageContext.request.contextPath}/sys/group/add.jsp')">
				<img
					src="${pageContext.request.contextPath}/ui/images/button/xinjian.png"
					border='0' align='absmiddle'>
				&nbsp;新建
			</button>


			<button type='button' class='button'
				onMouseOver="this.className='button_over';"
				onMouseOut="this.className='button';" onClick="deleteIds()">
				<img
					src="${pageContext.request.contextPath}/ui/images/button/shanchu.png"
					border='0' align='absmiddle'>
				&nbsp;删除
			</button>

		</div>
		<!-- list -->
		<div class="border">
			<form name="form2" method="post"
				  action="${pageContext.request.contextPath}/GroupAction?action=deleteGroup">
				<table width="100%" border="0" cellspacing="0" cellpadding="0"
					id="PowerTable" class="PowerTable">
					<!-- title -->
					<tr>
						<td width="5%" class="listViewThS1">
							<input 
								type="checkbox" 
								id="checkall" 
								name="checkall" 
								value=""
								class="checkbox" 
								onClick="checkAll()"/>
						</td>
						<td width="20%" class="listViewThS1">
							部门名称
						</td>
						<td width="15%" class="listViewThS1">
							部门负责人
						</td>
						<td width="50%" class="listViewThS1">
							部门职能
						</td>
					</tr>
					<c:forEach var="group" items="${page.items}" >
						<tr>
							<td>
								<input 
									type="checkbox" 
									name="ids" 
									value="${group.id}" 
									class="checkbox"
									onClick="changeCheckCount()"/>
							</td>
							<td>
								${group.getDepartment()}
							</td>
							<td>
								${group.principal}
							</td>
							<td>
								${group.functional}
							</td>
						</tr>
					</c:forEach>
				</table>
			</form>
            <table width="100%" border="0" cellspacing="0" cellpadding="0"
                   class="listViewPaginationTdS1">
                <tr>
                    <td width="29%">
                        选择条目:
                        <span id="slt_ids_count2">0</span>
                    </td>
                    <td width="71%" align="right">


                        <a style="decoration:none"
                           class="${page.hasPrevious() ?"":"disabled" }"
                           href="${pageContext.request.contextPath}/GroupAction?action=list&pageNo=1"
                           style="cursor: hand">首页</a>

                        <a style="decoration:none"
                           class="${page.hasNext() ?"":"disabled" }"
                           href="${pageContext.request.contextPath}/GroupAction?action=list&pageNo=${page.currentPageNo + 1}"
                           style="cursor: hand">下一页</a>

                        ${page.currentPageNo}/${page.pageCount}/${page.itemCount}

                        <a style="decoration:none"
                           class="${page.hasPrevious() ?"":"disabled" }"
                           href="${pageContext.request.contextPath}/GroupAction?action=list&pageNo=${page.currentPageNo - 1}"
                           style="cursor: hand">上一页</a>

                        <a style="decoration:none"
                           class="${page.hasNext() ?"":"disabled" }"
                           href="${pageContext.request.contextPath}/GroupAction?action=list&pageNo=last"
                           style="cursor: hand">尾页</a>


                    </td>
                </tr>
            </table>
		</div>
	</body>
	<script type="text/javascript">
	
    function changeCheckCount(){
       var count=0;
	   $("input[type='checkbox'][name='ids']").each(function(index,data){
            if(this.checked){
            	count++;  
            }
	   });
	   $("#slt_ids_count2").empty();
 	   $("#slt_ids_count2").append(count);

       if(count== $("input[type='checkbox'][name='ids']").length){
    	   $("#checkall").attr("checked","checked");
       }else{
    	   $("#checkall").attr("checked",null);
       }
   }
   
   function  checkAll(){
      if($("#checkall")[0].checked){
    	  $("input[type='checkbox'][name='ids']").attr("checked","checked");
    	  $("#slt_ids_count2").empty();
    	  $("#slt_ids_count2").append($("input[type='checkbox'][name='ids']").length);
      }else{
    	  $("input[type='checkbox'][name='ids']").attr("checked",null);
    	  $("#slt_ids_count2").empty();
    	  $("#slt_ids_count2").append(0);
      }
   }
   
 </script>
</html>