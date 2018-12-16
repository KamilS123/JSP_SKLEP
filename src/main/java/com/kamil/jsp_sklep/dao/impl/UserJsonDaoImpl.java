package com.kamil.jsp_sklep.dao.impl;

import com.google.gson.Gson;
import com.kamil.jsp_sklep.dao.spec.UserDao;
import com.kamil.jsp_sklep.models.JsonAccess;
import com.kamil.jsp_sklep.models.User;
import com.kamil.jsp_sklep.utils.JsonUtils;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import static com.kamil.jsp_sklep.utils.JsonUtils.writeJson;

public class UserJsonDaoImpl implements UserDao {
    private static final Logger  LOGGER = Logger.getLogger(UserJsonDaoImpl.class.getName());
    private static final String jsonPath = "C:\\Users\\Kamil\\IdeaProjects\\JSP_SKLEP\\app.json";
    private Gson gson = new Gson();

    @Override
    public boolean create(User user) {
        JsonAccess jsonAccess = JsonUtils.getJson();
        jsonAccess.getUsers().add(user);
        writeJson(jsonAccess);
        LOGGER.log(Level.INFO,"User created" + user);
        return true;
    }

    @Override
    public List<User> findAll() {
        List<User>users = JsonUtils.getJson().getUsers();
        LOGGER.log(Level.INFO,"All users fetched");
        return users;
    }
}
