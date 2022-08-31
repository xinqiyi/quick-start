package com.components.utils;

import java.util.UUID;

/**
 * @Author: jzj
 * @Date: 2022/8/31
 * @Desc:
 */
public class UuidUtil {
    private UuidUtil() {
    }

    public static String geneUuidString() {
        return UUID.randomUUID().toString().replace("-", "");
    }
}
