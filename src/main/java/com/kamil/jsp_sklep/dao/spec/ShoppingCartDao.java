package com.kamil.jsp_sklep.dao.spec;

import com.kamil.jsp_sklep.models.ShoppingCart;

import java.util.List;
import java.util.Optional;

public interface ShoppingCartDao {
    List<ShoppingCart> findAll();
    Optional<ShoppingCart> findByUsername(String username);
    boolean update(ShoppingCart shoppingCart);
}
