package com.java1906.climan.services.impl;

import com.java1906.climan.controller.ResourceNotFoundException;
import com.java1906.climan.data.model.Invoice;
import com.java1906.climan.data.model.ProductInfo;
import com.java1906.climan.data.repo.InvoiceRepository;
import com.java1906.climan.data.repo.ProductInfoRepository;
import com.java1906.climan.services.IInvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class InvoiceServiceImpl implements IInvoiceService {
@Autowired
private InvoiceRepository invoiceRepository;
@Autowired
private ProductInfoRepository productInfoRepository;


    @Override
    public List<Invoice> finAllInvoice() {
        return invoiceRepository.findAll();
    }

    @Override
    public Optional<Invoice> findById(int invoiceId) {
        if(!invoiceRepository.existsById(invoiceId)){
            try{
                throw new ResourceNotFoundException("Invoice with"+invoiceId+"not found");
            }catch (ResourceNotFoundException e){
                e.printStackTrace();
            }
        }
        return invoiceRepository.findById(invoiceId);

    }

    @Override
    public Invoice save(int productInfoId, Invoice invoice) {
        List<Invoice> invoicesList = new ArrayList<>();
        ProductInfo productInfo1 = new ProductInfo();
        Optional<ProductInfo> productInfoById = productInfoRepository.findById(productInfoId);
        if(!productInfoById.isPresent()){
            try {
                throw new ResourceNotFoundException("Invoice with id "+productInfoId+ "does not exist");
            } catch (ResourceNotFoundException e) {
                e.printStackTrace();
            }
        }

        ProductInfo productInfo = productInfoById.get();
        invoice.setProductInfo(productInfo);
        Invoice invoice1 =invoiceRepository.save(invoice);
        invoicesList.add(invoice1);
        productInfo1.setInvoices(invoicesList);
        return invoice1;
    }

    @Override
    public Invoice update(int invoiceId, Invoice invoice) {
        return null;
    }

    @Override
    public void delete(int id) {

    }
}
