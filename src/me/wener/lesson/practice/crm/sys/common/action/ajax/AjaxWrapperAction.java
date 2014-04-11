package me.wener.lesson.practice.crm.sys.common.action.ajax;

import lombok.Getter;

import java.io.Serializable;

public class AjaxWrapperAction extends GeneralAjaxAction
        implements Serializable
{
    @Getter
    private String state = SUCCESS;
    @Getter
    private String error = null;
    @Getter
    private Object data = null;

    @Override
    public String execute() throws Exception
    {
        data = getWrappedData();
        return SUCCESS;
    }
}
