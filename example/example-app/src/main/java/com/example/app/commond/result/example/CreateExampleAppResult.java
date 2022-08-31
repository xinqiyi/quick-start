package com.example.app.commond.result.example;

import lombok.Data;


@Data
public class CreateExampleAppResult {
    private String exampleUuid;

    public static CreateExampleAppResult from(String exampleUuid) {
        CreateExampleAppResult appResult = new CreateExampleAppResult();
        appResult.setExampleUuid(exampleUuid);
        return appResult;
    }
}
