package ru.igojig.hibernate_2.dao;

import ru.igojig.hibernate_2.entity.Order;

import java.util.List;

public interface OrderDao {
    public List<Order> getPriceByCustomerAndProduct(Long customerId, Long productId);

}
