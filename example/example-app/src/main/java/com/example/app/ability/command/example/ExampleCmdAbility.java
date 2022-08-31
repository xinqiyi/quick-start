package com.example.app.ability.command.example;

import com.example.app.ability.command.example.cmd.CreateExampleAbilityCmd;
import com.example.app.ability.command.example.result.CreateExampleAbilityResult;
import com.example.domain.aggregate.example.event.model.ExamplePayload;
import com.example.domain.aggregate.example.model.ExampleAggr;
import com.example.domain.share.event.DomainEvent;

/**
 * 命名(增删改) 能力服务
 * 场景：
 * 1、原子化的能力
 * 2、可复用的能力
 * 命名：聚合名+CmdAbility
 *
 * @author jzj
 */
public interface ExampleCmdAbility {
    /**
     * 入参命名：方法名+AbilityCmd
     * 返参命名：方法名+AbilityResult
     *
     * @param appCmd
     * @return
     */
    CreateExampleAbilityResult createExample(CreateExampleAbilityCmd appCmd);

    /**
     * 可复用的能力
     *
     * @param domainEvent
     */
    void publish(DomainEvent<ExamplePayload> domainEvent);

    /**
     * 可复用的能力
     *
     * @param exampleUuid
     * @return
     */
    ExampleAggr findByIdOrElseThrow(String exampleUuid);

}
