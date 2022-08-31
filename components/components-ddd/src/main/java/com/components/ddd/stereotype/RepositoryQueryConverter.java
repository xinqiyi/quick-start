package com.components.ddd.stereotype;

import java.util.List;

/**
 * @Author: jzj
 * @Date: 2022/2/18
 * @Desc:
 */
public interface RepositoryQueryConverter<PersistentAbilityObject extends PO, PersistentObject extends PO> {
    /**
     * po 反序列化 PersistentAbilityObject
     *
     * @param po
     * @return PersistentAbilityObject
     */
    PersistentAbilityObject deserialize(PersistentObject po);
    List<PersistentAbilityObject> deserialize(List<PersistentObject> po);

    /**
     * PersistentAbilityObject 序列化 po
     *
     * @param aggr 聚合
     * @return po
     */
    PersistentObject serialize(PersistentAbilityObject aggr);

}
