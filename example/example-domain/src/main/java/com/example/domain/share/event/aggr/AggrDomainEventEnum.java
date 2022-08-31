package com.example.domain.share.event.aggr;

import com.example.domain.share.event.DomainEventEnum;

/**
 * @Author: jzj
 * @Date: 2022/5/28
 * @Desc:
 */
public interface AggrDomainEventEnum extends DomainEventEnum {
    /**
     * 聚合名称
     *
     * @return
     */
    String getAggrName();

    /**
     * 关联聚合
     * 通过事件类型、关联聚合、事件内容，可以确定事件以及该事件对应的聚合
     * 重建聚合的数据来自eventPayload
     */
    String getAggrEventType();

    /**
     * 聚合事件描述
     *
     * @return
     */
    String getAggrEventDesc();
}
