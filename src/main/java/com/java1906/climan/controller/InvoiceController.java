package com.java1906.climan.controller;

import com.java1906.climan.data.model.Invoice;
import com.java1906.climan.interceptor.HasRole;
import com.java1906.climan.services.IInvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class InvoiceController {
    @Autowired
    private IInvoiceService invoiceService;

    @GetMapping("/invoice")
    @HasRole({"STAFF", "ADMIN", "DOCTOR"})
    public ResponseEntity<List<Invoice>> showInvoiceList() {
        List<Invoice> invoiceList = (List<Invoice>) invoiceService.finAllInvoice();
        if (invoiceList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(invoiceList, HttpStatus.OK);
    }

  // create invoice
    @PostMapping("/invoice")
    @HasRole({"STAFF", "ADMIN", "DOCTOR"})
    public ResponseEntity<Invoice> createInvoce(@RequestBody Invoice invoice){
        Invoice inv = invoiceService.saveInvoice(invoice);
        return new ResponseEntity<>(inv,HttpStatus.CREATED);
    }
    //update invoice
    @PutMapping("/invoice")
    @HasRole({"STAFF", "ADMIN", "DOCTOR"})
    public ResponseEntity<Invoice> updateInvoide(@RequestBody Invoice invoice){
        Invoice inv = invoiceService.updateInvoice(invoice);
        return new ResponseEntity<>(inv,HttpStatus.CREATED);
    }
    //
    @DeleteMapping("/student")
    public ResponseEntity<String> deleteInvoice(@RequestParam Integer invoiceId){
        String message = invoiceService.deleteInvoice(invoiceId);
        return new ResponseEntity<>(message,HttpStatus.OK);
    }

}
