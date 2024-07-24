package com.ecommerce.app.repo;


import com.ecommerce.app.model.CustomerDocument;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepo extends MongoRepository<CustomerDocument, String> {

    boolean existsByEmail(String email);
}
