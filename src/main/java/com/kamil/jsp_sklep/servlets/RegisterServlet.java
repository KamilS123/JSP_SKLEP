package com.kamil.jsp_sklep.servlets;

import com.kamil.jsp_sklep.dao.impl.UserJsonDaoImpl;
import com.kamil.jsp_sklep.dao.spec.UserDao;
import com.kamil.jsp_sklep.models.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@WebServlet("/Register")
public class RegisterServlet extends HttpServlet {
    private UserDao userDao = new UserJsonDaoImpl();
    AtomicInteger id = new AtomicInteger(2);

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String surname = req.getParameter("surname");

        List<User> allUsers = userDao.findAll();
        Integer max = allUsers.stream()
                .mapToInt(User::getId)
                .max().getAsInt();

        User user = User.builder()
                .name(name)
                .username(username)
                .password(password)
                .surname(surname)
                .id(max+1)
                .role("user")
                .totalCashSpend(new BigDecimal(0))
                .build();

        userDao.create(user);

        RequestDispatcher rd = req.getRequestDispatcher("/index.jsp");
        rd.forward(req,resp);
    }
}
