package com.example.app.ability.command.example.result;

import com.example.app.commond.result.example.UpdateExampleAppResult;
import lombok.Data;


@Data
public class UpdateExampleAbilityResult {
    private String exampleUuid;

    public static UpdateExampleAbilityResult from(String exampleUuid) {
        UpdateExampleAbilityResult abilityResult = new UpdateExampleAbilityResult();

        abilityResult.setExampleUuid(exampleUuid);

        return abilityResult;
    }

    public UpdateExampleAppResult toAppResult() {
        UpdateExampleAppResult appResult = new UpdateExampleAppResult();

        appResult.setExampleUuid(appResult.getExampleUuid());

        return appResult;
    }
}
