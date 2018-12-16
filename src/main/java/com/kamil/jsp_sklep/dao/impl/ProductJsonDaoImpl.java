package com.kamil.jsp_sklep.dao.impl;

import com.kamil.jsp_sklep.dao.spec.ProductDao;
import com.kamil.jsp_sklep.models.Product;
import com.kamil.jsp_sklep.utils.JsonUtils;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProductJsonDaoImpl implements ProductDao {
    private static final Logger LOGGER = Logger.getLogger(ProductJsonDaoImpl.class.getName());
    @Override
    public List<Product> findAll() {
        List<Product>products = JsonUtils.getJson().getProducts();
        LOGGER.log(Level.INFO,"Products fetched");
        return products;
    }
}
