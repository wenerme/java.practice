package me.wener.lesson.practice.crm.sys.common;

import com.google.common.hash.Hashing;

public final class Encryptor
{
    private Encryptor()
    {
    }

    public static String password(String pass)
    {
        return md5(pass);
    }

    public static String md5(CharSequence chars)
    {
        return Hashing.md5().hashString(chars, Same.CHARSET).toString();
    }

    public static String sha1(CharSequence chars)
    {
        return Hashing.sha1().hashString(chars, Same.CHARSET).toString();
    }
}
