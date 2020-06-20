package com.example.elasticsearch.dao;

import com.example.elasticsearch.domain.Customer;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface CustomerRepository extends ElasticsearchRepository<Customer, String> {
    List<Customer> findByAddress(String address);
    Customer findByUserName(String userName);
    void deleteByUserName(String userName);
}