package com.kamil.jsp_sklep.dao.spec;

import com.kamil.jsp_sklep.models.User;

import java.util.List;

public interface UserDao {
    boolean create(User user);
    List<User>findAll();
}
