package com.example.app.commond.impl;

import com.example.app.ability.command.example.ExampleCmdAbility;
import com.example.app.commond.ExampleCmdAppService;
import com.example.app.commond.cmd.example.CreateExampleAppCmd;
import com.example.app.commond.cmd.example.DeleteExampleAppCmd;
import com.example.app.commond.cmd.example.UpdateExampleAppCmd;
import com.example.app.commond.result.example.CreateExampleAppResult;
import com.example.app.commond.result.example.UpdateExampleAppResult;
import com.example.domain.aggregate.example.event.ExampleCreatedEvent;
import com.example.domain.aggregate.example.event.ExampleDeletedEvent;
import com.example.domain.aggregate.example.event.ExampleUpdatedEvent;
import com.example.domain.aggregate.example.model.ExampleAggr;
import com.example.domain.aggregate.example.repository.ExampleCmdRepository;
import com.example.domain.consumer.commond.ExampleCmdAdapter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
public class ExampleCmdAppServiceImpl implements ExampleCmdAppService {

    @Autowired
    private ExampleCmdRepository exampleCmdRepository;

    @Autowired
    private ExampleCmdAbility exampleCmdAbility;

    @Autowired
    private ExampleCmdAdapter exampleCmdAdapter;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public CreateExampleAppResult createExample(CreateExampleAppCmd appCmd) {
        ExampleAggr exampleAggr = appCmd.toExampleAggr();

        exampleAggr.exampleMethod1();
        exampleAggr.exampleMethod2();
        exampleAggr.exampleMethod3();

        exampleCmdRepository.save(exampleAggr);

        exampleCmdAbility.publish(new ExampleCreatedEvent(exampleAggr, "testTag"));

        return CreateExampleAppResult.from(exampleAggr.getExampleUuid());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public UpdateExampleAppResult updateExample(UpdateExampleAppCmd appCmd) {

        ExampleAggr newExampleAggr = appCmd.toExampleAggr();

        ExampleAggr oldExampleAggr = exampleCmdAbility.findByIdOrElseThrow(newExampleAggr.getExampleUuid());

        newExampleAggr.exampleMethod1();
        newExampleAggr.exampleMethod2();
        newExampleAggr.exampleMethod3();

        // 模拟调用外部接口
        exampleCmdAdapter.updateExample(appCmd.toUpdateExampleAdapterCmd());

        exampleCmdRepository.update(newExampleAggr);

        exampleCmdAbility.publish(new ExampleUpdatedEvent(oldExampleAggr, newExampleAggr));

        return UpdateExampleAppResult.from(newExampleAggr.getExampleUuid());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteExample(DeleteExampleAppCmd appCmd) {

        ExampleAggr newExampleAggr = appCmd.toExampleAggr();

        ExampleAggr oldExampleAggr = exampleCmdAbility.findByIdOrElseThrow(newExampleAggr.getExampleUuid());

        exampleCmdRepository.update(newExampleAggr);

        exampleCmdAbility.publish(new ExampleDeletedEvent(oldExampleAggr, newExampleAggr));
    }
}
