package me.wener.lesson.practice.crm.sys.user.web.servlet;

import com.google.common.base.Strings;
import me.wener.lesson.practice.crm.sys.common.web.*;
import me.wener.lesson.practice.crm.sys.common.web.servlet.ListDominateServlet;
import me.wener.lesson.practice.crm.sys.user.UserSearchCondition;
import me.wener.lesson.practice.crm.sys.user.entity.User;
import me.wener.lesson.practice.crm.sys.user.service.impl.UserService;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.DateConverter;
import org.apache.commons.beanutils.converters.DateTimeConverter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.Enumeration;

public class UserActionServlet extends ListDominateServlet<User>
{
    private static final long serialVersionUID = 1L;

    public UserActionServlet()
    {
        // register the date type
        DateTimeConverter dtConverter = new DateConverter();
        dtConverter.setPattern("yyyy-MM-dd");
        ConvertUtils.register(dtConverter, Date.class);
    }

    public static void main(String[] args) throws Exception
    {
        User user = new User();
        user.setCnname("init value");
        BeanUtils.setProperty(user, "id", "235");
        System.out.println("BeanUtils :" + user.getCnname());
        System.out.println("BeanUtils getter:" + BeanUtils.getProperty(user, "cnname"));
        BeanUtils.setProperty(user, "group.id", 2);
        BeanUtils.setProperty(user, "group.remark", "yes");
        BeanUtils.setProperty(user, "enabled", true);
        System.out.println("BeanUtils getter group.id:" + BeanUtils.getProperty(user, "group.id"));

        DateTimeConverter dtConverter = new DateConverter();
        dtConverter.setPattern("yyyy-MM-dd");
        ConvertUtils.register(dtConverter, Date.class);
        BeanUtils.setProperty(user, "beginDate", "2014-10-03");
        System.out.println(user);

        UserSearchCondition condition = new UserSearchCondition();
        BeanUtils.setProperty(condition, User.FIELD_ENABLED, "all");
        System.out.println(condition);

    }

    @ServletAction(method = {RequestMethod.GET, RequestMethod.POST}, errorMessage = "搜索失败,请返回重试")
    public void search(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        UserSearchCondition condition = Servlets.on(request, response).getParameterAs(UserSearchCondition.class);
        // 校正参数
        String enabled = request.getParameter(User.FIELD_ENABLED);
        if (enabled == null || enabled.equals("all"))
            condition.setEnabled(null);
        if (Strings.isNullOrEmpty(condition.getGroupId()))
            condition.setGroupId(null);

        request.getSession().setAttribute("condition", condition);

        showList(getService().search(condition), request, response);
    }

    @ServletAction(method = {RequestMethod.GET, RequestMethod.POST}, errorMessage = "启用失败,请返回重试")
    public void enable(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        String[] ids = request.getParameterValues("ids");
        UserService service = getService();
        for (String id : ids)
            service.enable(Integer.parseInt(id));

        showList(request, response);
    }

    @ServletAction(method = {RequestMethod.GET, RequestMethod.POST}, errorMessage = "禁用失败,请返回重试")
    public void disable(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        String[] ids = request.getParameterValues("ids");
        UserService service = getService();
        for (String id : ids)
            service.disable(Integer.parseInt(id));

        showList(request, response);
    }

    @ServletAction(action = "delete", method = {RequestMethod.GET, RequestMethod.POST}, errorMessage = "删除失败,请返回重试")
    public void deleteAction(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        String[] ids = request.getParameterValues("ids");
        UserService service = getService();
        for (String id : ids)
            service.delete(Integer.parseInt(id));

        showList(request, response);
    }

    @ServletAction(method = {RequestMethod.POST}, errorMessage = "添加失败,请返回重试")
    public void add(HttpServletRequest request, HttpServletResponse response) throws Exception
    {

        Enumeration<String> names = request.getParameterNames();
        User newItem = new User();

        while (names.hasMoreElements())
        {
            String name = (String) names.nextElement();
            Object value = request.getParameter(name);

            BeanUtils.setProperty(newItem, name, value);
        }
        //
        System.out.println("add new Item:\n" + newItem);
        getService().add(newItem);

        list(request, response);
    }

    private UserSearchCondition getCondition(HttpServletRequest request)
    {
        UserSearchCondition condition = (UserSearchCondition) request.getSession().getAttribute("condition");
        if (condition == null)
            condition = new UserSearchCondition();
        return condition;
    }

    @Override
    public UserService getService()
    {
        return new UserService();
    }

    @Override
    public Class<User> getType()
    {
        return User.class;
    }

    @Override
    public String getListUrl()
    {
        return "/sys/user/list.jsp";
    }
}
