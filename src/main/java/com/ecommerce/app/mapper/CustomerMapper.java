package com.ecommerce.app.mapper;

import com.ecommerce.app.model.CustomerDocument;
import com.ecommerce.app.dto.CustomerRequest;
import com.ecommerce.app.dto.CustomerResponse;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

import java.util.List;


@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE,
        componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface CustomerMapper {

    CustomerDocument toCustomer(CustomerRequest customerRequest);

    CustomerResponse toCustomerResponse(CustomerDocument customer);

    List<CustomerResponse> toCustomerResponse(Iterable<CustomerDocument> customers);

    void updateEntityFromRequest(CustomerRequest customerRequest, @MappingTarget CustomerDocument customer);


}
