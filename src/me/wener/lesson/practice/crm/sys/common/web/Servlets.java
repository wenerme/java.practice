package me.wener.lesson.practice.crm.sys.common.web;

import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Enumeration;

public final class Servlets
{
    private Servlets()
    {
    }

    public static WithServlets on(HttpServletRequest request,
                                  HttpServletResponse response)
    {
        return new WithServlets(request, response);
    }

    public static class WithServlets
    {
        HttpServletRequest request;
        HttpServletResponse response;

        private WithServlets(HttpServletRequest request,
                             HttpServletResponse response)
        {
            this.request = request;
            this.response = response;
        }

        public <T> T getParameterAs(Class<T> clazz) throws IllegalAccessException, InstantiationException, InvocationTargetException
        {
            return getParameterInto(clazz.newInstance());
        }

        public <T> T getParameterInto(T t) throws InvocationTargetException, IllegalAccessException
        {
            Enumeration<String> names = request.getParameterNames();

            while (names.hasMoreElements())
            {
                String name = (String) names.nextElement();
                Object value = request.getParameter(name);

                BeanUtils.setProperty(t, name, value);
            }

            return t;
        }

        public void error(String message)
        {
            request.getSession().setAttribute("message", message);
            try
            {
                request.getRequestDispatcher("/error.jsp")
                        .forward(request, response);
            } catch (Exception e)
            {
                e.printStackTrace();
                try
                {
                    response.getWriter().write("内部错误,请联系管理员");
                } catch (IOException ex)
                {
                    ex.printStackTrace();
                }
                throw new RuntimeException("内部异常,请检查", e);
            }
        }
    }

}
