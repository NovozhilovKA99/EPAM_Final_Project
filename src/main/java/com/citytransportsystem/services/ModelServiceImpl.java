package com.citytransportsystem.services;

import com.citytransportsystem.dto.Model;
import com.citytransportsystem.repository.jdbc.ModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ModelServiceImpl implements ModelService {

    @Autowired
    private ModelRepository modelRepository;

    @Override
    public Model getById(Long modelId) {
        return modelRepository.get(modelId);
    }
}
