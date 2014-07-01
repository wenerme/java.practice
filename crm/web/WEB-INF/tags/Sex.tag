<%@tag description="显示性别选择" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@attribute name="tagName" %>
<c:if test="${tagName == null}"><c:set var="tagName" value="sex" /></c:if>

<s:select list="#{'Male':'男','Female':'女'}" name="%{#attr.tagName}"/>