package com.java1906.climan.services;

import com.java1906.climan.data.model.History;


import java.util.List;
import java.util.Optional;

public interface IHistoryService {
    Iterable<History> finAllHistory();

    Optional<History> findById(int historyId);

    History save(int invoiceId , History history);

     History update(int historyId , History history);

    void delete(int historyId);

}
