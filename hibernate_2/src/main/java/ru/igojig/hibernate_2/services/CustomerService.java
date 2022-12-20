package ru.igojig.hibernate_2.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.igojig.hibernate_2.dao.CustomerDao;
import ru.igojig.hibernate_2.entity.Customer;

import java.util.List;

@Service
public class CustomerService {
    @Autowired
    CustomerDao customerDao;

    public Customer findById(Long id){
        return customerDao.findById(id);
    }

    public Customer findByName(String name){
        return customerDao.findByName(name);
    }

    public List<Customer> findCustomersByProductId(Long id){
        return customerDao.findCustomersByProductId(id);
    }

    public List<Customer> findAll(){
        return customerDao.findAll();
    }
}
