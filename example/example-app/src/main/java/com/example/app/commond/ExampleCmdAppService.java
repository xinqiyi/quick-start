package com.example.app.commond;

import com.example.app.commond.cmd.example.CreateExampleAppCmd;
import com.example.app.commond.cmd.example.DeleteExampleAppCmd;
import com.example.app.commond.cmd.example.UpdateExampleAppCmd;
import com.example.app.commond.result.example.CreateExampleAppResult;
import com.example.app.commond.result.example.UpdateExampleAppResult;

/**
 * 命令(增删改) 应用服务
 * 命名：
 * 1、聚合名+CmdAppService
 * 2、聚合名+动词+CmdAppService 如：ExampleCreateCmdAppService(如果createExample很复杂可以独立出一个类)
 *
 * @author jzj
 */
public interface ExampleCmdAppService {

    /**
     * 入参命名：方法名+AppCmd
     * 返回参命名：方法名+AppResult
     *
     * @param appCmd
     * @return
     */
    CreateExampleAppResult createExample(CreateExampleAppCmd appCmd);

    UpdateExampleAppResult updateExample(UpdateExampleAppCmd appCmd);

    void deleteExample(DeleteExampleAppCmd appCmd);
}
