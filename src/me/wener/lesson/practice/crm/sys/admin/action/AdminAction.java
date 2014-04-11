package me.wener.lesson.practice.crm.sys.admin.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import lombok.Getter;
import lombok.Setter;
import me.wener.lesson.practice.crm.sys.admin.entity.Admin;
import me.wener.lesson.practice.crm.sys.admin.service.impl.AdminService;
import org.apache.struts2.interceptor.ServletRequestAware;

import javax.servlet.http.HttpServletRequest;

public class AdminAction extends ActionSupport implements ServletRequestAware
{
    @Setter
    @Getter
    private String username;
    @Setter
    @Getter
    private String password;
    @Setter
    @Getter
    private String verifyCode;

    private HttpServletRequest httpRequest;

    public String login() throws Exception
    {
        // GET 请求 返回登录页面
        if (httpRequest.getMethod().toUpperCase().equals("GET"))
            return "input";

        // 如果验证通过,则一切OK
        return this.SUCCESS;
    }

    public void validateLogin() throws Exception
    {
        // GET 请求不处理
        if (httpRequest.getMethod().toUpperCase().equals("GET"))
            return;

        if (verifyCode == null)
            addFieldError("result", "请输入验证码");
        else if (!verifyCode.equals(getRealVerifyCode()))
            addFieldError("result", "验证码错误");
        else
        {
            Admin admin = getService().login(username, password);
            if (admin == null)
                addFieldError("result", "用户名或密码错误");
            setAdmin(admin);
        }
    }

    public String logout()
    {
        setAdmin(null);
        return this.SUCCESS;
    }

    public String menu()
    {
        if (getAdmin() == null)
            return "login";
        return this.SUCCESS;
    }

    public Admin getAdmin()
    {
        return (Admin) ActionContext.getContext().getSession().get("admin");
    }

    public void setAdmin(Admin admin)
    {
        ActionContext.getContext().getSession().put("admin", admin);
    }

    protected AdminService getService()
    {
        return new AdminService();
    }

    protected String getRealVerifyCode()
    {
        return (String) ActionContext.getContext().getSession().get("SESSION_VERIFY_CODE");
    }

    @Override
    public void setServletRequest(HttpServletRequest request)
    {
        httpRequest = request;
    }
}
