package com.example.domain.aggregate.example.event.model;

import com.components.ddd.model.BaseModel;
import com.components.utils.BeanUtils;
import com.example.domain.aggregate.example.model.ExampleAggr;
import com.example.domain.aggregate.example.model.valueobject.ExampleValue;
import lombok.Data;

import java.util.Objects;

/**
 * @Author: jzj
 * @Date: 2022/3/29
 * @Desc:
 */
@Data
public class ExamplePayload extends BaseModel {
    private String exampleUuid;

    private String exampleTest;

    private String exampleKey;
    private String exampleValue;


    public static ExamplePayload fromAggr(ExampleAggr aggr) {

        ExamplePayload event = BeanUtils.copy(aggr, ExamplePayload.class);

        ExampleValue exampleValue = aggr.getExampleValue();
        if (Objects.nonNull(exampleValue)) {
            event.setExampleKey(exampleValue.getExampleKey());
            event.setExampleValue(exampleValue.getExampleValue());
        }

        return event;
    }
}
