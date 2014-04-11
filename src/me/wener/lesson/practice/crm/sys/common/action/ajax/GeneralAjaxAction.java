package me.wener.lesson.practice.crm.sys.common.action.ajax;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import lombok.Getter;
import org.apache.struts2.interceptor.ServletRequestAware;

import javax.servlet.http.HttpServletRequest;

public class GeneralAjaxAction extends ActionSupport
        implements ServletRequestAware, IGeneralAjaxAction
{
    @Getter
    private HttpServletRequest request;

    @Override
    public void setServletRequest(HttpServletRequest request)
    {
        this.request = request;
    }

    @Override
    public Object getWrappedData()
    {
        return ActionContext.getContext().get(DATA_KEY);
    }

    @Override
    public void setWrappedData(Object data)
    {
        ActionContext.getContext().put(DATA_KEY, data);
    }

}
