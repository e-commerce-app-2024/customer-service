package com.ecommerce.app.mapper;


import com.ecommerce.app.dto.Address;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE,
        componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface AddressMapper {

    com.ecommerce.app.model.Address toAddress(Address address);

    Address toAddressRecord(com.ecommerce.app.model.Address address);
}
