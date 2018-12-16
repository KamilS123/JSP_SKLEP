package com.kamil.jsp_sklep.dao.spec;

import com.kamil.jsp_sklep.models.Product;

import java.util.List;

public interface ProductDao {
    List<Product> findAll();
}
