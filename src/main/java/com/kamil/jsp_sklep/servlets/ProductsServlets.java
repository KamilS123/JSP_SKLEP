package com.kamil.jsp_sklep.servlets;

import com.kamil.jsp_sklep.dao.impl.ProductJsonDaoImpl;
import com.kamil.jsp_sklep.dao.spec.ProductDao;
import com.kamil.jsp_sklep.models.Product;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/Products")
public class ProductsServlets extends HttpServlet {
    private ProductDao productDao = new ProductJsonDaoImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Product> products = productDao.findAll();
        req.setAttribute("productList",products);

        RequestDispatcher rd = req.getRequestDispatcher("in.jsp");
        rd.forward(req,resp);
    }
}
