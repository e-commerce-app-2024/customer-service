package com.ecommerce.app.controller;


import com.ecommerce.app.payload.AppResponse;
import com.ecommerce.app.dto.CustomerRequest;
import com.ecommerce.app.dto.CustomerResponse;
import com.ecommerce.app.service.CustomerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customer")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping
    public AppResponse<CustomerResponse> addCustomer(@Valid @RequestBody CustomerRequest customerRequest) {
        return AppResponse.created(customerService.addCustomer(customerRequest));
    }

    @PutMapping("/{id}")
    public AppResponse<CustomerResponse> updateCustomer(@PathVariable String id, @Valid @RequestBody CustomerRequest customerRequest) {
        return AppResponse.ok(customerService.updateCustomer(id, customerRequest));
    }

    @GetMapping("/{id}")
    public AppResponse<CustomerResponse> findCustomer(@PathVariable String id) {
        return AppResponse.ok(customerService.findCustomerById(id));
    }

    @GetMapping("/exists/{id}")
    public AppResponse<Boolean> exists(@PathVariable String id) {
        return AppResponse.ok(customerService.existsById(id));
    }

    @GetMapping
    public AppResponse<List<CustomerResponse>> findAll() {
        return AppResponse.ok(customerService.findAll());
    }

    @DeleteMapping("/{id}")
    public AppResponse<CustomerResponse> deleteCustomer(@PathVariable String id) {
        customerService.deleteCustomerById(id);
        return AppResponse.noContent();
    }
}
