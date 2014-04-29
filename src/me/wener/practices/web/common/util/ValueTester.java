package me.wener.practices.web.common.util;


public interface ValueTester
{
    boolean isNull(Object val);
    boolean isEmpty(Object val);
    boolean isString(Object val);
    boolean isNullOrEmpty(Object val);
    boolean isValid(Object val, boolean testNull, boolean testEmpty);
}
