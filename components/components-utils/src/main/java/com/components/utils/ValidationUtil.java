package com.components.utils;



/**
 * 校验工具类
 */
public class ValidationUtil {

    public static void checkArgument(boolean expectExpression) {
        if (!expectExpression) {
            throw new IllegalArgumentException("");
        }
    }

    public static void checkArgument(boolean expectExpression, Object errorMessage) {
        if (!expectExpression) {
            throw new IllegalArgumentException(String.valueOf(errorMessage));
        }
    }

    public static void checkArgument(boolean expectExpression,
                                     String errorMessageTemplate,
                                     Object... errorMessageArgs) {
        if (!expectExpression) {
            throw new IllegalArgumentException(String.format(errorMessageTemplate, errorMessageArgs));
        }
    }


}
