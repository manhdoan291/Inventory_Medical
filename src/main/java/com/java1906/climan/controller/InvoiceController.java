package com.java1906.climan.controller;

import com.java1906.climan.data.model.Invoice_Enter;
import com.java1906.climan.interceptor.HasRole;
import com.java1906.climan.services.IInvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class InvoiceController {
    @Autowired
    private IInvoiceService invoiceService;

    @GetMapping("/invoice")
    @HasRole({"STAFF", "ADMIN", "DOCTOR"})
    public ResponseEntity<List<Invoice_Enter>> showInvoiceList() {
        return new ResponseEntity<>(invoiceService.finAllInvoice(), HttpStatus.OK);
    }

    //get  byid
    @GetMapping("/{id}")
    @HasRole({"STAFF", "ADMIN"})
    public ResponseEntity<Object> getInvoiceById(@PathVariable("id") Integer id) {
        return new ResponseEntity<>(invoiceService.findById(id),HttpStatus.OK);
    }
  // create invoice
    @PostMapping("/invoice/{productInfoId}")
    @HasRole({"STAFF", "ADMIN", "DOCTOR"})
    public ResponseEntity<Invoice_Enter> createInvoce(@PathVariable(value = "productInfoId") int productInfoId, @RequestBody Invoice_Enter invoice){
        return new ResponseEntity<>(invoiceService.save(productInfoId,invoice),HttpStatus.CREATED);
    }
    //update invoice
    @PutMapping("/invoice/{invoiceId}")
    @HasRole({"STAFF", "ADMIN", "DOCTOR"})
    public ResponseEntity<Invoice_Enter> updateInvoice(@PathVariable("invoiceId") int invoiceId, @RequestBody Invoice_Enter invoice){
        return new ResponseEntity<>(invoiceService.update(invoiceId,invoice),HttpStatus.CREATED);
    }
    //
    @DeleteMapping("/{invoiceId}")
    public ResponseEntity<String> deleteInvoice( @PathVariable("invoiceId") int invoiceId){
      invoiceService.delete(invoiceId);
        return new ResponseEntity<>("Delete Ok",HttpStatus.OK);
    }

}
