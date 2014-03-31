package me.wener.lesson.practice.crm.sys.common;

public final class Values
{
    /**
     * 泛型类型转换
     */
    public static <T> T of(Class<T> clazz, String str)
    {
        Object value = null;
        T t = null;
        boolean converted = true;
        try
        {
            if (clazz == String.class)
            {
                value = str;
            } else if (clazz == Void.class)
            {
                value = null;
            } else if (clazz == Integer.class || clazz == int.class)
            {
                value = Integer.parseInt(str);
            } else if (clazz == Boolean.class || clazz == boolean.class)
            {
                value = Boolean.parseBoolean(str);
            } else if (clazz == Float.class || clazz == float.class)
            {
                value = Float.parseFloat(str);
            } else if (clazz == Long.class || clazz == long.class)
            {
                value = Long.parseLong(str);
            } else if (clazz == Double.class || clazz == double.class)
            {
                value = Double.parseDouble(str);
            } else if (clazz == Character.class || clazz == char.class)
            {
                value = Character.codePointAt(str, 0);
            } else if (clazz == Short.class || clazz == short.class)
            {
                value = Short.parseShort(str);
            } else if (clazz == Byte.class || clazz == byte.class)
            {
                value = Byte.parseByte(str);
            } else
            {
                converted = false;
            }

            if (converted)
                t = (T) value;
        } catch (Exception e)
        {
            throw new ClassCastException("类型转换失败,ErrorMessage:\n" + e.getMessage());
        }

        if (!converted)
        {
            throw new ClassCastException("类型转换失败: to:" + clazz);
        }

        return t;
    }

    /**
     * 测试一个对象的所有字段都为Null
     */
    public static boolean isAllNull()
    {
        return false;
    }

}
