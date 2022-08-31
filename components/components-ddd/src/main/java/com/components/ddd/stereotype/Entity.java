package com.components.ddd.stereotype;

/**
 * 实体标记
 */
public interface Entity<T> extends MarkerInterface {
    /**
     * 实体唯一标识
     *
     * @return
     */
    T getUniqueId();
}
