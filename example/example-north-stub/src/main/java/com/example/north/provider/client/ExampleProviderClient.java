package com.example.north.provider.client;


import com.components.utils.PageDTO;
import com.components.utils.response.PageResultDTO;
import com.example.north.provider.request.example.*;
import com.example.north.provider.response.example.CreateExampleRespDTO;
import com.example.north.provider.response.example.ExampleRespDTO;
import com.example.north.provider.response.example.UpdateExampleRespDTO;

import java.util.List;

public interface ExampleProviderClient {
    CreateExampleRespDTO createExample(CreateExampleReqDTO reqDTO);

    UpdateExampleRespDTO updateExample(UpdateExampleReqDTO reqDTO);

    void deleteExample(DeleteExampleReqDTO reqDTO);

    PageResultDTO<ExampleRespDTO> searchExample(PageDTO page, SearchExampleReqDTO reqDTO);

    ExampleRespDTO getExampleByUuid(GetExampleByUuidReqDTO reqDTO);

    List<ExampleRespDTO> listExampleByUuids(List<GetExampleByUuidReqDTO> reqDTOS);
}
