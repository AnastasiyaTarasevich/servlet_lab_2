<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Nastya
  Date: 25.09.2023
  Time: 13:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <title>Результаты опроса</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        html, body {
            height: 100%;
            margin: 0;
            padding: 0;
            color: white;
        }
        body {
            height: 100%;
            width: 100%;
            background: linear-gradient(to bottom, #111111, #555555, #999999);
        }
        th{
            color: white;
        }
        td
        {
            color: white;
        }

    </style>
</head>
<body>
<div class="container">
    <h1>Результаты опроса</h1>
    <table class="table">
        <thead>
        <tr>
            <th>ID</th>
            <th>Марка</th>
            <th>Операционная система</th>
            <th>Производительность</th>
            <th>Комментарии</th>
        </tr>
        </thead>
        <tbody>
        <% List<String[]> surveyResponses = (List<String[]>) request.getAttribute("surveyResponses");
            for (String[] surveyResult : surveyResponses) { %>
        <tr>

            <td><%= surveyResult[0] %></td>
            <td><%= surveyResult[1] %></td>
            <td><%= surveyResult[2] %></td>
            <td><%= surveyResult[3] %></td>
            <td><%=surveyResult[4]%></td>
        </tr>
        <% } %>
        </tbody>
    </table>
    <a class="back-link" href="#" onclick="redirectToLoginPage()">Вернуться на страницу авторизации</a>

    <script>
        function redirectToLoginPage() {
            window.location.href = "login.jsp";
        }
    </script>
</div>
</body>
</html>
