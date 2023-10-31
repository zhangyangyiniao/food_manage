<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>        
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Food Item</title>
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
</style>
</head>
<body>
    <h1 id="header">食物添加</h1>
 <form action="AddAction" method="post" enctype="multipart/form-data">
        <input name="fid" type="hidden" value="${food.fid} " />
        食品类别:
        <select name="tid">
            <c:forEach items="${list}" var="ty">
                <option value="${ty.tid}" <c:if test="${ty.tid == food.tid}">selected</c:if>>${ty.tname}</option>
            </c:forEach>
        </select>
        <hr>
        食品名称:
        <input name="fname" type="text" id="fname" required>
        <hr>
        选择图片:
        <input name="fpic" type="file" id="fpic" required>
        <hr>
        食品单价:
        <input name="fprice" type="text" id="fprice" required>
        <hr>
        食品描述:
        <input name="fdesc" type="text" id="fdesc" required>
        <hr>
        <button type="submit">添加</button>
    </form>
    <script>
        alert("欢迎进入食物信息添加界面。");
    </script>
</body>
</html>
