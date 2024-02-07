<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Страница входа</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <style>
        body {
            background: linear-gradient(to bottom, #000000, #333333);
            color: white;
        }
        .form-signin {
            height: 100vh;
            display: flex;
            align-items: center;
            justify-content: center;
        }

        .form-signin form {
            max-width: 300px;
        }

        .form-signin h1 {
            font-size: 24px;
        }

        .form-signin .form-floating {
            margin-bottom: 10px;
        }

        .form-signin .form-control {
            height: 40px;
            padding: 10px;
            font-size: 16px;
        }

        .form-signin .btn {
            height: 40px;
            font-size: 16px;
        }
        .laptop-image {
            max-width:500px;
            height: auto;
            margin-right: 20px;
        }
    </style>
</head>
<body>
<div class="text-center mt-5" style="margin-bottom: -150px;">
<h1 class="h1 mt-10 fw-normal"  >Вас приветствует сайт опроса</h1>
</div>
<main class="form-signin w-100 m-auto">
    <img class="laptop-image" src="https://img.ixbt.site/live/topics/preview/00/03/44/11/20f1eee55e.png" alt="Картинка ноутбука">
    <form action="login" method="post">

        <h1 class="h3 mb-3 fw-normal">Пожалуйста, войдите</h1>

        <div class="form-floating">
            <input type="text" name="login" class="form-control" id="floatingInput"placeholder="Password" >
            <label for="floatingInput">Логин</label>
        </div>
         <br>
        <div class="form-floating">
            <input type="password" name="password" class="form-control" id="floatingPassword" placeholder="Password">
            <label for="floatingPassword">Пароль</label>
        </div>

<br>
        <button class="btn  btn-dark  w-100 py-2" type="submit">Войти</button>
    </form>
</main>
<br/>

</body>
</html>