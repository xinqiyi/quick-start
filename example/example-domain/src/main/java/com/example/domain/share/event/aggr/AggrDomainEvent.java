package com.example.domain.share.event.aggr;

import com.components.utils.LoginUserUtil;
import com.components.utils.StringUtil;
import com.components.utils.ValidationUtil;
import com.example.domain.share.event.DomainEvent;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

/**
 * 领域事件基类
 *
 * @author jzj
 */
@Getter
@Setter
public abstract class AggrDomainEvent<T> extends DomainEvent<T> {
    /**
     * 聚合id
     */
    private String aggrId;
    /**
     * 聚合名称
     */
    private String aggrName;
    /**
     * 聚合事件类型
     */
    private String aggrEventType;

    public AggrDomainEvent() {
        super();
    }

    public AggrDomainEvent(String aggrId, AggrDomainEventEnum aggrEventType, String eventTag, T preEventPayload, T eventPayload) {
        super(aggrEventType.getEventType(), eventTag, preEventPayload, eventPayload);
        this.bindAggrDomainEvent(aggrId, aggrEventType);
    }
    public AggrDomainEvent(String aggrId, AggrDomainEventEnum aggrEventType, T preEventPayload, T eventPayload) {
        super(aggrEventType.getEventType(), preEventPayload, eventPayload);
        this.bindAggrDomainEvent(aggrId, aggrEventType);
    }

    public AggrDomainEvent(String aggrId, AggrDomainEventEnum aggrEventType, String eventTag, T newPayload) {
        super(aggrEventType.getEventType(), eventTag, newPayload);
        this.bindAggrDomainEvent(aggrId, aggrEventType);
    }
    public AggrDomainEvent(String aggrId, AggrDomainEventEnum aggrEventType, T newPayload) {
        super(aggrEventType.getEventType(), newPayload);
        this.bindAggrDomainEvent(aggrId, aggrEventType);
    }

    private void bindAggrDomainEvent(String aggrId, AggrDomainEventEnum aggrEventType) {
        ValidationUtil.checkArgument(StringUtil.isNotBlank(aggrId), "aggrId can be not Blank");
        this.aggrId = aggrId;

        ValidationUtil.checkArgument(Objects.nonNull(aggrEventType), "aggrEventType  can be not null");
        this.aggrEventType = aggrEventType.getAggrEventType();
        this.aggrName = aggrEventType.getAggrName();
    }


    /**
     * 领域事件的key, 用于保证顺序
     *
     * @return
     */
    @Override
    public String getKey() {
        return LoginUserUtil.getCompanyUuid() + getAggrId();
    }
}
