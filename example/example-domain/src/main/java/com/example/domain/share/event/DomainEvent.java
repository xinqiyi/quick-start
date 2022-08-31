package com.example.domain.share.event;

import com.components.ddd.model.DTO;
import com.components.utils.StringUtil;
import com.components.utils.UuidUtil;
import com.components.utils.ValidationUtil;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * 领域事件基类
 *
 * @author jzj
 */
@Getter
@Setter
public abstract class DomainEvent<T> extends DTO {
    /**
     * 幂等键:即为当前事件的id
     */
    private String eventId;
    /**
     * 事件类型
     */
    private DomainEventEnum.EventEnum eventType;
    /**
     * 事件tag; 可以为空
     */
    private String eventTag;
    /**
     * 变更前数据
     */
    private T preEventPayload;
    /**
     * 事件数据
     */
    private T eventPayload;
    /**
     * 事件时间
     */
    private LocalDateTime eventTime;

    public DomainEvent() {
    }

    public DomainEvent(DomainEventEnum.EventEnum eventType, String eventTag, T preEventPayload, T eventPayload) {
        this(eventType, preEventPayload, eventPayload);

        checkEventTagIsNotBlank(eventTag);
        this.eventTag = eventTag;
    }
    public DomainEvent(DomainEventEnum.EventEnum eventType, String eventTag, T eventPayload) {
        this(eventType, eventPayload);

        checkEventTagIsNotBlank(eventTag);
        this.eventTag = eventTag;
    }

    public DomainEvent(DomainEventEnum.EventEnum eventType, T preEventPayload, T eventPayload) {
        this(eventType, eventPayload);

        ValidationUtil.checkArgument(Objects.nonNull(preEventPayload), "preEventPayload can be not null");
        this.preEventPayload = preEventPayload;
    }

    public DomainEvent(DomainEventEnum.EventEnum eventType, T eventPayload) {
        ValidationUtil.checkArgument(Objects.nonNull(eventType), "eventType  can be not null");
        this.eventType = eventType;

        ValidationUtil.checkArgument(Objects.nonNull(eventPayload), "eventPayload  can be not null");
        this.eventPayload = eventPayload;

        this.eventId = UuidUtil.geneUuidString();
        this.eventTime = LocalDateTime.now();
    }

    private void checkEventTagIsNotBlank(String eventTag){
        ValidationUtil.checkArgument(StringUtil.isNotBlank(eventTag), "eventTag can be not null");
    }


    /**
     * 领域事件的key, 用于保证顺序
     *
     * @return
     */
    public abstract String getKey();
}
