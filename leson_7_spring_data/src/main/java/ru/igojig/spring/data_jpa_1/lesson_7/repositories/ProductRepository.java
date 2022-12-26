package ru.igojig.spring.data_jpa_1.lesson_7.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.igojig.spring.data_jpa_1.lesson_7.entities.Product;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
//    @Modifying
//    @Query(value = "insert into products(title, price) values (:title, :price)", nativeQuery = true)
//    void add(String title, int price);

    List<Product> findByPriceGreaterThan(Integer price);
    List<Product> findByPriceLessThan(Integer price);

    List<Product> findByPriceBetween(Integer minPrice, Integer maxPrice);
}
