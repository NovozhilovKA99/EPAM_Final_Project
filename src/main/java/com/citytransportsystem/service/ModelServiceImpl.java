package com.citytransportsystem.service;

import com.citytransportsystem.dto.Model;
import com.citytransportsystem.repository.jdbc.ModelRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ModelServiceImpl implements ModelService {

    @Autowired
    private ModelRepository modelRepository;

    @Override
    public Model getById(Long modelId) {
        return modelRepository.get(modelId);
    }
}
