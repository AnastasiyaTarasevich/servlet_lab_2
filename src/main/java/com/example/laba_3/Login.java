package com.example.laba_3;

import java.io.*;
import java.sql.ResultSet;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet("/login")
public class Login extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.getRequestDispatcher("/login.jsp").forward(request, response);
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        DatabaseHandler dbHandler = new DatabaseHandler();
        ResultSet resultSet;
        int counter = 0;
        try {
            resultSet = dbHandler.getUser(login, password);
            while (resultSet.next())
            {
                counter++;
            }
            if(counter>=1)
            {
              int userId = dbHandler.getUserId(login);
                // Сохранение идентификатора пользователя в сессии
                HttpSession session = request.getSession();
                session.setAttribute("userId", userId);
                response.sendRedirect("success.jsp");
            }
            else
            {

                response.sendRedirect("error.jsp");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }



    }
    }

