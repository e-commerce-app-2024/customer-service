package com.ecommerce.app.service;

import com.ecommerce.app.dto.CustomerRequest;
import com.ecommerce.app.dto.CustomerResponse;

import java.util.List;

public interface CustomerService {

    List<CustomerResponse> findAll();

    CustomerResponse findCustomerById(String id);

    void deleteCustomerById(String id);

    CustomerResponse addCustomer(CustomerRequest customerRequest);

    CustomerResponse updateCustomer(String id, CustomerRequest customerRequest);

    Boolean existsById(String id);
}
