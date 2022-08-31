package com.example.domain.aggregate.example.repository;

import com.components.ddd.stereotype.BaseCmdRepository;
import com.example.domain.aggregate.example.model.ExampleAggr;


public interface ExampleCmdRepository extends BaseCmdRepository<ExampleAggr, String> {
}