package com.example.app.ability.query.example.query;


import com.example.app.ability.query.example.repository.model.ExampleAbilityPO;
import lombok.Data;

@Data
public class SearchExampleAbilityQuery {
    private String exampleKey;
    private String exampleValue;

    private String exampleTest;

    public ExampleAbilityPO toExamplePO() {
        ExampleAbilityPO abilityPO = new ExampleAbilityPO();

        abilityPO.setExampleKey(exampleKey);
        abilityPO.setExampleValue(exampleValue);
        abilityPO.setExampleTest(exampleTest);

        return abilityPO;
    }
}
