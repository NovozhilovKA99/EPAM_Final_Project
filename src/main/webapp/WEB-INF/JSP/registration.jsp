<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
    <head>
        <title>Registration</title>
        <link href="../CSS/loginreg.css" rel="stylesheet" type="text/css"><meta charset="utf-8"/>
    </head>

    <body>
        <div class="header">
            <a href="/home"><div class="item">Главная</div></a>
            <div class="item-center">Регистрация</div>
            <div class="item"></div>
        </div>
        <div class = "center">
            <form action="/registration" method="POST">
                <div class="input-text-wrap"><input type="text" class="input-text" name="login" placeholder="Логин"></div>
                <div class="input-text-wrap"><input type="password" class="input-text" name="password" placeholder="Пароль"></div>
                <div class="input-text-wrap"><input type="text" class="input-text" name="fullName" placeholder="Полное имя"></div>
                <div class="input-text-wrap"><input type="number" class="input-text" name="contractId" placeholder="Номер договора"></div>
                <div class="input-text-wrap"><input type="datetime-local" class="input-text" name="birthday" placeholder="Дата рождения"></div>
                <div class="input-text-wrap">
                    <select name="position" size="1" class="input-text">
                        <option>Кондуктор</option>
                        <option>Водитель</option>
                    </select>
                </div>
                <c:forEach var="error" items="${errorMsg}">
                    <div>"${error.defaultMessage}"</div>
                </c:forEach>
                <button>Register</button>
            </form>
        </div>
        <div class="footer">
            <div class="item"></div>
            <div class="item-center">Транспортная Компания "Транспортная компания"</div>
            <div class="item"></div>
        </div>
    </body>
</html>