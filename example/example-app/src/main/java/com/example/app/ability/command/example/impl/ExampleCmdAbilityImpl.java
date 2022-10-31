package com.example.app.ability.command.example.impl;

import com.components.utils.ValidationUtil;
import com.example.app.ability.command.example.ExampleCmdAbility;
import com.example.app.ability.command.example.cmd.CreateExampleAbilityCmd;
import com.example.app.ability.command.example.result.CreateExampleAbilityResult;
import com.example.domain.aggregate.example.event.model.ExamplePayload;
import com.example.domain.aggregate.example.model.ExampleAggr;
import com.example.domain.aggregate.example.repository.ExampleCmdRepository;
import com.example.domain.share.event.DomainEvent;
import com.example.domain.share.event.DomainEventPublisher;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Objects;

@Slf4j
@Service
public class ExampleCmdAbilityImpl implements ExampleCmdAbility {
    @Resource(name = "aggrDomainEventPublisher4Kafka")
    private DomainEventPublisher<DomainEvent<ExamplePayload>> domainEventPublisher;

    @Autowired
    private ExampleCmdRepository exampleCmdRepository;

    @Override
    public CreateExampleAbilityResult createExample(CreateExampleAbilityCmd appCmd) {
        return null;
    }

    @Override
    public void publish(DomainEvent<ExamplePayload> domainEvent) {
        domainEventPublisher.publish(domainEvent);
    }

    @Override
    public ExampleAggr findByIdOrElseThrow(String exampleUuid) {
        ExampleAggr oldExampleAggr = exampleCmdRepository.findById(exampleUuid);

        ValidationUtil.checkArgument(Objects.nonNull(oldExampleAggr), "exampleUuid = %s 不存在", exampleUuid);

        return oldExampleAggr;
    }
}
