package com.example.app.commond.cmd.example;

import com.components.utils.UuidUtil;
import com.example.domain.aggregate.example.model.ExampleAggr;
import lombok.Data;


@Data
public class CreateExampleAppCmd {
    private String exampleTest;

    private String exampleKey;
    private String exampleValue;

    public ExampleAggr toExampleAggr() {
        ExampleAggr exampleAggr = ExampleAggr.builder()
                .exampleUuid(UuidUtil.geneUuidString())
                .exampleTest(exampleTest)
                .build();

        exampleAggr.bindExampleValue(exampleKey, exampleValue);
        exampleAggr.create();

        return exampleAggr;
    }
}
