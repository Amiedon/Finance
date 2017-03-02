package com.seu.util;

import java.util.UUID;

/**
 * 生成随机字符串的工具类
 * Created by Amie on 2017/3/2.
 */
public class UUIDUtils {
    public static String getUUID()
    {
        return UUID.randomUUID().toString().replace("-","");
    }
}
