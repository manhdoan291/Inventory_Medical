package com.java1906.climan.services.impl;

import com.java1906.climan.data.model.History;
import com.java1906.climan.data.repo.HistoryRepository;
import com.java1906.climan.services.IHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class HistoryServiceImpl implements IHistoryService {
    @Autowired
    private HistoryRepository historyRepository;

    @Override
    public Optional<History> get(Integer id) {
        return historyRepository.findById(id);
    }

    @Override
    public List<History> getAll() {
        return (List<History>) historyRepository.findAll();
    }
}
