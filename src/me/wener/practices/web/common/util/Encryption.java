package me.wener.practices.web.common.util;

import com.google.common.hash.Hashing;

public final class Encryption
{
    private Encryption()
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
