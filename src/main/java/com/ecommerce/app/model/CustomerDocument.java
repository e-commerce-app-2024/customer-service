package com.ecommerce.app.model;


import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Document(collection = "customer")
public class CustomerDocument {

    @Id
    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private Address address;

}
