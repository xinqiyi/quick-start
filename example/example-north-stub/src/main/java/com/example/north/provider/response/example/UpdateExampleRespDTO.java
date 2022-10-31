package com.example.north.provider.response.example;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


@Data
@ApiModel("更新Example响应DTO")
public class UpdateExampleRespDTO {
    @ApiModelProperty("exampleUuid")
    private String exampleUuid;
}
