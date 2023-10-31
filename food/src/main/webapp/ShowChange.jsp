<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>        
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>商品管理系统</title>
<style>
    body {
        background: linear-gradient(#c6ffbd, #ffffff);
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
        margin: 0;
        padding: 0;
    }

    #header {
        text-align: center;
        color: gray;
        font-size: 48px;
        padding: 10px;
    }

    form {
        background-color: #fff;
        padding: 40px;
        border-radius: 5px;
        box-shadow: 0 2px 5px rgba(0, 0, 0, 0.3);
        width: 400px;
    }

    form input[type="text"],
    form input[type="file"] {
        width: 100%;
        padding: 12px;
        margin-bottom: 20px;
        border: 1px solid #ccc;
        border-radius: 5px;
        font-size: 16px;
    }

    form button {
        width: 100%;
        padding: 12px;
        background-color: #4CAF50;
        color: #fff;
        border: none;
        border-radius: 3px;
        cursor: pointer;
        font-size: 16px;
    }

    form img {
        display: block;
        margin-bottom: 20px;
    }
</style>
</head>
<body>
    <h1 id="header">食物修改</h1>
<form action="ChangeAction" method="post" enctype="multipart/form-data">
        <input name="fid" type="hidden" value="${food.fid}" />
        食品类别:
        <select name="tid">
            <c:forEach items="${list}" var="ty">
                <c:if test="${ty.tid == food.tid}">
                    <option value="${ty.tid}" selected>${ty.tname}</option>
                </c:if>
                <c:if test="${ty.tid != food.tid}">
                    <option value="${ty.tid}">${ty.tname}</option>
                </c:if>
            </c:forEach>
        </select>
        <hr>
        食品名称:
        <input name="fname" type="text" value="${food.fname}" required />
        食品图片:
        <img src="http://localhost:8080/food/foods/${food.fpic}" width="100px" height="100px">
        <hr>
        图片名:
        <input name="picname" type="text" value="${food.fpic}"  required/>
        选择新图片:
        <input name="fpic" type="file">
        <hr>
        食品单价:
        <input name="fprice" type="text" value="${food.fprice}"  required/>
        食品描述:
        <input name="fdesc" type="text" value="${food.fdesc}"  required/>
        <hr>
        <button type="submit">修改</button>
    </form>
    <script>
        alert("欢迎进入食物信息修改界面。");
    </script>
</body>
</html>
