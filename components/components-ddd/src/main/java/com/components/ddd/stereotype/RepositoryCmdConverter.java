package com.components.ddd.stereotype;

/**
 * @Author: jzj
 * @Date: 2022/2/18
 * @Desc:
 */
public interface RepositoryCmdConverter<AGGREGATE extends AggregateRoot, PersistentObject extends PO> {
    /**
     * po 反序列化 AGGREGATE
     *
     * @param po
     * @return aggregate
     */
    AGGREGATE deserialize(PersistentObject po);

    /**
     * AGGREGATE 序列化 po
     *
     * @param aggr 聚合
     * @return po
     */
    PersistentObject serialize(AGGREGATE aggr);

}
