package me.wener.lesson.practice.crm.sys.common.action;

import com.google.common.collect.Lists;
import com.opensymphony.xwork2.conversion.TypeConversionException;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.apache.struts2.util.StrutsTypeConverter;

import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Map;


public class DateConvert extends StrutsTypeConverter
{
    private static List<String> datePatterns = Lists.newArrayList();

    static {
        datePatterns.add("yyyy-MM-dd");// add basic patterns
    }
    public static List<String> getDatePatterns()
    {
        return datePatterns;
    }

    @Override
    public Object convertFromString(Map context, String[] values, Class toClass)
    {
        try
        {
            return DateUtils.parseDate(values[0], datePatterns.toArray(new String[0]));
        } catch (ParseException e)
        {
            e.printStackTrace();
            throw new TypeConversionException(e);
        }
    }

    @Override
    public String convertToString(Map context, Object o)
    {
        if (o instanceof Date)
            return  DateFormatUtils.format((Date) o, datePatterns.get(0));

        throw new TypeConversionException(o+" can not format as Date string.");
    }
}
