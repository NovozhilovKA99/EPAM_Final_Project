package com.citytransportsystem.repository.jdbc;

import com.citytransportsystem.dto.Model;

public interface ModelRepository {
    int create(Model model);

    Model get(Long idModel);

    int update(Model model);

    int delete(Long idModel);
}