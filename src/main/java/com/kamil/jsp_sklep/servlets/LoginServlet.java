package com.kamil.jsp_sklep.servlets;

import com.kamil.jsp_sklep.dao.impl.UserJsonDaoImpl;
import com.kamil.jsp_sklep.dao.spec.UserDao;
import com.kamil.jsp_sklep.models.User;
import com.kamil.jsp_sklep.utils.CookieUtils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Optional;

@WebServlet("/Login")
public class LoginServlet extends HttpServlet {
    private UserDao userDao = new UserJsonDaoImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        List<User>users = userDao.findAll();
        Optional<User> user = users.stream()
                .filter(e->e.getUsername().equals(username)
                        && e.getPassword().equals(password))
                .findFirst();

        if(user.isPresent()) {
            //ciasteczko
            CookieUtils.createUserCookie(resp,user.get());

            req.getSession().setAttribute("username",user.get().getUsername());

           resp.sendRedirect("Products");
        } else {
            RequestDispatcher rd = req.getRequestDispatcher("/index.jsp");
            PrintWriter out = resp.getWriter();
            out.println("<p>Invalid username or password</p>");
            rd.include(req,resp);
        }
    }
}
