package com.bank.account.repository;

import com.bank.account.domain.model.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CustomerRepository extends MongoRepository<Customer,String> {

    boolean existsById(String id);
}
