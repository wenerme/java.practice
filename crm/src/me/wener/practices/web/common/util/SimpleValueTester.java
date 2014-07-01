package me.wener.practices.web.common.util;


public class SimpleValueTester implements ValueTester
{
    @Override
    public boolean isNull(Object val)
    {
        return val == null;
    }

    @Override
    public boolean isEmpty(Object val)
    {
        return isString(val) && val.toString().length() == 0;
    }

    @Override
    public boolean isString(Object val)
    {
        return val instanceof String;
    }

    @Override
    public boolean isNullOrEmpty(Object val)
    {
        return isNull(val) || isEmpty(val);
    }

    @Override
    public boolean isValid(Object val, boolean testNull, boolean testEmpty)
    {
        return (testNull || isNull(val)) && (testEmpty || isEmpty(val));
    }
}
