package com.example.north.provider.request.example;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


@Data
@ApiModel("创建Example请求DTO")
public class CreateExampleReqDTO {

    @ApiModelProperty("exampleTest")
    private String exampleTest;

    @ApiModelProperty("exampleKey")
    private String exampleKey;
    @ApiModelProperty("exampleValue")
    private String exampleValue;
}
