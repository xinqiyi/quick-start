package com.example.north.provider.request.example;

import io.swagger.annotations.ApiModel;
import lombok.Data;


@Data
@ApiModel("请求DTO")
public class GetExampleByUuidReqDTO {
    private String exampleUuid;
}
