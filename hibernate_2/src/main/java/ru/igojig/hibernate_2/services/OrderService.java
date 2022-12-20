package ru.igojig.hibernate_2.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.igojig.hibernate_2.dao.OrderDao;
import ru.igojig.hibernate_2.entity.Order;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderDao orderDao;

    public List<Order> getPriceByCustomerAndProduct(Long customerId, Long productId){
        return orderDao.getPriceByCustomerAndProduct(customerId, productId);
    }
}
