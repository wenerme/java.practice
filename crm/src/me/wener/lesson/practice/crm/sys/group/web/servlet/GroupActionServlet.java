package me.wener.lesson.practice.crm.sys.group.web.servlet;

import com.google.common.base.Strings;
import me.wener.lesson.practice.crm.sys.common.Paging;
import me.wener.lesson.practice.crm.sys.common.web.*;
import me.wener.lesson.practice.crm.sys.common.web.servlet.ListDominateServlet;
import me.wener.lesson.practice.crm.sys.group.entity.Group;
import me.wener.lesson.practice.crm.sys.group.service.impl.GroupService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Enumeration;

public class GroupActionServlet extends ListDominateServlet<Group>
{
    private static final long serialVersionUID = 1L;

    @ServletAction(method = {RequestMethod.POST}, errorMessage = "添加失败,请返回重试")
    public void addGroup(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        Enumeration<String> names = request.getParameterNames();
        Group group = Servlets.on(request, response).getParameterAs(Group.class);

        getService().add(group);
        list(request, response);
    }

    @ServletAction(method = {RequestMethod.POST}, errorMessage = "删除失败,请返回重试")
    public void deleteGroup(HttpServletRequest request, HttpServletResponse response) throws Exception
    {

        String[] ids = request.getParameterValues("ids");
        GroupService serv = getService();
        for (String id : ids)
        {
            serv.deleteById(Integer.parseInt(id));
        }
        list(request, response);

    }

    @Override
    public GroupService getService()
    {
        return new GroupService();
    }

    @Override
    public Class<Group> getType()
    {
        return Group.class;
    }

    @Override
    public String getListUrl()
    {
        return "/sys/group/list.jsp";
    }


    @ServletAction(method = {RequestMethod.GET, RequestMethod.POST}, errorMessage = "查找部门失败,请返回重试")
    public void searchByDepartment(HttpServletRequest request, HttpServletResponse response) throws Exception
    {

        String department = request.getParameter("department");
        if (Strings.isNullOrEmpty(department))
        {
            showList(request, response);
        } else
        {
            Paging<Group> page = getService().findGroupByDepartment(department);
            Sessions.on(request).set("department", department);

            showList(page, request, response);

        }
    }

}
