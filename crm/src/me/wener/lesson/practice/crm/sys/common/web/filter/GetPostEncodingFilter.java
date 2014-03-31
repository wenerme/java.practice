package me.wener.lesson.practice.crm.sys.common.web.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class GetPostEncodingFilter
        implements Filter
{

    @Override
    public void destroy()
    {
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res,
                         FilterChain chain) throws IOException, ServletException
    {
        if (req instanceof HttpServletRequest)
        {
            req = new WithEncodingRequest((HttpServletRequest) req).getProxy();
        }
        chain.doFilter(req, res);
    }

    @Override
    public void init(FilterConfig arg0) throws ServletException
    {
    }

}

class WithEncodingRequest
{
    HttpServletRequest request;

    public WithEncodingRequest(HttpServletRequest request)
    {
        this.request = request;
    }

    public HttpServletRequest getProxy()
    {

        return (HttpServletRequest) Proxy.newProxyInstance(request.getClass().getClassLoader(),
                request.getClass().getInterfaces(), new InvocationHandler()
                {
                    @Override
                    public Object invoke(Object object, Method method, Object[] args)
                            throws Throwable
                    {
                        Object result = null;
                        String methodName = method.getName();
                        String requestMethod = request.getMethod();

                        if (methodName.equals("getParameter"))
                        {

                            request.setCharacterEncoding("UTF-8");
                            if (requestMethod.equals("POST"))
                            {
                                request.setCharacterEncoding("UTF-8");
                            }
                            result = request.getParameter((String) args[0]);
                            result = method.invoke(request, args);
                        } else
                        {
                            result = method.invoke(request, args);
                        }
                        return result;
                    }
                }
        );
    }
}
