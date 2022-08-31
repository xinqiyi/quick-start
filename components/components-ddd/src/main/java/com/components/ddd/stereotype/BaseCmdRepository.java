package com.components.ddd.stereotype;

import java.io.Serializable;
import java.util.List;

/**
 * 命令 基础仓储接口
 * 1、增删改
 * 2、特例：通过id查询返回聚合
 */
public interface BaseCmdRepository<AGGREGATE extends AggregateRoot, ID extends Serializable> {
    /**
     * id查询
     *
     * @param id
     * @return
     */
    default AGGREGATE findById(ID id) {
        throw new UnsupportedOperationException("Not Implemented");
    }

    /**
     * 批量查询
     *
     * @param ids
     * @return
     */
    default List<AGGREGATE> findAll(List<ID> ids) {
        throw new UnsupportedOperationException("Not Implemented");
    }

    /**
     * 保存聚合根
     *
     * @param aggregate
     * @return
     */
    default int save(AGGREGATE aggregate) {
        throw new UnsupportedOperationException("Not Implemented");
    }
    /**
     * 更新聚合根
     * @param aggregate
     * @return
     */
    default int update(AGGREGATE aggregate) {
        throw new UnsupportedOperationException("Not Implemented");
    }

    /**
     * 删除
     *
     * @param id
     */
    default void delete(ID id) {
        throw new UnsupportedOperationException("Not Implemented");
    }

}
