package com.example.app.ability.command.example.cmd;

import lombok.Data;


@Data
public class UpdateExampleAbilityCmd {
    private String exampleUuid;

    private String exampleTest;

    private String exampleValue;
}
