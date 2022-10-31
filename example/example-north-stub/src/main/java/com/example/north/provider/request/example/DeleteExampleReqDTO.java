package com.example.north.provider.request.example;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


@Data
@ApiModel("删除Example请求DTO")
public class DeleteExampleReqDTO {
    @ApiModelProperty("exampleUuid")
    private String exampleUuid;
}
