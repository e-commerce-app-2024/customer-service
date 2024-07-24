package com.ecommerce.app.service;

import com.ecommerce.app.exception.CustomerExistsException;
import com.ecommerce.app.exception.CustomerNotFoundException;
import com.ecommerce.app.mapper.CustomerMapper;
import com.ecommerce.app.model.CustomerDocument;
import com.ecommerce.app.repo.CustomerRepo;
import com.ecommerce.app.dto.CustomerRequest;
import com.ecommerce.app.dto.CustomerResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@AllArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepo customerRepo;
    private final CustomerMapper customerMapper;

    @Override
    public List<CustomerResponse> findAll() {
        Iterable<CustomerDocument> all = customerRepo.findAll();
        return customerMapper.toCustomerResponse(all);
    }

    @Override
    public CustomerResponse findCustomerById(String id) {
        var customer = findById(id);
        return customerMapper.toCustomerResponse(customer);
    }

    @Override
    public void deleteCustomerById(String id) {
        findById(id);
        customerRepo.deleteById(id);
    }

    @Override
    public CustomerResponse addCustomer(CustomerRequest customerRequest) {
        var customer = customerMapper.toCustomer(customerRequest);
        if (existByEmail(customer.getEmail())) {
            throw new CustomerExistsException(customerRequest.email());
        }
        customerRepo.save(customer);
        return customerMapper.toCustomerResponse(customer);
    }

    @Override
    public CustomerResponse updateCustomer(String id, CustomerRequest customerRequest) {
        var customer = findById(id);
        customerMapper.updateEntityFromRequest(customerRequest, customer);
        customerRepo.save(customer);
        return customerMapper.toCustomerResponse(customer);
    }

    @Override
    public Boolean existsById(String id) {
        return customerRepo.existsById(id);
    }

    private CustomerDocument findById(String id) {
        return customerRepo.findById(id).orElseThrow(() -> new CustomerNotFoundException(id));
    }

    private boolean existByEmail(String email) {
        return customerRepo.existsByEmail(email);
    }
}
