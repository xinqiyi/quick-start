package com.example.app.commond.result.example;

import lombok.Data;


@Data
public class UpdateExampleAppResult {
    private String exampleUuid;

    public static UpdateExampleAppResult from(String exampleUuid) {
        UpdateExampleAppResult appResult = new UpdateExampleAppResult();

        appResult.setExampleUuid(exampleUuid);

        return appResult;
    }
}
