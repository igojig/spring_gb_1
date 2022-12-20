package ru.igojig.hibernate_2.dao;

import ru.igojig.hibernate_2.entity.Customer;

import java.util.List;

public interface CustomerDao {

    public Customer findById(Long id) ;

    public Customer findByName(String name);

    public List<Customer> findCustomersByProductId(Long id);

    public List<Customer> findAll();
}
