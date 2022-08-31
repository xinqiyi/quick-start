package com.example.app.ability.query.example.dto;


import com.components.utils.BeanUtils;
import com.example.app.ability.query.example.repository.model.ExampleAbilityPO;
import com.google.common.collect.Lists;
import lombok.Data;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Data
public class ExampleAbilityDTO {
    private String exampleUuid;

    private String exampleKey;
    private String exampleValue;

    private String exampleTest;

    public static List<ExampleAbilityDTO> from(List<ExampleAbilityPO> abilityPOS) {
        return Optional.ofNullable(abilityPOS).orElseGet(Lists::newArrayList).stream()
                .map(ExampleAbilityDTO::from)
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }

    public static ExampleAbilityDTO from(ExampleAbilityPO abilityPO) {
        return BeanUtils.copy(abilityPO, ExampleAbilityDTO.class);
    }
}
