package com.java1906.climan.services;

import com.java1906.climan.data.model.History;


import java.util.List;
import java.util.Optional;

public interface IHistoryService {
    Iterable<History> finAllHistory();

    Optional<History> findById(int historyId);

    History save(History history);

    public History update(History history);

    void delete(int id);

}
