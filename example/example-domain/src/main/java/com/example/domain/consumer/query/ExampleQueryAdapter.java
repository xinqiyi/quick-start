package com.example.domain.consumer.query;


import com.example.domain.consumer.query.dto.ExampleAdapterDTO;
import com.example.domain.consumer.query.query.GetExampleByUuidAdapterQuery;

/**
 * 查询 外部接口 适配
 * 命名： 外部接口名+QueryAdapter
 */
public interface ExampleQueryAdapter {
    /**
     * 入参：方法名+AdapterQuery
     * 返参：方法名+AdapterDTO
     * @param adapterQuery
     * @return
     */
    ExampleAdapterDTO getExampleByUuid(GetExampleByUuidAdapterQuery adapterQuery);
}