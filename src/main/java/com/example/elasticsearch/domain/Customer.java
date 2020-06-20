package com.example.elasticsearch.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "customer", type = "customer", shards = 1, replicas = 0, refreshInterval = "-1")
public class Customer {
    @Id
    private String id;
    private String userName;
    private String address;
    private int age;

    public Customer(String userName, String address, int age) {
        this.userName = userName;
        this.address = address;
        this.age = age;
    }
    public Customer(){//很重要
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id='" + id + '\'' +
                ", userName='" + userName + '\'' +
                ", address='" + address + '\'' +
                ", age=" + age +
                '}';
    }
}