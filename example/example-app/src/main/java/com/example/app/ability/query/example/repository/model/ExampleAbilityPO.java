package com.example.app.ability.query.example.repository.model;

import com.components.ddd.model.BasePO;
import lombok.Data;

/**
 * @Author: jzj
 * @Date: 2022/3/24
 * @Desc:
 */
@Data
public class ExampleAbilityPO extends BasePO {

    private String exampleUuid;

    private String exampleKey;
    private String exampleValue;

    private String exampleTest;
}
