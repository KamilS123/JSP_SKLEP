package com.kamil.jsp_sklep.servlets;

import com.kamil.jsp_sklep.dao.impl.ShoppingCartJsonDaoImpl;
import com.kamil.jsp_sklep.dao.spec.ShoppingCartDao;
import com.kamil.jsp_sklep.models.Product;
import com.kamil.jsp_sklep.models.ShoppingCart;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@WebServlet("/AddProduct")
public class AddProduct extends HttpServlet {
    ShoppingCartDao shoppingCartDao = new ShoppingCartJsonDaoImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("product");
        String username = (String) req.getSession().getAttribute("username");

        Optional<ShoppingCart> shoppingCart
                =shoppingCartDao.findByUsername(username);

        if(shoppingCart.isPresent()) {
            List<Product>products = shoppingCart.get().getProducts();
            Optional<Product> product = shoppingCart.get().getProducts().stream()
                    .filter(e->e.getId().equals(Integer.valueOf(id)))
                    .findFirst();
            if(product.isPresent()) {
               int index = products.indexOf(product.get());
               int actualQuantity = product.get().getQuantity();
               product.get().setQuantity(actualQuantity + 1);
               products.set(index,product.get());
            } else {
                Product productToAdd = Product.builder()
                        .id(Integer.valueOf(id))
                        .quantity(1)
                        .build();
                products.add(productToAdd);
            }
            shoppingCartDao.update(shoppingCart.get());
        }
        resp.sendRedirect("/Products");
    }
}
