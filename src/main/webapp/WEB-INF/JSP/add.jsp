<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
    <head>
        <title>Registration</title>
        <link href="../css/loginreg.css" rel="stylesheet" type="text/css"><meta charset="utf-8"/>
    </head>

    <body>
        <div class="header">
            <div class="item"></div>
            <div class="item-center">Добавление смены</div>
            <div class="item"></div>
        </div>
        <div class = "center">
            <form action="/register" method="POST">
                <div class="input-text-wrap"><input type="number" class="input-text" name="idDriver" placeholder="ИД водителя"></div>
                <div class="input-text-wrap"><input type="number" class="input-text" name="idDriver" placeholder="ИД кондуктора"></div>
                <div class="input-text-wrap"><input type="number" class="input-text" name="idDriver" placeholder="Номер маршрута"></div>
                <div class="input-text-wrap"><input type="number" class="input-text" name="idDriver" placeholder="ИД транспорта"></div>
                <div class="input-text-wrap"><input type="datetime-local" class="input-text" name="idDriver" placeholder="Время начала"></div>
                <div class="input-text-wrap"><input type="datetime-local" class="input-text" name="idDriver" placeholder="Время конца"></div>
                </div>
                <button>Добавить</button>
            </form>
        </div>
        <div class="footer">
            <div class="item"></div>
            <div class="item-center">Транспортная Компания "Транспортная компания"</div>
            <div class="item"></div>
        </div>
    </body>
</html>