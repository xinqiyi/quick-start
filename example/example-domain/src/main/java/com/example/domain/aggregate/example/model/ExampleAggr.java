package com.example.domain.aggregate.example.model;

import com.components.ddd.model.BaseModel;
import com.components.ddd.stereotype.AggregateRoot;
import com.components.utils.StringUtil;
import com.components.utils.ValidationUtil;
import com.example.domain.aggregate.example.model.valueobject.ExampleValue;
import lombok.Builder;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@Getter
@Builder
public class ExampleAggr extends BaseModel implements AggregateRoot<String> {
    /**
     * 唯一id需要修改 如：exampleUuid
     */
    private String exampleUuid;

    private String exampleTest;

    private ExampleValue exampleValue;

    @Override
    public String getUniqueId() {
        return exampleUuid;
    }

    public void bindExampleUuid(String exampleUuid) {
        ValidationUtil.checkArgument(StringUtil.isNotBlank(exampleUuid), "exampleUuid不能为空");
        this.exampleUuid = exampleUuid;
    }

    public void bindExampleValue(String exampleKey, String exampleValue) {
        this.exampleValue = ExampleValue.valueOf(exampleKey, exampleValue);
    }

    public void exampleMethod1() {
        log.info("exampleMethod1");
    }
    public void exampleMethod2() {
        log.info("exampleMethod2");
    }
    public void exampleMethod3() {
        log.info("exampleMethod3");
    }
}
