package com.java1906.climan.services.impl;

import com.java1906.climan.controller.ResourceNotFoundException;
import com.java1906.climan.data.model.Customer;
import com.java1906.climan.data.repo.CustomerRepository;
import com.java1906.climan.services.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.Optional;
@Transactional
@Service
public class CustomerServiceImpl implements ICustomerService {
    @Autowired
    private CustomerRepository customerRepository;
    @Override
    public List<Customer> getAll() {
        return customerRepository.findAll();
    }

    @Override
    public Optional<Customer> findById(Integer id) {
        if(!customerRepository.existsById(id)){
            try{
                throw new ResourceNotFoundException("Customer with"+id +"not found");
            }catch(ResourceNotFoundException e){
                e.printStackTrace();
            }

        }
        return customerRepository.findById(id);
    }

    @Override
    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Customer update(int customerId, Customer customer) throws Exception {
        if (!customerRepository.existsById(customerId)) {
            try {
                throw new ResourceNotFoundException("Customer with id " + customerId + " not found");
            } catch (ResourceNotFoundException e) {
                e.printStackTrace();
            }
        }
        Optional<Customer> customerOne =customerRepository.findById(customerId);

        if (!customerOne.isPresent()) {
            try {
                throw new ResourceNotFoundException("Customer with id " + customerId + " not found");
            } catch (ResourceNotFoundException e) {
                e.printStackTrace();
            }
        }
        Customer customer1 = customerOne.get();
        return customerRepository.save(customer1);
    }

    @Override
    public void delete(Integer customerId) {
        if (!customerRepository.existsById(customerId)) {
            try {
                throw new ResourceNotFoundException("Customer with id " + customerId + " not found");
            } catch (ResourceNotFoundException e) {
                e.printStackTrace();
            }
        }
        customerRepository.deleteById(customerId);
    }
}
