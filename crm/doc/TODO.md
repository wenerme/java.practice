NOTE
====
* 均不使用默认action,这样避免引起误导

QUESTIONS
==========

可以做这样的东西么?
```
<action name="list(/{pageNo})?" method="list" class="xx.GroupAction">
    <result type="dispatcher">/WEB-INF/jsp/sys/group/list.jsp</result>
</action>
```

---



2014/4/2 TODO
===========

* [X] 完成 AdminAction
* [X] 实现重置搜索条件
	* URL: /search/reset
	* 或: /searchReset
	* [?] 按理说搜索条件应该是可以在cookie中存储的,如果list的呈现使用ajax,则不需要回显
		但是可以考虑提供一个 /search/reset 的方法. 确保清空搜索值,在现阶段也能实现重置功能.
* [X] 实现 翻页的处理 /list(/{pageNo})?
* [?] 实现 search(/{condition})?/{keyword}(/{pageNo})?
	* 这样的方法只能是用于实现单一的搜索条件,不是很便于使用
* 实现编辑
* 重构界面
* 实现验证
	
