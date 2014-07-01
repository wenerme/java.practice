package me.wener.practices.web.common.entity;

import java.util.EnumMap;

/**
 * 根据 ISO/IEC_5218
 * <pre>
 * 0 = not known,
 * 1 = male,
 * 2 = female,
 * 9 = not applicable.
 * </pre>
 * @see <a href="http://en.wikipedia.org/wiki/ISO/IEC_5218">ISO/IEC_5218</a>
 */
public enum Sex
{
    Unknown(0)
    , Male(1)
    , Female(2)
    , NotApplicable(9);

    byte value;
    Sex(int val)
    {
        value = (byte) val;
    }

    private final static EnumMap<Sex, String> texts;
    static {
        texts = new EnumMap<Sex, String>(Sex.class);
        texts.put(Sex.Male,"男");
        texts.put(Sex.Female,"女");
        texts.put(Sex.Unknown,"未知");
        texts.put(Sex.NotApplicable,"不可用");
    }

//    @Override
//    public String toString()
//    {
//        return String.valueOf(value);
//    }
    public String getText()
    {
        return texts.get(this);
    }
}
