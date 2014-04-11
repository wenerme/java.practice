package me.wener.lesson.practice.crm.sys.common.action.ajax;


public interface IGeneralAjaxAction
{
    public final static String DATA_KEY = "DATA_KEY";
    public final static String WRAPPED_JSON = "wrapped-json";

    Object getWrappedData();
    void setWrappedData(Object data);
}
