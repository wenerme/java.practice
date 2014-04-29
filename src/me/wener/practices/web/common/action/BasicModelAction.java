package me.wener.practices.web.common.action;


import com.opensymphony.xwork2.ModelDriven;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import me.wener.practices.web.common.service.BaseService;
import org.apache.struts2.interceptor.ServletRequestAware;

import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;

public abstract class BasicModelAction<SVC extends BaseService<T, ID>, T, ID extends Serializable>
        extends BasicAction
        implements ModelDriven<T> , ServletRequestAware
{
    @Getter
    @Setter
    private HttpServletRequest servletRequest;

    @Getter
    @Setter
    private T model;
    @Setter
    private SVC service;

    protected T model(){return model;}
    protected SVC service(){return service;}

    protected boolean isGet()
    {
        return servletRequest.getMethod().equals("GET");
    }

    protected boolean isPost()
    {
        return servletRequest.getMethod().equals("POST");
    }
}
