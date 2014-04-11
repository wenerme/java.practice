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
		
使用regex映射

/sys/user
		/add
		/list/{pageNo:\d*}
			这里的参数为页号
		/delete/{id:\d+}
		/edit/{id:\d+}
			关于如何传递多个id
				.+ 然后自己分析,或者使用post ?
		/search/{keyword}
			
		
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


chats
======
使用 session 对象和 application 对象实现聊天