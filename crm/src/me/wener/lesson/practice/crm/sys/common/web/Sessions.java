package me.wener.lesson.practice.crm.sys.common.web;

import me.wener.lesson.practice.crm.sys.admin.entity.Admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @author Wener
 *         session 辅助操作对象,管理在 session 中的常用存储内容
 *         避免 硬编码 key 值, 避免 key值错误
 */
public final class Sessions
{
    private final static Sessions instance = new Sessions();

    private Sessions()
    {
    }

    public static WithSession on(HttpSession session)
    {
        return new WithSession(session);
    }

    public static WithSession on(HttpServletRequest request)
    {
        return new WithSession(request.getSession());
    }

    public static class WithSession
    {
        private HttpSession session;
        private final static String USER = "SESSION_USER";
        private final static String VERIFY_CODE = "SESSION_VERIFY_CODE";

        private WithSession(HttpSession session)
        {
            this.session = session;
        }

        public WithSession set(String key, Object val)
        {
            session.setAttribute(key, val);
            return this;
        }

        public WithSession set(Map<String, Object> values)
        {
            for (Map.Entry<String, Object> entry : values.entrySet())
            {
                set(entry.getKey(), entry.getValue());
            }
            return this;
        }

        public WithSession clear(String key)
        {
            session.removeAttribute(key);
            ;
            return this;
        }

        public Object get(String key)
        {
            return session.getAttribute(key);
        }

        public String getVerifyCode()
        {
            return (String) get(VERIFY_CODE);
        }

        public WithSession setVerifyCode(String code)
        {
            return set(VERIFY_CODE, code);
        }

        public Admin getUser()
        {
            return (Admin) get(USER);
        }

        public WithSession setUser(Admin val)
        {
            return set(USER, val);
        }

        public WithSession clearVerifyCode()
        {
            return clear(VERIFY_CODE);
        }

        public WithSession clearUser()
        {
            return clear(USER);
        }

        /**
         * 结束该 session 的操作 返回 Sessions
         */
        public Sessions end()
        {
            return instance;
        }

    }
}
