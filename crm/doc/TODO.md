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
* 实现重置搜索条件
* [X] 实现 翻页的处理 /list(/{pageNo})?
* [.] 实现 search(/{categlory})?/{keyword}(/{pageNo})?
* 实现编辑
* 重构界面
* 实现验证
	
