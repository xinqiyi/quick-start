package com.example.north.provider.response.example;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


@Data
@ApiModel("创建Example响应DTO")
public class CreateExampleRespDTO {
    @ApiModelProperty("exampleUuid")
    private String exampleUuid;
}
