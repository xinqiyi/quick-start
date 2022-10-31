package com.example.north.provider.response.example;


import io.swagger.annotations.ApiModel;
import lombok.Data;

@Data
@ApiModel("响应DTO")
public class ExampleRespDTO {
    private String exampleUuid;

    private String exampleKey;
    private String exampleValue;

    private String exampleTest;
}
