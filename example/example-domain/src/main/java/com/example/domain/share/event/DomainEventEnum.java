package com.example.domain.share.event;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 领域事件业务类型枚举
 */

public interface DomainEventEnum {
    /**
     * 事件类型
     *
     * @return
     */
    EventEnum getEventType();

    @AllArgsConstructor
    enum EventEnum {

        CREATED("CREATED", "已创建事件"),
        UPDATED("UPDATED", "已修改事件"),
        DELETED("DELETED", "已删除事件"),
        ;

        @Getter
        private String code;

        @Getter
        private String desc;
    }
}
