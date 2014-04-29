package me.wener.practices.crm.sys.employee;


import com.google.common.base.Strings;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.interceptor.annotations.InputConfig;
import javax.inject.Inject;
import javax.inject.Named;
import me.wener.practices.crm.sys.employee.entity.UserEntity;
import me.wener.practices.crm.sys.employee.service.UserService;
import me.wener.practices.web.common.action.ListDominateAction;
import org.apache.struts2.ServletActionContext;

@Named
public class UserAction extends ListDominateAction<UserService, UserEntity>
{

    public static final String REGISTER = "REGISTER";

    @Inject
    @Override
    public void setService(UserService service)
    {
        super.setService(service);
    }

    @Inject
    @Override
    public void setModel(UserEntity model)
    {
        super.setModel(model);
    }


    public String login()
    {
        if (isGet())
            return INPUT;
        else
            return "toIndex";
    }

    public String index()
    {
        if (getUser() == null)
        {
            addFieldError("error", "请先登录.");
            return INPUT;
        }
        return "index";
    }

    @Override
    public String edit() throws Exception
    {
        if (isGet())
            ActionContext.getContext().getValueStack().set("departments", service().departments());

        return super.edit();
    }

    @Override
    protected String handleEdit()
    {
        service().editTo(model());
        return null;
    }

    public void validateLogin()
    {
        if (isGet())
            return;
        if (Strings.isNullOrEmpty(model().getAccount()))
            addFieldError("error", "请输入帐号");
        if (Strings.isNullOrEmpty(model().getPassword()))
            addFieldError("error", "请输入密码");

        if (getFieldErrors().size() == 0)
        {
            UserEntity user = service().login(model().getAccount(), model().getPassword());
            if (user == null)
                addFieldError("error", "用户名或密码不正确");
            else
                setUser(user);
        }
    }

    public String logout()
    {
        ServletActionContext.getRequest().getSession().invalidate();
        return INPUT;
    }

    @InputConfig(resultName = REGISTER)
    public String register()
    {
        if (isGet())
            return REGISTER;
        return "toIndex";
    }

    public void validateRegister()
    {
        if (isGet())
            return;
        if (Strings.isNullOrEmpty(model().getName()))
            addFieldError("error", "用户名必填");

        if (Strings.isNullOrEmpty(model().getAccount()))
            addFieldError("error", "帐号必填");

        if (Strings.isNullOrEmpty(model().getPassword()))
            addFieldError("error", "密码必填");

        if (getFieldErrors().size() == 0)
        {
            if (service().isAccountExists(model().getAccount()))
            {
                addFieldError("error", "该帐号已存在");
                return;
            }

            service().register(model());
            setUser(model());
        }

    }

    protected UserEntity getUser()
    {
        return session("user", UserEntity.class);
    }

    protected void setUser(UserEntity user)
    {
        session("user", user);
    }
}
