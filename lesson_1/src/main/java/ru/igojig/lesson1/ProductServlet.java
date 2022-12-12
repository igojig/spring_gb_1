package ru.igojig.lesson1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ProductServlet", urlPatterns = "/products")
public class ProductServlet extends HttpServlet {

    // http://localhost:8080/client/products

    private static final Logger logger = LoggerFactory.getLogger(ProductServlet.class);
    List<Product> products = new ArrayList<>();


    @Override
    public void init() throws ServletException {
        logger.debug("init");

        logger.debug("Start initialize product list");

        products.add(new Product(1, "Молоко", 100));
        products.add(new Product(2, "Кефир", 200));
        products.add(new Product(3, "Кофе", 300));
        products.add(new Product(4, "Мыло", 400));
        products.add(new Product(5, "Масло", 500));
        products.add(new Product(6, "Яблоки", 600));
        products.add(new Product(7, "Груши", 700));
        products.add(new Product(8, "Бананы", 800));
        products.add(new Product(9, "Чай", 900));
        products.add(new Product(10, "Капуста", 1000));

        logger.debug("Product list initialized");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.debug("doGet");
        resp.setContentType("text/html;charset=UTF-8");

        PrintWriter out = resp.getWriter();

        out.printf("<html><body>");
        for (Product product : products) {
            out.printf("<h2>[Id:%5d] [Наименование: %10s] [Цена: %5d]</h2>", product.id(), product.name(), product.price());
            logger.debug(product.toString());
        }
        out.printf("</body></html>");
        out.close();
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        logger.debug("service");
        super.service(req, res);
    }

    @Override
    public void destroy() {
        logger.debug("destroy");
    }
}
