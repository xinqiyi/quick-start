package com.example.north.provider.impl;

import com.components.utils.request.DataRequest;
import com.components.utils.request.PageRequest;
import com.components.utils.response.DataResultResponse;
import com.components.utils.response.PageResultDTO;
import com.example.app.commond.ExampleCmdAppService;
import com.example.app.commond.result.example.CreateExampleAppResult;
import com.example.app.commond.result.example.UpdateExampleAppResult;
import com.example.app.query.ExampleQueryAppService;
import com.example.app.query.dto.example.ExampleAppDTO;
import com.example.north.provider.ExampleProvider;
import com.example.north.provider.assembler.example.ExampleCmdAssembler;
import com.example.north.provider.assembler.example.ExampleQueryAssembler;
import com.example.north.provider.request.example.*;
import com.example.north.provider.response.example.CreateExampleRespDTO;
import com.example.north.provider.response.example.ExampleRespDTO;
import com.example.north.provider.response.example.UpdateExampleRespDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;


/**
 * @author jzj
 */
@RestController
public class ExampleProviderImpl implements ExampleProvider {

    @Autowired
    private ExampleCmdAppService exampleCmdAppService;

    @Autowired
    private ExampleQueryAppService exampleQueryAppService;

    @Override
    public DataResultResponse<CreateExampleRespDTO> createExample(@RequestBody @Valid DataRequest<CreateExampleReqDTO> request) {
        CreateExampleAppResult appResult = exampleCmdAppService.createExample(ExampleCmdAssembler.toCreateExampleAppCmd(request.getParam()));

        return DataResultResponse.ok(ExampleCmdAssembler.toCreateExampleRespDTO(appResult));
    }

    @Override
    public DataResultResponse<UpdateExampleRespDTO> updateExample(@RequestBody @Valid DataRequest<UpdateExampleReqDTO> request) {
        UpdateExampleAppResult appResult = exampleCmdAppService.updateExample(ExampleCmdAssembler.toUpdateExampleAppCmd(request.getParam()));

        return DataResultResponse.ok(ExampleCmdAssembler.toUpdateExampleRespDTO(appResult));
    }

    @Override
    public DataResultResponse<Void> deleteExample(@RequestBody @Valid DataRequest<DeleteExampleReqDTO> request) {
        exampleCmdAppService.deleteExample(ExampleCmdAssembler.toDeleteExampleAppCmd(request.getParam()));

        return DataResultResponse.ok(null);
    }

    @Override
    public DataResultResponse<PageResultDTO<ExampleRespDTO>> searchExample(@RequestBody @Valid PageRequest<SearchExampleReqDTO> pageRequest) {
        PageResultDTO<ExampleAppDTO> pageResultDTO = exampleQueryAppService.searchExample(ExampleQueryAssembler.toSearchExampleQuery(pageRequest.getParam()), pageRequest.getPage());

        return DataResultResponse.ok(ExampleQueryAssembler.toExampleRespDTO(pageResultDTO));
    }

    @Override
    public DataResultResponse<ExampleRespDTO> getExampleByUuid(@RequestBody @Valid DataRequest<GetExampleByUuidReqDTO> request) {

        ExampleAppDTO appDTO = exampleQueryAppService.getExampleByUuid(ExampleQueryAssembler.toGetExampleByUuidAppQuery(request.getParam()));

        return DataResultResponse.ok(ExampleQueryAssembler.toExampleRespDTO(appDTO));
    }

    @Override
    public DataResultResponse<List<ExampleRespDTO>> listExampleByUuids(@RequestBody @Valid DataRequest<List<GetExampleByUuidReqDTO>> request) {
        List<ExampleAppDTO> appDTOS = exampleQueryAppService.listExampleByUuids(ExampleQueryAssembler.toGetExampleByUuidAppQuery(request.getParam()));

        return DataResultResponse.ok(ExampleQueryAssembler.toExampleRespDTO(appDTOS));
    }
}
