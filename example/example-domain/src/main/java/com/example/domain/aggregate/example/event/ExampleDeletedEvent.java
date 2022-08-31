package com.example.domain.aggregate.example.event;

import com.example.domain.aggregate.example.constant.ExampleEventEnum;
import com.example.domain.aggregate.example.event.model.ExamplePayload;
import com.example.domain.aggregate.example.model.ExampleAggr;
import com.example.domain.share.event.aggr.AggrDomainEvent;


public class ExampleDeletedEvent extends AggrDomainEvent<ExamplePayload> {

    private ExampleDeletedEvent() {
        super();
    }

    public ExampleDeletedEvent(ExampleAggr oldAggr, ExampleAggr newAggr) {
        super(
                newAggr.getUniqueId(),
                ExampleEventEnum.EXAMPLE_DELETED_EVENT,
                ExamplePayload.fromAggr(oldAggr),
                ExamplePayload.fromAggr(newAggr)
        );
    }
}
