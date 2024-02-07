<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Laptop Survey</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        html, body {
            height: 100%;
            margin: 0;
            padding: 0;
        }
        body {
            height: 100%;
            width: 100%;
            color: white;
            background: linear-gradient(to bottom, #111111, #555555, #999999);
        }
        .container {
            margin-top: 50px;
        }
    </style>
</head>
<body>
<div class="container">
    <h1>Опрос о ноутбуках</h1>
    <form action="survey" method="post">
        <div class="form-group">
            <label for="laptopBrand">Какую марку вы предпочитатете:</label>
            <select class="form-control" id="laptopBrand" name="brand">
                <option value="hp">HP</option>
                <option value="dell">Dell</option>
                <option value="lenovo">Lenovo</option>
                <option value="asus">Asus</option>
                <option value="acer">Acer</option>
            </select>
        </div>
        <div class="form-group">
            <label>Операционную систему:</label>
            <div class="form-check">
                <input type="radio" class="form-check-input" id="osWindows" name="os" value="windows">
                <label class="form-check-label" for="osWindows">Windows</label>
            </div>
            <div class="form-check">
                <input type="radio" class="form-check-input" id="osMac" name="os" value="mac">
                <label class="form-check-label" for="osMac">macOS</label>
            </div>
            <div class="form-check">
                <input type="radio" class="form-check-input" id="osLinux" name="os" value="linux">
                <label class="form-check-label" for="osLinux">Linux</label>
            </div>
        </div>
        <div class="form-group">
            <label>Производительность:</label>
            <div class="form-check">
                <input type="checkbox" class="form-check-input" id="perfLow" name="performance" value="Низкая">
                <label class="form-check-label" for="perfLow">Только для просмотра мультимедиа (Низкая)</label>
            </div>
            <div class="form-check">
                <input type="checkbox" class="form-check-input" id="perfMedium" name="performance" value="Средняя">
                <label class="form-check-label" for="perfMedium">Для офисной работы (Средняя)</label>
            </div>
            <div class="form-check">
                <input type="checkbox" class="form-check-input" id="perfHigh" name="performance" value="Высокая">
                <label class="form-check-label" for="perfHigh">Для игр, рендеринга(Высокая)</label>
            </div>
        </div>
        <div class="form-group">
            <label for="comments">Дополнительные комментарии:</label>
            <textarea class="form-control" name ="comments" id="comments" rows="3"></textarea>
        </div>
        <button type="submit" class="btn btn-dark">Отправить опрос</button>
    </form>
    <% if (request.getAttribute("error") != null) { %>
    <div class="error-message"><%= request.getAttribute("error") %></div>
    <% } %>
</div>

</body>
</html>