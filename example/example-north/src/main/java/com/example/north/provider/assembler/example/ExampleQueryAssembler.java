package com.example.north.provider.assembler.example;

import com.components.utils.BeanUtils;
import com.components.utils.response.PageResultDTO;
import com.example.app.query.dto.example.ExampleAppDTO;
import com.example.app.query.query.example.GetExampleByUuidAppQuery;
import com.example.app.query.query.example.SearchExampleAppQuery;
import com.example.north.provider.request.example.GetExampleByUuidReqDTO;
import com.example.north.provider.request.example.SearchExampleReqDTO;
import com.example.north.provider.response.example.ExampleRespDTO;
import com.google.common.collect.Lists;
import lombok.experimental.UtilityClass;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;


/**
 * 查询 接口参数组装类
 *
 * @author jzj
 */
@UtilityClass
public class ExampleQueryAssembler {
    /**
     * 方法命名：to+请求参数类名
     *
     * @param reqDTO
     * @return
     */
    public static SearchExampleAppQuery toSearchExampleQuery(SearchExampleReqDTO reqDTO) {
        return BeanUtils.copy(reqDTO, SearchExampleAppQuery.class);
    }

    /**
     * 方法命名：to+响应参数类名
     *
     * @param pageResultDTO
     * @return
     */
    public static PageResultDTO<ExampleRespDTO> toExampleRespDTO(PageResultDTO<ExampleAppDTO> pageResultDTO) {
        PageResultDTO<ExampleRespDTO> pageRespDTO = new PageResultDTO<>();

        pageRespDTO.setCount(pageResultDTO.getCount());
        pageRespDTO.setItems(toExampleRespDTO(pageResultDTO.getItems()));

        return pageRespDTO;
    }

    public static List<ExampleRespDTO> toExampleRespDTO(List<ExampleAppDTO> appDTOs) {
        return Optional.ofNullable(appDTOs).orElseGet(Lists::newArrayList).stream()
                .map(ExampleQueryAssembler::toExampleRespDTO)
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }

    public static ExampleRespDTO toExampleRespDTO(ExampleAppDTO appDTO) {
        if (Objects.isNull(appDTO)) {
            return null;
        }
        return BeanUtils.copy(appDTO, ExampleRespDTO.class);
    }


    public static GetExampleByUuidAppQuery toGetExampleByUuidAppQuery(GetExampleByUuidReqDTO reqDTO) {
        return BeanUtils.copy(reqDTO, GetExampleByUuidAppQuery.class);
    }

    public static List<GetExampleByUuidAppQuery> toGetExampleByUuidAppQuery(List<GetExampleByUuidReqDTO> reqDTOS) {
        return Optional.ofNullable(reqDTOS).orElseGet(Lists::newArrayList).stream()
                .map(ExampleQueryAssembler::toGetExampleByUuidAppQuery)
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }
}
