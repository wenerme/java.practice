package me.wener.lesson.practice.crm.sys.admin.web.servlet;

import me.wener.lesson.practice.crm.sys.admin.entity.Admin;
import me.wener.lesson.practice.crm.sys.admin.service.impl.AdminService;
import me.wener.lesson.practice.crm.sys.common.web.*;
import me.wener.lesson.practice.crm.sys.common.web.servlet.ComplexServlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class AdminActionServlet extends ComplexServlet
{
    private static final long serialVersionUID = 1L;


    /**
     * 用户登录
     */
    @ServletAction(method = {RequestMethod.POST})
    public void login(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        String checkNum = request.getParameter("checkNum");

        if (checkNum == null || ! checkNum.equals(Sessions.on(request).getVerifyCode()))
            throw  new ServletActionException("验证码错误,请返回重试");

        String username = request.getParameter("username");

        Admin admin = new AdminService().login(username, request.getParameter("password"));
        if (admin == null)
            throw  new ServletActionException("用户名或密码错误,请返回重试");

        Sessions.on(request).setUser(admin).set("admin", admin);
        response.sendRedirect(request.getContextPath() + "/menu");
    }

    /**
     * 用户注销
     */
    @ServletAction(method = {RequestMethod.POST, RequestMethod.GET})
    public void logout(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        Sessions.on(request).clearUser();
        response.sendRedirect(request.getContextPath() + "/login.jsp");
    }
}
