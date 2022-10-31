package com.example.app.query.impl;


import com.components.utils.PageDTO;
import com.components.utils.StringUtil;
import com.components.utils.response.PageResultDTO;
import com.example.app.ability.query.example.ExampleQueryAbility;
import com.example.app.ability.query.example.dto.ExampleAbilityDTO;
import com.example.app.ability.query.example.query.SearchExampleAbilityQuery;
import com.example.app.ability.query.example.repository.ExampleQueryRepository;
import com.example.app.ability.query.example.repository.model.ExampleAbilityPO;
import com.example.app.query.ExampleQueryAppService;
import com.example.app.query.dto.example.ExampleAppDTO;
import com.example.app.query.query.example.GetExampleByUuidAppQuery;
import com.example.app.query.query.example.SearchExampleAppQuery;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ExampleQueryAppServiceImpl implements ExampleQueryAppService {

    @Autowired
    private ExampleQueryAbility exampleQueryAbility;

    @Autowired
    private ExampleQueryRepository exampleQueryRepository;

    @Override
    public ExampleAppDTO getExampleByUuid(GetExampleByUuidAppQuery appQuery) {
        ExampleAbilityPO abilityPO = exampleQueryRepository.getExampleByUuid(appQuery.getExampleUuid());

        return ExampleAppDTO.fromPO(abilityPO);
    }

    @Override
    public List<ExampleAppDTO> listExampleByUuids(List<GetExampleByUuidAppQuery> appQuerys) {
        List<String> exampleUuids = Optional.ofNullable(appQuerys).orElseGet(Lists::newArrayList).stream()
                .map(GetExampleByUuidAppQuery::getExampleUuid)
                .filter(StringUtil::isNotBlank)
                .distinct().collect(Collectors.toList());

        List<ExampleAbilityPO> abilityPOS = exampleQueryRepository.listExampleByUuids(exampleUuids);

        return ExampleAppDTO.fromPO(abilityPOS);
    }

    @Override
    public PageResultDTO<ExampleAppDTO> searchExample(SearchExampleAppQuery appQuery, PageDTO pageDTO) {
        PageResultDTO<ExampleAppDTO> pageResultDTO = PageResultDTO.emptyResult();

        SearchExampleAbilityQuery abilityQuery = appQuery.toSearchExampleAbilityQuery();

        Long count = exampleQueryAbility.countExample(abilityQuery);

        if (count > 0) {
            pageResultDTO.setCount(count);

            List<ExampleAbilityDTO> examplePOS = exampleQueryAbility.searchExample(abilityQuery, pageDTO);
            pageResultDTO.setItems(ExampleAppDTO.fromAbility(examplePOS));
        }

        return pageResultDTO;
    }
}
