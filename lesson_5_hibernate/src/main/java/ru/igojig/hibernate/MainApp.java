package ru.igojig.hibernate;

import ru.igojig.hibernate.dao.ProductDao;
import ru.igojig.hibernate.dao.ProductDaoImpl;
import ru.igojig.hibernate.model.Product;

public class MainApp {
    public static void main(String[] args) {
        SessionUtil.init();
        ProductDao productDao=new ProductDaoImpl();

        System.out.println("Find By ID: 3");
        System.out.println(productDao.findById(3L));
        System.out.println("------------------------------------");

        System.out.println("Find All:");
        System.out.println(productDao.findAll());
        System.out.println("------------------------------------");

        System.out.println("Find by title: 'Milk','Cheese'");
        System.out.println(productDao.findByTitle("Milk"));
        System.out.println(productDao.findByTitle("Cheese"));
        System.out.println("------------------------------------");

        System.out.println("Delete by id: 1");
        productDao.deleteById(1L);
        System.out.println(productDao.findAll());
        System.out.println("------------------------------------");

        System.out.println("Save new:");
        Product pr1=new Product("Test_1", 300);
        Product pr2=new Product("Test_2", 500);
        System.out.println(pr1);
        System.out.println(pr2);

        productDao.saveOrUpdate(pr1);
        productDao.saveOrUpdate(pr2);

        System.out.println(pr1);
        System.out.println(pr2);

        System.out.println(productDao.findAll());
        System.out.println("------------------------------------");

        System.out.println("Update product");
        Product product=productDao.findByTitle("Test_1");
        System.out.println(product);
        product.setPrice(900);
        productDao.saveOrUpdate(product);
        System.out.println(product);
        System.out.println(productDao.findAll());
        System.out.println("------------------------------------");

        System.out.println("Persist test");
        Product product1=new Product("Persist_test", 200);
        System.out.println("New product: " + product1);
        productDao.saveOrUpdate(product1);
        System.out.println(productDao.findAll());
        System.out.println("Set price to 900");
        product1.setPrice(900);
        System.out.println(product1);
        System.out.println("In database: ");
        System.out.println(productDao.findAll());
        System.out.println("------------------------------------");


        SessionUtil.close();
    }
}
