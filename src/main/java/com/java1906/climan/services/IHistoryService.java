package com.java1906.climan.services;

import com.java1906.climan.data.model.History;

import java.util.List;
import java.util.Optional;

public interface IHistoryService {
    public Optional<History> get(Integer id);

    public List<History> getAll();
}
