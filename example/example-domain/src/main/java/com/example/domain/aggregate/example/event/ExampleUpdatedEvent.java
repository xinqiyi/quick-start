package com.example.domain.aggregate.example.event;

import com.example.domain.aggregate.example.constant.ExampleEventEnum;
import com.example.domain.aggregate.example.event.model.ExamplePayload;
import com.example.domain.aggregate.example.model.ExampleAggr;
import com.example.domain.share.event.aggr.AggrDomainEvent;


public class ExampleUpdatedEvent extends AggrDomainEvent<ExamplePayload> {

    private ExampleUpdatedEvent() {
        super();
    }

    public ExampleUpdatedEvent(ExampleAggr oldAggr, ExampleAggr newAggr) {
        super(
                newAggr.getUniqueId(),
                ExampleEventEnum.EXAMPLE_UPDATED_EVENT,
                ExamplePayload.fromAggr(oldAggr),
                ExamplePayload.fromAggr(newAggr)
        );
    }
}
