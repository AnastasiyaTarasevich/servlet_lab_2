package com.example.laba_3;

import java.io.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet("/survey")
public class TechMarket extends HttpServlet
{


    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession session = request.getSession();
        int userId = (int) session.getAttribute("userId");
        String brand = request.getParameter("brand");
        String os = request.getParameter("os");
        String[] performanceValues = request.getParameterValues("performance");
        if (brand == null || os == null || performanceValues == null || performanceValues.length == 0) {
            // Обработка ситуации, когда пользователь не выбрал обязательные поля
            // Например, вы можете отобразить сообщение об ошибке или перенаправить пользователя обратно к опросу
            request.setAttribute("error", "Пожалуйста, заполните все обязательные поля опроса.");
            request.getRequestDispatcher("success.jsp").forward(request, response);
            return;
        }
        if (performanceValues != null && performanceValues.length > 0) {
            StringBuilder performanceBuilder = new StringBuilder();
            for (String value : performanceValues) {
                performanceBuilder.append(value).append(",");
            }
            String performance = performanceBuilder.toString();
            // Удалите последнюю запятую
            if (performance.endsWith(",")) {
                performance = performance.substring(0, performance.length() - 1);
            }
            String comments = request.getParameter("comments");
            DatabaseHandler databaseHandler = new DatabaseHandler();
            databaseHandler.saveSurvey(userId, brand, os, performance, comments);
            ResultSet resultSet = databaseHandler.getAllSurveyResults();
            List<String[]> surveyResultsList = new ArrayList<>();
            try {
            while (resultSet.next()) {

                String[] surveyResult = new String[5];
                try {
                    surveyResult[0] = resultSet.getString("user_id");
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                try {
                    surveyResult[1] = resultSet.getString("brand");
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                try {
                    surveyResult[2] = resultSet.getString("op_system");
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                try {
                    surveyResult[3] = resultSet.getString("performance");
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                try {
                    surveyResult[4] = resultSet.getString("comments");
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }

                surveyResultsList.add(surveyResult);
            }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }


            request.setAttribute("surveyResponses", surveyResultsList);
           request.getRequestDispatcher("result.jsp").forward(request,response);


        }
    }
}
