package ru.igojig.hibernate_2.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.igojig.hibernate_2.dao.ProductDao;
import ru.igojig.hibernate_2.entity.Product;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductDao productDao;

    public List<Product> findProductsByCustomerId(Long id){
        return productDao.findProductsByCustomerId(id);
    }

    public List<Product> findAll() {
        return productDao.findAll();
    }

}
