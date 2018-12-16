package com.kamil.jsp_sklep.dao.impl;

import com.google.gson.Gson;
import com.kamil.jsp_sklep.dao.spec.UserDao;
import com.kamil.jsp_sklep.models.JsonAccess;
import com.kamil.jsp_sklep.models.User;
import com.kamil.jsp_sklep.utils.JsonUtils;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.Assert.*;

public class UserJsonDaoImplTest {
    private static UserDao userDao;
String json = "{\"users\":[{\"id\":1,\"username\":\"stecalbert\",\"password\":\"12345678\",\"totalCashSpend\":3900,\"name\":\"Albert\",\"surname\":\"Stec\",\"role\":\"admin\"},{\"id\":2,\"username\":\"bonaventura\",\"password\":\"qwerty1234\",\"totalCashSpend\":100,\"name\":\"Janusz\",\"surname\":\"Kowalski\",\"role\":\"user\"}],\"products\":[{\"id\":1,\"name\":\"kasza\",\"description\":\"sypka i fajna\",\"price\":10,\"quantity\":15},{\"id\":2,\"name\":\"Baton 3Bit\",\"description\":\"ciastko, karmel, czekolada\",\"price\":3,\"quantity\":27}],\"shoppingCarts\":[{\"username\":\"stecalbert\",\"products\":[{\"id\":6,\"quantity\":66},{\"id\":7,\"quantity\":1},{\"id\":2,\"quantity\":2}]},{\"username\":\"test\",\"products\":[{\"id\":2,\"quantity\":1}]}]}";
    @BeforeAll
    static void arrange() {
        userDao = new UserJsonDaoImpl();
    }
    @BeforeEach
    void resetData() {
        Gson gson = new Gson();
        JsonAccess jsonAccess = gson.fromJson(json,JsonAccess.class);
        JsonUtils.writeJson(jsonAccess);
    }

    @Test
    public void testCreate() {
        User user = User.builder()
                .surname("Stec")
                .password("12345678")
                .username("stecc")
                .name("albert")
                .build();
       boolean test = userDao.create(user);
       assertTrue(test);
    }
    @Test
    void findAll() {

    }
}