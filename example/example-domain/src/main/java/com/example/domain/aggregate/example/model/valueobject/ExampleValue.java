package com.example.domain.aggregate.example.model.valueobject;

import com.components.ddd.stereotype.ValueObject;
import com.components.utils.StringUtil;
import com.components.utils.ValidationUtil;
import jdk.nashorn.internal.ir.annotations.Immutable;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@Immutable
@EqualsAndHashCode
@ToString
public final class ExampleValue implements ValueObject<ExampleValue> {
    private final String exampleKey;
    private final String exampleValue;

    private ExampleValue(String exampleKey, String exampleValue) {
        this.exampleKey = exampleKey;
        this.exampleValue = exampleValue;
    }

    public static ExampleValue fromPO(String exampleKey, String exampleValue) {
        return new ExampleValue(exampleKey, exampleValue);
    }

    public static ExampleValue valueOf(String exampleKey, String exampleValue) {
        ValidationUtil.checkArgument(StringUtil.isNotBlank(exampleKey), "exampleKey不能为空");
        ValidationUtil.checkArgument(StringUtil.isNotBlank(exampleValue), "exampleValue不能为空");

        return new ExampleValue(exampleKey, exampleValue);
    }
}
