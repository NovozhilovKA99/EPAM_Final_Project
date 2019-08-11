package com.citytransportsystem.dao;

import com.citytransportsystem.dto.Model;

public interface ModelRepository {
    void create(Model model);

    Model get(Long idModel);

    void update(Model model);

    void delete(Long idModel);
}
