package com.example.app.query.query.example;


import com.components.utils.BeanUtils;
import com.example.app.ability.query.example.query.SearchExampleAbilityQuery;
import lombok.Data;

@Data
public class SearchExampleAppQuery {
    private String exampleKey;
    private String exampleValue;

    private String exampleTest;

    public SearchExampleAbilityQuery toSearchExampleAbilityQuery() {
        return BeanUtils.copy(this, SearchExampleAbilityQuery.class);
    }
}
