<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
    <head>
        <title>login</title>
        <link href="../CSS/loginreg.css" rel="stylesheet" type="text/css"><meta charset="utf-8"/>
    </head>

    <body>
        <div class = "center">
            <div class="header">Вход для сотрудников</div>
            <form action="/login" method="POST">
                <div class="input-text-wrap"><input type="text" class="input-text" name="login" placeholder="Логин"></div>
                <div class="input-text-wrap"><input type="password" class="input-text" name="password" placeholder="Пароль"></div>
                <c:forEach var="error" items="${errorMsg}">
                    <div >${error.defaultMessage}</div>
                </c:forEach>
                <button>login</button>
            </form>
        </div>
    </body>
</html>