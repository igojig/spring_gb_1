package ru.igojig.hibernate_2.dao;

public interface OrderDao {
    public Integer getPriceByCustomerAndProduct(Long customerId, Long productId);

}
