package com.example.south.publisher.kafka;

import com.components.utils.JsonUtil;
import com.components.utils.ValidationUtil;
import com.example.domain.share.event.DomainEventPublisher;
import com.example.domain.share.event.aggr.AggrDomainEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Objects;


/**
 * 事件统一发送实现类
 */
@Slf4j
@Component("aggrDomainEventPublisher4Kafka")
public class AggrDomainEventPublisher4KafkaImpl implements DomainEventPublisher<AggrDomainEvent> {

    @Override
    public void publish(AggrDomainEvent event) {
        ValidationUtil.checkArgument(Objects.nonNull(event), "event can be not null");

        log.info("event = {}", JsonUtil.toJson(event));
    }
}
