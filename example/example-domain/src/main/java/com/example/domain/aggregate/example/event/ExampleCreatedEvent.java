package com.example.domain.aggregate.example.event;

import com.example.domain.aggregate.example.constant.ExampleEventEnum;
import com.example.domain.aggregate.example.event.model.ExamplePayload;
import com.example.domain.aggregate.example.model.ExampleAggr;
import com.example.domain.share.event.aggr.AggrDomainEvent;


public class ExampleCreatedEvent extends AggrDomainEvent<ExamplePayload> {

    private ExampleCreatedEvent() {
        super();
    }

    public ExampleCreatedEvent(ExampleAggr aggr, String eventTag) {
        super(
                aggr.getUniqueId(),
                ExampleEventEnum.EXAMPLE_CREATED_EVENT,
                eventTag,
                ExamplePayload.fromAggr(aggr)
        );
    }
}
