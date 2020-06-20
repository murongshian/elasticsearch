package com.example.elasticsearch;

import com.example.elasticsearch.dao.CustomerRepository;
import com.example.elasticsearch.domain.Customer;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

@SpringBootTest
class ElasticsearchApplicationTests {
    @Autowired
    private CustomerRepository repository;

    @Test
    public void saveCustomers() {
        repository.save(new Customer("murongshian1", "浙江1",13));
        repository.save(new Customer("murongshian2", "浙江2",14));
        repository.save(new Customer("murongshian3", "浙江3",15));
        repository.save(new Customer("murongshian4", "浙江4",16));
        repository.save(new Customer("murongshian5", "浙江5",17));
        repository.save(new Customer("murongshian6", "浙江6",18));
        repository.save(new Customer("murongshian7", "浙江7",19));
        repository.save(new Customer("murongshian8", "浙江8",20));
        repository.save(new Customer("murongshian9", "浙江9",21));
        repository.save(new Customer("murongshian10", "浙江10",22));
        repository.save(new Customer("murongshian11", "浙江11",23));
        repository.save(new Customer("murongshian12", "浙江12",24));
        repository.save(new Customer("murongshian13", "浙江13",25));
        repository.save(new Customer("murongshian14", "浙江14",26));
        repository.save(new Customer("murongshian15", "浙江15",27));
        repository.save(new Customer("murongshian16", "浙江16",28));
    }

    @Test
    public void fetchAllCustomers() {
        System.out.println("Customers found with findAll():");
        System.out.println("-------------------------------");
        for (Customer customer : repository.findAll()) {
            System.out.println(customer);
        }
    }

    @Test
    public void updateCustomers() {
        Customer customer= repository.findByUserName("murongshian1");
        System.out.println(customer);
        customer.setAddress("浙浙浙浙浙浙");
        repository.save(customer);
        Customer xcustomer=repository.findByUserName("murongshian1");
        System.out.println(xcustomer);
    }

    @Test
    public void deleteCustomers() {
        repository.deleteByUserName("murongshian1");
    }

    @Test
    public void deleteAll(){
        repository.deleteAll();
    }

    @Test
    public void fetchIndividualCustomers() {
        for (Customer customer : repository.findByAddress("浙江")) {
            System.out.println(customer);
        }
    }

    @Test
    public void fetchPage2Customers() {
        QueryBuilder customerQuery = QueryBuilders.boolQuery()
                .must(QueryBuilders.matchQuery("address", "浙江"));
        Page<Customer> page = repository.search(customerQuery, PageRequest.of(0, 5));
        System.out.println("Page customers "+page.getContent().toString());
    }
}