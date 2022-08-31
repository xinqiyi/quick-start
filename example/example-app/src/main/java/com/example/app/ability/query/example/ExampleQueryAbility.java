package com.example.app.ability.query.example;



import com.components.utils.PageDTO;
import com.example.app.ability.query.example.dto.ExampleAbilityDTO;
import com.example.app.ability.query.example.query.SearchExampleAbilityQuery;

import java.util.List;


/**
 * 查询 能力服务
 * 场景：
 * 1、原子化的能力
 * 2、可复用的能力
 * 命名：聚合名+CmdAbility
 *
 * @author jzj
 */
public interface ExampleQueryAbility {
    Long countExample(SearchExampleAbilityQuery abilityQuery);

    /**
     * 入参命名：方法名+AbilityQuery
     * 返参命名：方法名+AbilityDTO
     *
     * @param abilityQuery
     * @param pageDTO
     * @return
     */
    List<ExampleAbilityDTO> searchExample(SearchExampleAbilityQuery abilityQuery, PageDTO pageDTO);
}
