package com.java1906.climan.controller;

import com.java1906.climan.data.model.Invoice;
import com.java1906.climan.interceptor.HasRole;
import com.java1906.climan.services.IInvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class InvoiceController {
    @Autowired
    private IInvoiceService invoiceService;

    @GetMapping("/invoice")
    @HasRole({"STAFF", "ADMIN", "DOCTOR"})
    public ResponseEntity<List<Invoice>> showInvoiceList() {
        List<Invoice> invoiceList = (List<Invoice>) invoiceService.getAll();
        if (invoiceList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(invoiceList, HttpStatus.OK);
    }

    //Get Invoice by id
    @GetMapping("/invoice/{id}")
    @HasRole({"STAFF", "ADMIN", "DOCTOR"})
    public ResponseEntity<Object> getInvoiceById(@PathVariable("id") Integer id) {
        System.out.println("Fetching Invoice with id " + id);
        Optional<Invoice> invoice = invoiceService.get(id);
        if (invoice == null) {
            return new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Object>(invoice, HttpStatus.OK);
    }
}
