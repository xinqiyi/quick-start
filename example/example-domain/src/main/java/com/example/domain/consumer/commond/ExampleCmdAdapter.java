package com.example.domain.consumer.commond;


import com.example.domain.consumer.commond.cmd.UpdateExampleAdapterCmd;
import com.example.domain.consumer.commond.result.UpdateExampleAdapterResult;

/**
 * 命名(增删改) 外部接口 适配
 * 命名：外部接口CmdAdapter
 */
public interface ExampleCmdAdapter {
    /**
     * 入参命名：方法名+AdapterCmd
     * 返参命名：方法名+AdapterResult
     *
     * @param adapterCmd
     * @return
     */
    UpdateExampleAdapterResult updateExample(UpdateExampleAdapterCmd adapterCmd);
}