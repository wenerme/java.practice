package me.wener.lesson.practice.crm.sys.common.test;

import lombok.Data;
import lombok.experimental.Accessors;
import me.wener.lesson.practice.crm.sys.common.Values;
import me.wener.lesson.practice.crm.sys.group.entity.Group;
import me.wener.lesson.practice.crm.sys.user.entity.User;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;

import static org.junit.Assert.assertTrue;



public class TestValues
{
    @Test
    public void testValuesCast() throws ParseException
    {
        assertTrue("boolean: ", Values.of(boolean.class, "true"));
        assertTrue(Values.of(Date.class, "2014-10-1") == DateUtils.parseDate("2014-10-1", "yyyy-yy-d"));
    }

    @Test
    public void testBeanUtils() throws InvocationTargetException, IllegalAccessException, NoSuchMethodException
    {
        Group group = new Group();
        User user = new User();
        BeanUtils.setProperty(group, "id", "235");
        BeanUtils.setProperty(user, "id", "235");
        System.out.printf("group %s == user %s\n", BeanUtils.getProperty(group, "id"), BeanUtils.getProperty(user, "id"));

        Stranger stranger = new Stranger();
        BeanUtils.setProperty(stranger, "name", "wener");
        BeanUtils.setProperty(stranger, "xname", "xwener");
        BeanUtils.setProperty(stranger, "yname", "ywener");

        System.out.println(stranger);
    }

    @Test
    public void testConvert()
    {
        ArrayList<Object> ol = new ArrayList<Object>();
        ol.add("wener");
        ArrayList<String> sl = new ArrayList<String>();
        sl.add("xiao");

        ArrayList<Integer> il = new ArrayList<Integer>();
        il.add(520);
        System.out.println(((ArrayList<Integer>) (Object) sl).add(123));
        System.out.println(sl);
    }

    @Data
    public static class Stranger
    {
        @Accessors(chain = true)
        String name;
        String xname;
        String yname;

        public Stranger setYname(String yname)
        {
            this.yname = yname;
            return this;
        }
    }


}
//
//class CA
//{
//}
//
//class CB extends CA
//{
//}
//interface IG
//{
//    public <T extends CA> void set(T val);
//}
//class CIG implements IG
//{
//    public void set(CB val)
//    {
//    }
//}
