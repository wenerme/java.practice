package me.wener.practices.web.common.action;


import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;
import lombok.Getter;
import lombok.Setter;
import org.apache.struts2.interceptor.SessionAware;

import java.util.Map;

public abstract class BasicAction
        extends ActionSupport
        implements SessionAware
{
    @Getter
    @Setter
    private Map<String, Object> session;
    private ValueStack valueStack = null;

    //region Session 相关操作
    public Object session(String key)
    {
        return session.get(key);
    }

    public Map<String, Object> session(String key, Object value)
    {
        session.put(key, value);
        return session;
    }

    @SuppressWarnings("unchecked")
    public <T> T session(String key, Class<T> type)
    {
        return (T) session.get(key);
    }
    //endregion

    //region ValueStack 相关操作
    /**
     * 获取 {@link com.opensymphony.xwork2.util.ValueStack}
     */
    public ValueStack valueStack()
    {
        if (valueStack == null)
            valueStack = ActionContext.getContext().getValueStack();
        return valueStack;
    }

    /**
     * 等同于 {@link com.opensymphony.xwork2.util.ValueStack#set(String, Object)} 方法
     */
    public ValueStack valueStack(String key, Object value)
    {
        valueStack().set(key,value);
        return valueStack();
    }

    /**
     * 等同于 {@link com.opensymphony.xwork2.util.ValueStack#push(Object)} 方法
     */
    public ValueStack valueStack(Object value)
    {
        valueStack().push(value);
        return valueStack();
    }

    /**
     * 等同于 {@link com.opensymphony.xwork2.util.ValueStack#findValue(String)}
     */
    public Object valueStack(String key)
    {
        return valueStack().findValue(key);
    }

    /**
     * 等同于 {@link com.opensymphony.xwork2.util.ValueStack#findValue(String, Class)}
     */
    @SuppressWarnings("unchecked")// findValue 接受 class 参数,但是不是泛型方法
    public <T> T valueStack(String key, Class<T> asType)
    {
        return (T)valueStack().findValue(key, asType);
    }
    //endregion

}
