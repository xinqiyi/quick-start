package com.example.app.query.dto.example;


import com.components.utils.BeanUtils;
import com.example.app.ability.query.example.dto.ExampleAbilityDTO;
import com.example.app.ability.query.example.repository.model.ExampleAbilityPO;
import com.google.common.collect.Lists;
import lombok.Data;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Data
public class ExampleAppDTO {
    private String exampleUuid;

    private String exampleKey;
    private String exampleValue;

    private String exampleTest;



    public static List<ExampleAppDTO> fromAbility(List<ExampleAbilityDTO> abilityDTOS) {
        return Optional.ofNullable(abilityDTOS).orElseGet(Lists::newArrayList).stream()
                .map(ExampleAppDTO::fromAbility)
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }

    public static ExampleAppDTO fromAbility(ExampleAbilityDTO examplePO) {
        return BeanUtils.copy(examplePO, ExampleAppDTO.class);
    }


    public static List<ExampleAppDTO> fromPO(List<ExampleAbilityPO> abilityPOS) {
        return Optional.ofNullable(abilityPOS).orElseGet(Lists::newArrayList).stream()
                .map(ExampleAppDTO::fromPO)
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }

    public static ExampleAppDTO fromPO(ExampleAbilityPO abilityPO) {
        return BeanUtils.copy(abilityPO, ExampleAppDTO.class);
    }
}
