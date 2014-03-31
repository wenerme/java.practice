error strategy


handleException=Exception.class
rethrow = true 再次抛出 作为 RuntimeException

// 总会处理该异常
ServletActionException(errorMessage,e);


发生 exception ? 原生的本来就会发生exception
所以不必处理也可以

message 页面

level: warn fail info
message: 字符串
	该值可以为 Enum 在toString 时显示信息

BeanUtils 不能设置 非返回 void 的setter

///////////////////////////////////////////////////////////////

crm 转换为 structs2 项目
----------------------

* 配置环境
* 在 servlet 的同级 建立一个 action 包来存放action __是这样的结构么__
* 从 ActionServelt 中提取出 Action
	* 根据实际需求,考虑是否做一个泛型的 ListDominateAction
* 修改 jsp 中的内容 转换为 structs tag
	* 修改表单提交
	* 修改数据呈现
	* 将 jsp 放在WBE-INF/action 目录内,目录结构和 action映射相同
		*  __是否应该这样做__ ?
		* __structs主要用于替换之前的servlet__ ?
		* 或者是只需要将显示动态数据的jsp放到 WEB-INF 内
		* 但 add/delete/list/edit/search 似乎都用动态数据
			* edit 为 add 的一个变种,只是多了一个 add 的 id 来更新对象

* for more , refactor the web page....


action 的映射

* /error
* /admin - 原menu
	* login/logout
* /sys
	* /user
		* add/delete/list/edit/search [default: list]
	* /group
		* add/delete/list/edit/search [default: list]
		
		
		
action 的作用

* 业务逻辑
* 请求数据
* 决定显示结果

命名空间的匹配模式
	* `*{namespace}*{action}`

域对象

主要是作用域不同

getContext
requestScope //请求上下文

getSession
sessionScope //session上下文

getApplication
applicationScope //应用上下文

返回map

因为这些值的内部表示均为 名值对
原先的 setAttribute/getAttribute 接受的参数
也是名值对表示,所以返回 map 实际是对这些对象的封装.

关于 GET 不应该传参数,这点不认同.
GET 传参数的好处有
	
* 便于刷新(这点很重要)
* 简单的参数处理方便,不需要表单
* 阅读性更强,例如
	* delete?id=123
	* read?id=345
	* 这种链接有时候会使用重写
	* delete/article/123
	* search/name/wener
	* page/2
	* 这样的url阅读性更高,更友好
* GET 传参的连接可以作为书签,或另存为URL
* 即此类 URL 可分发

不好的

* 数据有限制
	* 本来只是用于处理小数据
* 编码难以处理
	* 只要限制页面使用编码就好了
* 不安全
	* 相对post没那么安全,
		但是 GET 主要用于传递简单参数