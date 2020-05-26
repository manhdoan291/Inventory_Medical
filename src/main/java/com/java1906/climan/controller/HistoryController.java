package com.java1906.climan.controller;

import com.java1906.climan.data.model.History;
import com.java1906.climan.interceptor.HasRole;
import com.java1906.climan.services.IHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class HistoryController {
    @Autowired
    private IHistoryService historyService;

    @GetMapping("/history")
    @HasRole({"ADMIN"})
    public ResponseEntity<List<History>> showHistoryList() {
        List<History> historyList = (List<History>) historyService.getAll();
        if (historyList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(historyList, HttpStatus.OK);
    }

    //Get History by id
    @GetMapping("/history/{id}")
    @HasRole({"ADMIN"})
    public ResponseEntity<Object> getHistoryById(@PathVariable("id") Integer id) {
        System.out.println("Fetching History with id " + id);
        Optional<History> history = historyService.get(id);
        if (history == null) {
            return new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Object>(history, HttpStatus.OK);
    }
}
