package com.example.north.provider;

import com.components.utils.request.DataRequest;
import com.components.utils.request.PageRequest;
import com.components.utils.response.DataResultResponse;
import com.components.utils.response.PageResultDTO;
import com.example.north.provider.request.example.*;
import com.example.north.provider.response.example.CreateExampleRespDTO;
import com.example.north.provider.response.example.ExampleRespDTO;
import com.example.north.provider.response.example.UpdateExampleRespDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * 注意：<P>
 * 1、PropertyExampleKernelFacade 接口命名： <p>
 * —— Property+聚合+KernelFacade <p>
 * —— Property+场景+KernelFacade <p>
 * 2、RequestMapping注解：/fangkernel/property/example <P>
 * 3、Api注解：fangkernel_property_example <P>
 *
 * @author jzj
 */
@RequestMapping("/fangkernel/property/example")
@Api(tags = "fangkernel_property_ample", description = "Example接口示例")
public interface ExampleProvider {
    /**
     * 方法请求参数命名：方法名+ReqDTO <p>
     * 方法响应参数明敏：方法名+RespDTO <p>
     *
     * @param request：DataRequest<CreateExampleReqDTO> request
     * @return DataResultResponse<CreateExampleRespDTO> response
     */
    @RequestMapping(value = "/createExample", method = RequestMethod.POST)
    @ApiOperation(value = "创建Example示例")
    DataResultResponse<CreateExampleRespDTO> createExample(DataRequest<CreateExampleReqDTO> request);

    @RequestMapping(value = "/updateExample", method = RequestMethod.POST)
    @ApiOperation(value = "更新Example示例")
    DataResultResponse<UpdateExampleRespDTO> updateExample(DataRequest<UpdateExampleReqDTO> request);

    @RequestMapping(value = "/deleteExample", method = RequestMethod.POST)
    @ApiOperation(value = "删除Example示例")
    DataResultResponse<Void> deleteExample(DataRequest<DeleteExampleReqDTO> request);

    @RequestMapping(value = "/searchExample", method = RequestMethod.POST)
    @ApiOperation(value = "分页查询example")
    DataResultResponse<PageResultDTO<ExampleRespDTO>> searchExample(PageRequest<SearchExampleReqDTO> pageRequest);

    @RequestMapping(value = "/getExampleByUuid", method = RequestMethod.POST)
    @ApiOperation(value = "通过UUID查询example")
    DataResultResponse<ExampleRespDTO> getExampleByUuid(DataRequest<GetExampleByUuidReqDTO> pageRequest);

    @RequestMapping(value = "/listExampleByUuids", method = RequestMethod.POST)
    @ApiOperation(value = "通过UUID批量查询example")
    DataResultResponse<List<ExampleRespDTO>> listExampleByUuids(DataRequest<List<GetExampleByUuidReqDTO>> pageRequest);

}