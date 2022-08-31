package com.example.app.commond.cmd.example;

import com.example.domain.aggregate.example.model.ExampleAggr;
import lombok.Data;


@Data
public class DeleteExampleAppCmd {
    private String exampleUuid;


    public ExampleAggr toExampleAggr() {
        ExampleAggr exampleAggr = ExampleAggr.builder()
                .build();

        exampleAggr.bindExampleUuid(exampleUuid);
        exampleAggr.logicDelete();

        return exampleAggr;

    }
}
