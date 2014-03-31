package me.wener.lesson.practice.crm.sys.common.web.servlet;

import com.google.common.base.Strings;
import me.wener.lesson.practice.crm.sys.admin.web.servlet.AdminActionServlet;
import me.wener.lesson.practice.crm.sys.common.web.RequestMethod;
import me.wener.lesson.practice.crm.sys.common.web.ServletAction;
import me.wener.lesson.practice.crm.sys.common.web.ServletActionException;
import me.wener.lesson.practice.crm.sys.common.web.Servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

public abstract class ComplexServlet extends HttpServlet
{
    // private static final org.apache.logging.log4j.Logger log =
    // org.apache.logging.log4j.Logger.getLogger(LogExample.class);
    // private static final org.apache.commons.logging.Log log =
    // org.apache.commons.logging.LogFactory.getLog(HttpServlet.class);
    // private static final org.apache.log4j.Logger log =
    // org.apache.log4j.Logger.getLogger(LogExample.class);
    private static final long serialVersionUID = 1L;
    protected Map<String, EnumMap<RequestMethod, Method>> actions = null;

    /**
     * 默认方法,一个 servlet 中只能有一个
     */
    protected Method defaultMethod;

    public ComplexServlet()
    {

        actions = new HashMap<>();
        Class<?> clazz = this.getClass();
        Method[] methods = clazz.getMethods();

        // 扫描出所有注解
        String action;
        for (Method method : methods)
        {
            ServletAction annotation = method.getAnnotation(ServletAction.class);
            if (annotation == null)
                continue;


            // 如果没有指定 action,则使用方法名
            if (annotation.action() == null || annotation.action().length() == 0)
                action = method.getName();
            else
                action = annotation.action();


            // 该类请求的方法映射
            EnumMap<RequestMethod, Method> map = actions.get(action);
            if (map == null)// 尝试创建该映射
            {
                map = new EnumMap<>(RequestMethod.class);
                actions.put(action, map);
            }

            for (RequestMethod md : annotation.method())
            {
                map.put(md, method);
            }

            if (annotation.asDefault())
            {

                if (defaultMethod != null)
                {
                    String msg = "ComplexServlet::%s:\n" +
                            "再次定义了默认方法在函数 '%s' 上,之前的默认方法为 '%s'";
                    throw new RuntimeException(String.format(msg, clazz, method, defaultMethod));
                }
                defaultMethod = method;
            }

        }

    }

    public static void main(String[] args) throws Exception
    {
        ComplexServlet servlet = new ComplexServlet()
        {
            private static final long serialVersionUID = 1L;

            @ServletAction(method = {RequestMethod.GET})
            public void login(HttpServletRequest request, HttpServletResponse response)
            {
            }
        };
        AdminActionServlet serv2 = new AdminActionServlet();

        System.out.println(servlet.actions);
        System.out.println(serv2.actions);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        doAction(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        doAction(request, response);
    }

    protected void doPut(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        doAction(request, response);
    }

    protected void doDelete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        doAction(request, response);
    }

    protected void doHead(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        doAction(request, response);
    }

    protected void doOptions(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        doAction(request, response);
    }

    protected void doTrace(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        doAction(request, response);
    }

    protected void doAction(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        RequestMethod requestMethod = RequestMethod.valueOf(request.getMethod().toUpperCase());
        String action = getAction(request);
        Method method;
        System.out.printf("Do action(%s): %s\n", requestMethod, action);
        // 判断是否有该动作的处理定义
        if (action == null || action.length() == 0 || !actions.containsKey(action))
        {
            if (defaultMethod != null)// 是否有默认的处理方法
            {
                method = defaultMethod;
            } else
            {
                invalidAction(request, response);// 无效的动作
                return;
            }
        } else
        {
            method = actions.get(action).get(requestMethod);
        }

        System.out.printf("Hanlded by:\n\t%s %s\n", method == defaultMethod ? "(Default)" : "", method);
        if (method == null)// TODO: 关于这个判断,似乎不会发生 考虑去除
        {
            invalidMethod(request, response);
            return;
        }
        ServletAction annotation = method.getAnnotation(ServletAction.class);
        try
        {
            method.invoke(this, request, response);// 尝试调用
        } catch (IllegalAccessException | IllegalArgumentException e)
        {
            // 调用该方法时错误
            e.printStackTrace();
            String msg = "ComplexServlet::%s:\n" +
                    "调用方法时发生异常,请查看方法定义是否正确.";
            throw new RuntimeException(String.format(msg, method), e);
        } catch (InvocationTargetException e)
        {
            // 方法调用错误 即方法抛出的异常, 只关心被包装的异常
            Throwable cause = e.getCause();
            String errorMsg = "内部异常,请返回重试";
            if (Strings.isNullOrEmpty(annotation.errorMessage()))
            {
                errorMsg = annotation.errorMessage();
            }

            // 该异常总会被处理
            if (cause instanceof ServletActionException)
            {

                if (!Strings.isNullOrEmpty(cause.getMessage()))
                {
                    errorMsg = cause.getMessage();
                }

                Servlets.on(request, response).error(errorMsg);

                // 如果还有内部异常 且设置了继续抛出 则抛出
                if (cause.getCause() != null && annotation.rethrow())
                {
                    // TODO: 抛出内部包装的异常还是抛出 ServletActionException
                    throw new RuntimeException(cause);
                }
            } else// 非 ServletActionException
            {
                // 查看该异常是否该被捕获
                Class<? extends Throwable>[] exceptions = annotation.handleException();
                boolean catched = false;

                for (int i = 0; i < exceptions.length && !catched; i++)
                {
                    if (exceptions[i].isAssignableFrom(cause.getClass()))// 匹配判断
                    {
                        catched = true;
                    }
                }

                // 不管异常处理如何,总会跳转到错误页面
                Servlets.on(request, response).error(errorMsg);

                if (catched && !annotation.rethrow())// 能被捕获,并且不需要再次抛出
                {
                    cause.printStackTrace();
                } else
                {
                    throw new RuntimeException(cause);
                }
            }// end if

        }
    }

    protected String getAction(HttpServletRequest request)
    {
        String action = request.getParameter("action");
        if (action != null)
        {
            action = action.trim();
        }
        return action;
    }

    /**
     * 处理请求动作无效
     */
    protected void invalidAction(HttpServletRequest request,
                                 HttpServletResponse response) throws ServletException, IOException
    {
        Servlets.on(request, response).error("请求无效,请返回重试");
    }

    /**
     * 处理请求方法无效
     */
    protected void invalidMethod(HttpServletRequest request,
                                 HttpServletResponse response) throws ServletException, IOException
    {
        Servlets.on(request, response).error("请求无效,请返回重试");
    }
}
