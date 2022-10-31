package com.example.north.provider.client.impl;

import com.components.utils.PageDTO;
import com.components.utils.exception.BusinessException;
import com.components.utils.request.DataRequest;
import com.components.utils.request.PageRequest;
import com.components.utils.response.CommonResponseCode;
import com.components.utils.response.DataResultResponse;
import com.components.utils.response.PageResultDTO;
import com.example.north.provider.ExampleProvider;
import com.example.north.provider.client.ExampleProviderClient;
import com.example.north.provider.request.example.*;
import com.example.north.provider.response.example.CreateExampleRespDTO;
import com.example.north.provider.response.example.ExampleRespDTO;
import com.example.north.provider.response.example.UpdateExampleRespDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ExampleProviderClientImpl implements ExampleProviderClient {

    @Autowired
    private ExampleProvider exampleProvider;

    @Override
    public CreateExampleRespDTO createExample(CreateExampleReqDTO reqDTO) {

        DataResultResponse<CreateExampleRespDTO> response = exampleProvider.createExample(new DataRequest<>(reqDTO));

        if (!CommonResponseCode.RC_SUCCESS.getResponseCode().equals(response.getResponseCode())) {
            throw new BusinessException(response.getResponseCode(), response.getResponseMessage());
        }
        return response.getData();
    }

    @Override
    public UpdateExampleRespDTO updateExample(UpdateExampleReqDTO reqDTO) {

        DataResultResponse<UpdateExampleRespDTO> response = exampleProvider.updateExample(new DataRequest<>(reqDTO));

        if (!CommonResponseCode.RC_SUCCESS.getResponseCode().equals(response.getResponseCode())) {
            throw new BusinessException(response.getResponseCode(), response.getResponseMessage());
        }
        return response.getData();
    }

    @Override
    public void deleteExample(DeleteExampleReqDTO reqDTO) {
        DataResultResponse<Void> response = exampleProvider.deleteExample(new DataRequest<>(reqDTO));

        if (!CommonResponseCode.RC_SUCCESS.getResponseCode().equals(response.getResponseCode())) {
            throw new BusinessException(response.getResponseCode(), response.getResponseMessage());
        }
    }

    @Override
    public PageResultDTO<ExampleRespDTO> searchExample(PageDTO page, SearchExampleReqDTO reqDTO) {
        DataResultResponse<PageResultDTO<ExampleRespDTO>> response = exampleProvider.searchExample(new PageRequest<>(reqDTO, page));

        if (!CommonResponseCode.RC_SUCCESS.getResponseCode().equals(response.getResponseCode())) {
            throw new BusinessException(response.getResponseCode(), response.getResponseMessage());
        }
        return response.getData();
    }

    @Override
    public ExampleRespDTO getExampleByUuid(GetExampleByUuidReqDTO reqDTO) {
        DataResultResponse<ExampleRespDTO> response = exampleProvider.getExampleByUuid(new DataRequest<>(reqDTO));

        if (!CommonResponseCode.RC_SUCCESS.getResponseCode().equals(response.getResponseCode())) {
            throw new BusinessException(response.getResponseCode(), response.getResponseMessage());
        }
        return response.getData();
    }

    @Override
    public List<ExampleRespDTO> listExampleByUuids(List<GetExampleByUuidReqDTO> reqDTOS) {
        DataResultResponse<List<ExampleRespDTO>> response = exampleProvider.listExampleByUuids(new DataRequest<>(reqDTOS));

        if (!CommonResponseCode.RC_SUCCESS.getResponseCode().equals(response.getResponseCode())) {
            throw new BusinessException(response.getResponseCode(), response.getResponseMessage());
        }
        return response.getData();
    }
}
