package com.example.north.provider.request.example;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


@Data
@ApiModel("更新Example请求DTO")
public class UpdateExampleReqDTO {
    @ApiModelProperty("exampleUuid")
    private String exampleUuid;

    @ApiModelProperty("exampleTest")
    private String exampleTest;

    @ApiModelProperty("exampleKey")
    private String exampleKey;
    @ApiModelProperty("exampleValue")
    private String exampleValue;

}
