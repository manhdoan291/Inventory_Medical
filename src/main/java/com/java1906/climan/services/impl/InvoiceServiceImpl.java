package com.java1906.climan.services.impl;

import com.java1906.climan.controller.ResourceNotFoundException;
import com.java1906.climan.data.model.Invoice_Enter;
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
    public List<Invoice_Enter> finAllInvoice() {
        return invoiceRepository.findAll();
    }

    @Override
    public Optional<Invoice_Enter> findById(int invoiceId) {
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
    public Invoice_Enter save(int productInfoId, Invoice_Enter invoice) {
        List<Invoice_Enter> invoicesList = new ArrayList<>();
        ProductInfo productInfo1 = new ProductInfo();
        Optional<ProductInfo> productInfoById = productInfoRepository.findById(productInfoId);
        if(!productInfoById.isPresent()){
            try {
                throw new ResourceNotFoundException("ProductInfo with id "+productInfoId+ "does not exist");
            } catch (ResourceNotFoundException e) {
                e.printStackTrace();
            }
        }

//        ProductInfo productInfo = productInfoById.get();
//        invoice.setProductInfo(productInfo);
//        Invoice invoice1 =invoiceRepository.save(invoice);
//        invoicesList.add(invoice1);
//        productInfo1.setInvoices(invoicesList);
//        return invoice1;
            return null;
    }

    @Override
    public Invoice_Enter update(int invoiceId, Invoice_Enter invoice) {
        if(!invoiceRepository.existsById(invoiceId)){
            try {
                throw new ResourceNotFoundException("Invoice with id "+invoiceId + "not found");
            } catch (ResourceNotFoundException e) {
                e.printStackTrace();
            }
        }
        Optional<Invoice_Enter> invoiceById =invoiceRepository.findById(invoiceId);
        if(!invoiceById.isPresent()){
            try {
                throw new ResourceNotFoundException("Invoice with"+invoiceId + " not fount");
            } catch (ResourceNotFoundException e) {
                e.printStackTrace();
            }
        }
//        Invoice invoice1 =invoiceById.get();
//        invoice1.setName(invoice.getName());
//        invoice1.setLotNumber(invoice.getLotNumber());
//        invoice1.setDateOfManufacture(invoice.getDateOfManufacture());
//        invoice1.setExpiryDate(invoice.getExpiryDate());
//        invoice1.setQuantity(invoice.getQuantity());
//        invoice1.setUnit(invoice.getUnit());
//        invoice1.setPrice(invoice.getPrice());
//        invoice1.setCreateDate(invoice.getCreateDate());
//        invoice1.setUpdateDate(invoice.getUpdateDate());


//        return invoiceRepository.save(invoice1);
        return null;
    }

    @Override
    public void delete(int invoiceId) {
        if (!invoiceRepository.existsById(invoiceId)) {
            try {
                throw new ResourceNotFoundException("Invoice with id " + invoiceId + " not found");
            } catch (ResourceNotFoundException e) {
                e.printStackTrace();
            }
        }
        invoiceRepository.deleteById(invoiceId);
    }
}
