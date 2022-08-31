package com.example.domain.aggregate.example.constant;

import com.example.domain.share.event.DomainEventEnum;
import com.example.domain.share.event.aggr.AggrDomainEventEnum;
import lombok.AllArgsConstructor;

import static com.example.domain.share.event.DomainEventEnum.EventEnum.*;


@AllArgsConstructor
public enum ExampleEventEnum implements AggrDomainEventEnum {

    EXAMPLE_CREATED_EVENT(CREATED,"ExampleAggr", "ExampleCreatedEvent", "example创建事件"),
    EXAMPLE_UPDATED_EVENT(UPDATED,"ExampleAggr", "ExampleUpdatedEvent", "example更新事件"),
    EXAMPLE_DELETED_EVENT(DELETED,"ExampleAggr","ExampleDeletedEvent",  "example删除事件"),
    ;
    private DomainEventEnum.EventEnum eventType;

    private String aggrName;

    private String aggrEventType;

    private String aggrEventDesc;

    @Override
    public DomainEventEnum.EventEnum getEventType() {
        return this.eventType;
    }

    @Override
    public String getAggrName() {
        return this.aggrName;
    }

    @Override
    public String getAggrEventType() {
        return this.aggrEventType;
    }

    @Override
    public String getAggrEventDesc() {
        return this.aggrEventDesc;
    }
}
