package com.kamil.jsp_sklep.dao.impl;

import com.kamil.jsp_sklep.dao.spec.ShoppingCartDao;
import com.kamil.jsp_sklep.models.JsonAccess;
import com.kamil.jsp_sklep.models.ShoppingCart;
import com.kamil.jsp_sklep.utils.JsonUtils;

import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ShoppingCartJsonDaoImpl implements ShoppingCartDao {
    private static final Logger LOGGER = Logger.getLogger(UserJsonDaoImpl.class.getName());

    @Override
    public List<ShoppingCart> findAll() {
        List<ShoppingCart> shoppingCarts
                = JsonUtils.getJson().getShoppingCarts();
        LOGGER.log(Level.INFO,"Fetched all" + shoppingCarts);
        return shoppingCarts;
    }

    @Override
    public Optional<ShoppingCart> findByUsername(String username) {
        List<ShoppingCart> shoppingCarts
                = JsonUtils.getJson().getShoppingCarts();

        Optional<ShoppingCart>shoppingCart = shoppingCarts.stream()
                .filter(e->e.getUsername().equals(username))
                .findFirst();
        return shoppingCart;
    }
//szuka konkretnej shoppingcart po username
    @Override
    public boolean update(ShoppingCart shoppingCart) {
        JsonAccess jsonAccess = JsonUtils.getJson();

        List<ShoppingCart> shoppingCarts
                = JsonUtils.getJson().getShoppingCarts();
        Optional<ShoppingCart> shoppingCartToUpdate
                = this.findByUsername(shoppingCart.getUsername());

        if(shoppingCartToUpdate.isPresent()) {
            int index = shoppingCarts.indexOf(shoppingCartToUpdate.get());
            shoppingCarts.set(index, shoppingCart);
        } else {
            shoppingCarts.add(shoppingCart);
        }

        jsonAccess.setShoppingCarts(shoppingCarts);
        JsonUtils.writeJson(jsonAccess);
        return true;

    }
}
