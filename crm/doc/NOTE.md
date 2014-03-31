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



DTO
