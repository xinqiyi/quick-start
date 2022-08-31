package com.example.app.commond.cmd.example;

import com.example.domain.aggregate.example.model.ExampleAggr;
import com.example.domain.customer.commond.cmd.UpdateExampleAdapterCmd;
import lombok.Data;


@Data
public class UpdateExampleAppCmd {
    private String exampleUuid;

    private String exampleTest;

    private String exampleKey;
    private String exampleValue;

    public ExampleAggr toExampleAggr() {
        ExampleAggr exampleAggr = ExampleAggr.builder()
                .exampleTest(exampleTest)
                .build();

        exampleAggr.bindExampleUuid(exampleUuid);
        exampleAggr.bindExampleValue(exampleKey, exampleValue);
        exampleAggr.update();

        return exampleAggr;
    }

    public UpdateExampleAdapterCmd toUpdateExampleAdapterCmd() {

        return null;
    }
}
