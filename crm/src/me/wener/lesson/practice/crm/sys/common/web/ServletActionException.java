package me.wener.lesson.practice.crm.sys.common.web;

public class ServletActionException extends Exception
{
    private static final long serialVersionUID = 1L;

    public ServletActionException()
    {
        super();
    }

    public ServletActionException(String message)
    {
        super(message);
    }

    public ServletActionException(String message, Throwable cause)
    {
        super(message, cause);
    }

    protected ServletActionException(String message, Throwable cause,
                                     boolean enableSuppression, boolean writableStackTrace)
    {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
