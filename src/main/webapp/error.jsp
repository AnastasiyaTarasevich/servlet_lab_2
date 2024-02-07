<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Error Page</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f2f2f2;
            margin: 0;
            padding: 0;
            display: flex;
            align-items: center;
            justify-content: center;
            min-height: 100vh;
        }

        .container {
            text-align: center;
            padding: 20px;
            background-color: #ffffff;
            border-radius: 5px;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
        }

        h1 {
            color: #ff0000;
        }
        .back-link {
            margin-top: 20px;
        }
    </style>
</head>
<body>
<div class="container">
    <h1>Ошибка: что-то не так</h1>
    <p>Неправильный логин или пароль, попробуйте заново</p>
    <a class="back-link" href="javascript:history.back()">Вернуться к авторизации</a>
</div>
</body>
</html>
