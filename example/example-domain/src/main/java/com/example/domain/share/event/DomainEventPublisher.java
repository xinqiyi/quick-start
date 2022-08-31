package com.example.domain.share.event;

/**
 * 领域事件发布接口
 */
public interface DomainEventPublisher<EVENT extends DomainEvent>  {

    /**
     * 发布事件
     *
     * @param event event
     */
    void publish(EVENT event);
}
