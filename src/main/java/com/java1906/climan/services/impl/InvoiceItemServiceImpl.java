package com.java1906.climan.services.impl;

import com.java1906.climan.controller.ResourceNotFoundException;
import com.java1906.climan.data.model.CategoryValue;
import com.java1906.climan.data.model.Invoice;
import com.java1906.climan.data.model.InvoiceItem;
import com.java1906.climan.data.model.ProductInfo;
import com.java1906.climan.data.repo.InvoiceItemRepository;
import com.java1906.climan.data.repo.InvoiceRepository;
import com.java1906.climan.data.repo.ProductInfoRepository;
import com.java1906.climan.services.IInvoiceItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class InvoiceItemServiceImpl implements IInvoiceItemService {
    @Autowired
    private InvoiceItemRepository invoiceItemRepository;

    @Autowired
    private InvoiceRepository invoiceRepository;

    @Autowired
    private ProductInfoRepository productInfoRepository;


    @Override
    public List<InvoiceItem> findAll() {
        return invoiceItemRepository.findAll();
    }

    @Override
    public Optional<InvoiceItem> findById(Integer invoiceItemId) {
        if(!invoiceItemRepository.existsById(invoiceItemId)){
            try{
                throw new ResourceNotFoundException("Invoie item with"+invoiceItemId+"not found");
            }catch (ResourceNotFoundException e){
                e.printStackTrace();
            }
        }
        return invoiceItemRepository.findById(invoiceItemId);
    }

    @Override
    public InvoiceItem save(Integer invoiceId, InvoiceItem invoiceItem, Integer productInfoId) {
        List<InvoiceItem> invoiceItems = new ArrayList<>();
        Invoice invoice = new Invoice();

        Optional<Invoice> invoiceOptional = invoiceRepository.findById(invoiceId);
        Optional<ProductInfo> productInfoOptional = productInfoRepository.findById(productInfoId);
        if(!invoiceOptional.isPresent()){
            try {
                throw new ResourceNotFoundException("Invoice with id "+invoiceId+ "does not exist");
            } catch (ResourceNotFoundException e) {
                e.printStackTrace();
            }
        }
        Invoice invoice1 = invoiceOptional.get();
        invoiceItem.setInvoice(invoice1);
        ProductInfo productInfo1 = productInfoOptional.get();
        invoiceItem.setProductInfo(productInfo1);
        invoiceItem.setPriceInTotal(invoiceItem.getQty()*invoiceItem.getPriceIn());
        invoiceItem.setPriceOutTotal(invoiceItem.getQty()*invoiceItem.getPriceOut());
        InvoiceItem invoiceItem1 = invoiceItemRepository.save(invoiceItem);
        invoiceItems.add(invoiceItem1);
        invoice.setInvoiceItem(invoiceItems);
        return invoiceItem1;
    }

    @Override
    public InvoiceItem update(Integer invoiceItemId, InvoiceItem invoiceItem) {
        if(!invoiceItemRepository.existsById(invoiceItemId)){
            try {
                throw new ResourceNotFoundException("Invoice item with id "+invoiceItemId + "not found");
            } catch (ResourceNotFoundException e) {
                e.printStackTrace();
            }
        }
        Optional<InvoiceItem> invoiceItem1 =invoiceItemRepository.findById(invoiceItemId);
        if(!invoiceItem1.isPresent()){
            try {
                throw new ResourceNotFoundException("Invoice item with"+invoiceItemId + " not fount");
            } catch (ResourceNotFoundException e) {
                e.printStackTrace();
            }
        }

        InvoiceItem invoiceItem2 =invoiceItem1.get();


        return invoiceItemRepository.save(invoiceItem2);
    }

    @Override
    public void delete(Integer invoiceItemId) {

    }
}
