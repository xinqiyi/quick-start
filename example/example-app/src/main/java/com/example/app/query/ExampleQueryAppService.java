package com.example.app.query;



import com.components.utils.PageDTO;
import com.components.utils.response.PageResultDTO;
import com.example.app.query.dto.example.ExampleAppDTO;
import com.example.app.query.query.example.GetExampleByUuidAppQuery;
import com.example.app.query.query.example.SearchExampleAppQuery;

import java.util.List;

/**
 * 查询 应用服务
 * 命名：
 * 1、聚合名+QueryAppService
 * 2、聚合名+动词+QueryAppService 如：SearchExampleQueryAppService(如果searchExample很复杂可以独立出一个类)
 *
 * @author jzj
 */
public interface ExampleQueryAppService {

    /**
     * 入参命名：方法名+AppQuery
     * 返回参命名：方法名+AppDTO
     *
     * @param appQuery
     * @return
     */
    ExampleAppDTO getExampleByUuid(GetExampleByUuidAppQuery appQuery);

    List<ExampleAppDTO> listExampleByUuids(List<GetExampleByUuidAppQuery> appQuerys);

    PageResultDTO<ExampleAppDTO> searchExample(SearchExampleAppQuery appQuery, PageDTO pageDTO);
}
