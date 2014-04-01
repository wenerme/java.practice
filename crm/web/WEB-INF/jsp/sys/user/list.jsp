<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <title>人事管理</title>
    <script src="${pageContext.request.contextPath}/ui/js/jquery-1.4.2.js"
            type="text/javascript"></script>
    <link href="${pageContext.request.contextPath}/ui/css/style_cn.css"
          rel="stylesheet" type="text/css">
    <script type="text/javascript">
        function forward(url)
        {
            window.location.href = url;
        }
        function enable()
        {
            //window.alert("启用");
            $("#form2").attr("action","${pageContext.request.contextPath}/sys/item/enable");
            $("#form2").submit();
        }
        function disable()
        {
            //window.alert("停用");
            $("#form2").attr("action","${pageContext.request.contextPath}/sys/item/disable");
            document.form2.submit();
        }
        function deleteIds()
        {
            //window.alert("删除");
            $("#form2").attr("action","${pageContext.request.contextPath}/sys/item/delete");
            document.form2.submit();
        }
        function search()
        {
            //提交表单
            document.form1.submit();
        }
    </script>
    <style>
        .disabled{
            display: none;
        }
    </style>
</head>
<body>
<div class="mtitle">
    <div class="mtitle-row">
        &nbsp;
    </div>
    <span class="menu_selected">人事管理</span>
</div>
<br>
<table width="100%" border="0" cellspacing="0" cellpadding="0"
       class="tabForm">
    <tr>
        <th class="th_head">
            <div id="menuArrow1"
                 style="background: url(${pageContext.request.contextPath}/ui/images/down.gif) no-repeat center; float: left;">
                &nbsp;
            </div>
            <div id="menuTitle1" style="font-weight: bold">
                人员搜索
            </div>
        </th>
        <th class="th_head">
        </th>
    </tr>
    <tr>
        <td colspan="2">
            <form name="form1" method="post"
                  action="${pageContext.request.contextPath}/sys/user/search">
                <table width="100%" border="0" cellspacing="0" cellpadding="0"
                       name="base" id="base">
                    <tr>
                        <td width="13%" nowrap="nowrap">
                            英文名：
                        </td>
                        <td width="12%" nowrap="nowrap">
                            <input name="enname" type="text" id="name" value="${condition.enname}"
                                   style="width: 100px">
                        </td>
                        <td width="13%" nowrap="nowrap">
                            中文名：
                        </td>
                        <td width="12%" nowrap="nowrap">
                            <input name="cnname" type="text" id="cnname" value="${condition.cnname}"
                                   style="width: 100px">
                        </td>
                        <td width="13%" nowrap="nowrap">
                            所属部门：
                        </td>
                        <td width="12%" nowrap="nowrap">
                            <select id="groupId" name="groupId" style="width: 90%">

                                <option value=''>
                                    --------------
                                </option>

                                <!-- data -->

                                <option value="1" ${condition.groupId == "1"?"selected":""}>
                                    财务部
                                </option>

                                <option value="2" ${condition.groupId == "2"?"selected":""}>
                                    开发部
                                </option>

                                <option value="3" ${condition.groupId == "3"?"selected":""}>
                                    公关部
                                </option>

                                <!-- data -->

                            </select>
                        </td>
                        <td width="25%" align="center">
                            <div class="control">
                                <button type='button' class='button'
                                        onMouseOver="this.className='button_over';"
                                        onMouseOut="this.className='button';"
                                        onClick="search()">
                                    <img
                                            src="${pageContext.request.contextPath}/ui/images/button/sousuo.png"
                                            border='0' align='absmiddle'>
                                    &nbsp;搜索
                                </button>
                                &nbsp;
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            状态：
                        </td>
                        <td width="20%">
                            <input type='radio' name="enabled" id='enable' value='true'
                                   class='radio'
                                   ${condition.enabled?"checked":""}><label for="enable">启用</label>
                            <input type='radio' name="enabled" id='disable' value='false'
                                   class='radio'
                                    ${condition.enabled == false?"checked":""}>
                            <label for="disable">停用</label>
                            <input type='radio'
                                   name="enabled" id='all_state' value='all'
                                   class='radio'
                                    ${condition.enabled == null?"checked":""}>

                            <label for="all_state">全部</label>

                        </td>
                        <td>
                            &nbsp;
                        </td>
                        <td>
                            &nbsp;
                        </td>
                        <td>
                            &nbsp;
                        </td>
                        <td>
                            &nbsp;
                        </td>
                        <td>
                            &nbsp;
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
    &nbsp;人员列表
</h3>

<div class="control">
    <button type='button' class='button'
            onMouseOver="this.className='button_over';"
            onMouseOut="this.className='button';"
            onClick="forward('${pageContext.request.contextPath}/sys/item/add.jsp')">
        <img
                src="${pageContext.request.contextPath}/ui/images/button/xinjian.png"
                border='0' align='absmiddle'>
        &nbsp;新建
    </button>
    <button type='button' class='button'
            onMouseOver="this.className='button_over';"
            onMouseOut="this.className='button';" onClick="enable()">
        <img
                src="${pageContext.request.contextPath}/ui/images/button/qiyong.png"
                border='0' align='absmiddle'>
        &nbsp;启用
    </button>
    <button type='button' class='button'
            onMouseOver="this.className='button_over';"
            onMouseOut="this.className='button';" onClick="disable()">
        <img
                src="${pageContext.request.contextPath}/ui/images/button/tingyong.png"
                border='0' align='absmiddle'>
        &nbsp;停用
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
    <form id="form2" name="form2" method="post"
          action="${pageContext.request.contextPath}/sys/deleteAllSysUserRequest">
        <table width="100%" border="0" cellspacing="0" cellpadding="0"
               id="PowerTable" class="PowerTable">

            <!-- title -->

            <tr>
                <td width="4%" class="listViewThS1">
                    <input type="checkbox" id="checkall" name="checkall" value=""
                           class="checkbox" onClick="checkAll()">
                </td>
                <td width="13%" class="listViewThS1">
                    用户名
                </td>
                <td width="13%" class="listViewThS1">
                    中文名
                </td>
                <td width="15%" class="listViewThS1">
                    电子邮件
                </td>
                <td width="10%" class="listViewThS1">
                    所属部门
                </td>
                <td width="10%" class="listViewThS1">
                    起始有效期
                </td>
                <td width="10%" class="listViewThS1">
                    终止有效期
                </td>
                <td width="10%" class="listViewThS1">
                    状态
                </td>
            </tr>

            <c:forEach var="user" items="${sessionScope.page.items}">

                <tr>
                    <td>
                        <input
                                type="checkbox"
                                name="ids"
                                value="${user.id}"
                                class="checkbox"
                                onClick="changeCheckCount();">
                    </td>
                    <td>
                            ${user.enname}
                    </td>
                    <td>
                            ${user.cnname}
                    </td>
                    <td>
                            ${user.email}
                    </td>
                    <td>
                            ${user.group.department}
                    </td>
                    <td>
                        <fmt:formatDate
                                value="${user.beginDate}"
                                type="date"
                                />
                    </td>
                    <td>
                        <fmt:formatDate
                                value="${user.endDate}"
                                type="date"
                                />
                    </td>
                    <td>
                        <c:choose>
                            <c:when test="${user.enabled}">
                                <img
                                        src="${pageContext.request.contextPath}/ui/images/accept_inline.gif"
                                        width="13" height="13" border="0">
                            </c:when>
                            <c:otherwise>
                                <img
                                        src="${pageContext.request.contextPath}/ui/images/tuichu.png"
                                        width="13" height="13" border="0">
                            </c:otherwise>
                        </c:choose>


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
                   href="${pageContext.request.contextPath}/sys/user/list/1"
                   style="cursor: hand">首页</a>

                <a style="decoration:none"
                   class="${page.hasNext() ?"":"disabled" }"
                   href="${pageContext.request.contextPath}/sys/item/list/${page.currentPageNo + 1}"
                   style="cursor: hand">下一页</a>

                ${page.currentPageNo}/${page.pageCount}/${page.itemCount}

                <a style="decoration:none"
                   class="${page.hasPrevious() ?"":"disabled" }"
                   href="${pageContext.request.contextPath}/sys/item/list/${page.currentPageNo - 1}"
                   style="cursor: hand">上一页</a>

                <a style="decoration:none"
                   class="${page.hasNext() ?"":"disabled" }"
                   href="${pageContext.request.contextPath}/sys/item/list/${page.pageCount}"
                   style="cursor: hand">尾页</a>


            </td>
        </tr>
    </table>

</div>
<script type="text/javascript">
    function changeCheckCount()
    {
        var count = 0;
        $("input[type='checkbox'][name='ids']").each(function (index, data)
        {
            if (this.checked)
            {
                count++;
            }
        });
        $("#slt_ids_count2").empty();
        $("#slt_ids_count2").append(count);

        if (count == $("input[type='checkbox'][name='ids']").length)
        {
            $("#checkall").attr("checked", "checked");
        } else
        {
            $("#checkall").attr("checked", null);
        }
    }

    function checkAll()
    {
        if ($("#checkall")[0].checked)
        {
            $("input[type='checkbox'][name='ids']").attr("checked", "checked");
            $("#slt_ids_count2").empty();
            $("#slt_ids_count2").append($("input[type='checkbox'][name='ids']").length);
        } else
        {
            $("input[type='checkbox'][name='ids']").attr("checked", null);
            $("#slt_ids_count2").empty();
            $("#slt_ids_count2").append(0);
        }
    }
</script>
</body>
</html>