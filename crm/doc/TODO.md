NOTE
====
* ����ʹ��Ĭ��action,��������������

QUESTIONS
==========

�����������Ķ���ô?
```
<action name="list(/{pageNo})?" method="list" class="xx.GroupAction">
    <result type="dispatcher">/WEB-INF/jsp/sys/group/list.jsp</result>
</action>${}
```

---

����ͬʱ�� / �� "" ת��һ��ָ����action ô
```
<!-- ��ͬʱʵ�����������action -->
<action name="/">
    <result type="redirectAction">list</result>
</action>
<action name="">
    <result type="redirectAction">/</result>
</action>
```

---

������ struts.xml �ж������Ʊ����Ķ���ô? 
���緵�� input ��ָ��ͬһ�� url

---

TODO
===========

2014.4.2
--------

* [X] ��� AdminAction
* [X] ʵ��������������
	* URL: /search/reset
	* ��: /searchReset
	* [?] ����˵��������Ӧ���ǿ�����cookie�д洢��,���list�ĳ���ʹ��ajax,����Ҫ����
		���ǿ��Կ����ṩһ�� /search/reset �ķ���. ȷ���������ֵ,���ֽ׶�Ҳ��ʵ�����ù���.
* [X] ʵ�� ��ҳ�Ĵ��� /list(/{pageNo})?

* [X] ʵ�ֱ༭
	* FIXME: ���user ��ʱ���һ�ΰ��������ת�� add,������Ϣ��ʧ,�޽�

more
-------
	
* �ع�����
* ʵ����֤
* [?] ʵ�� search(/{condition})?/{keyword}(/{pageNo})?
	* �����ķ���ֻ��������ʵ�ֵ�һ����������,���Ǻܱ���ʹ��
