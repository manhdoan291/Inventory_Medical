package com.java1906.climan.services.impl;

import com.java1906.climan.controller.ResourceNotFoundException;
import com.java1906.climan.data.model.History;
import com.java1906.climan.data.model.Invoice;
import com.java1906.climan.data.repo.HistoryRepository;
import com.java1906.climan.data.repo.InvoiceRepository;
import com.java1906.climan.services.IHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class HistoryServiceImpl implements IHistoryService {

    @Autowired
    private HistoryRepository historyRepository;
    @Autowired
    private InvoiceRepository invoiceRepository;
    @Override
    public Iterable<History> finAllHistory() {
        return historyRepository.findAll();
    }

    @Override
    public Optional<History> findById(int historyId) {
        if(!historyRepository.existsById(historyId)){
            try{
                throw new ResourceNotFoundException("History with"+historyId+"not found");
            }catch (ResourceNotFoundException e){
                e.printStackTrace();
            }
        }
        return historyRepository.findById(historyId);
    }

    @Override
    public History save(int invoiceId,History history) {
        List<History> historyList =new ArrayList<>();
        Invoice invoice1 =new Invoice();
        Optional<Invoice> invoiceById = invoiceRepository.findById(invoiceId);
        if(!invoiceById.isPresent()){
            try {
                throw new ResourceNotFoundException("Invoice with id "+invoiceId+ "does not exist");
            } catch (ResourceNotFoundException e) {
                e.printStackTrace();
            }
        }
        Invoice invoice = invoiceById.get();
        history.setInvoices((List<Invoice>) invoice);
        History history1 =historyRepository.save(history);
        historyList.add(history1);
        return history1;
    }

    @Override
    public History update(int historyId,History history) {
        if(!historyRepository.existsById(historyId)){
            try {
                throw new ResourceNotFoundException("History with id "+history + "not found");
            } catch (ResourceNotFoundException e) {
                e.printStackTrace();
            }
        }
        Optional<History> histortById =historyRepository.findById(historyId);
        if(!histortById.isPresent()){
            try {
                throw new ResourceNotFoundException("History with"+histortById + " not fount");
            } catch (ResourceNotFoundException e) {
                e.printStackTrace();
            }
        }
        History history1 =histortById.get();
        history1.setQuantityExportInStock(history.getQuantityExportInStock());
        history1.setQuantityImportInStock(history.getQuantityImportInStock());
        history1.setQuantityInStock(history.getQuantityInStock());
        history1.setQuatityEndingInStock(history.getQuatityEndingInStock());
        history1.setExportDate(history.getExportDate());
        history1.setImportDate(history.getImportDate());
        history1.setIntoMoney(history.getIntoMoney());



        return historyRepository.save(history1);
    }

    @Override
    public void delete(int historyId) {
        if (!historyRepository.existsById(historyId)) {
            try {
                throw new ResourceNotFoundException("history with id " + historyId + " not found");
            } catch (ResourceNotFoundException e) {
                e.printStackTrace();
            }
        }
        historyRepository.deleteById(historyId);
    }
}
