package com.components.ddd.stereotype;

import java.util.Objects;

/**
 * 值对象标记接口
 */
public interface ValueObject<T> extends MarkerInterface {

    /**
     * 值对象通过属性比较
     *
     * @param other
     * @return
     */
    default boolean sameValueAs(T other) {
        return Objects.equals(this, other);
    }
}
