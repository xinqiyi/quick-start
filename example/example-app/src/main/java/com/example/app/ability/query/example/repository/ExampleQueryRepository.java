package com.example.app.ability.query.example.repository;


import com.components.utils.RowBounds;
import com.example.app.ability.query.example.repository.model.ExampleAbilityPO;

import java.util.List;

public interface ExampleQueryRepository{
    Long countExample(ExampleAbilityPO abilityPO);

    List<ExampleAbilityPO> searchExample(ExampleAbilityPO abilityPO, RowBounds rb);

    ExampleAbilityPO getExampleByUuid(String exampleUuid);

    List<ExampleAbilityPO> listExampleByUuids(List<String> exampleUuids);
}