<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page import="com.myweb.entity.Food" %>
<%@ page import="com.myweb.service.impl.FoodServiceImpl" %>
<%@ page import="com.myweb.service.FoodService" %>
<%@ page import="com.myweb.entity.Ftype" %>
<%@ page import="com.myweb.dao.*" %>
<%@ page import="com.myweb.dao.impl.*" %>



<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>商品管理系统</title>
<style>
    body {
        font-family: Arial, sans-serif;
        margin: 0;
        padding: 0;
        height: 100vh;
        background-image: url('images/green.jpeg');
    background-size: cover;
    background-position: center;
    }

    #header {
        text-align: center;
        color: gray;
        font-size: 48px;
        padding: 10px;
    }
    
    .left-align {
        margin-left: 0;
    }
    
    .search-container {
        text-align: center;
        margin-top: 20px;
    }
    
    .search-container input[type="text"] {
        padding: 5px;
        margin-right: 10px;
        border: 1px solid #ccc;
        border-radius: 5px;
    }
    
    .search-container button {
        padding: 5px 10px;
        background-color: #4CAF50;
        color: #fff;
        border: none;
        border-radius: 3px;
        cursor: pointer;
    }
    
    .search-container button:hover {
        background-color: #45a049;
    }
    
    table {
        border-collapse: collapse;
    }

    td {
        padding: 5px;
        border: 1px solid black;
    }
    
    .action-buttons {
        display: flex;
        justify-content: space-around;
    }
    
    .action-buttons button {
        padding: 5px 10px;
        background-color: #4CAF50;
        color: #fff;
        border: none;
        border-radius: 3px;
        cursor: pointer;
        margin: 0 5px;
    }
    
    .action-buttons button:hover {
        background-color: #45a049;
    }
    
    .add-food-button {
        margin-top: 20px;
        display: flex;
        justify-content: center;
    }
    
    .add-food-button button {
        padding: 8px 16px;
        background-color: #4CAF50;
        color: #fff;
        border: none;
        border-radius: 3px;
        cursor: pointer;
    }
    
    .add-food-button button:hover {
        background-color: #45a049;
    }
</style>
</head>
	
<body>
<form>
    <div>
        <div id="header">食物管理系统</div>
        <div class="search-container">
            <input type="text" name = "fname" id="searchNameInput" placeholder="食物名称">
            <input type="text" name = "ftype" id="searchIdInput" placeholder="食物种类">
            <input type="text" name = "fdesc" id="searchNameInput" placeholder="食物描述名称">
            <button onclick="search()">搜索</button>
        </div>

    </div>
</form>

        <div class="add-food-button">
            <button onclick="location.href='./Add'">添加食物</button>
        </div>

    
    <%
   
	    String fname = request.getParameter("fname");
	    String ftype = request.getParameter("ftype");
	    String fdesc = request.getParameter("fdesc");
	    
	    FoodDao dao = new FoodDaoImpl();
	    FoodService foodService = new FoodServiceImpl();
	    

	    if ("".equals(fname) && "".equals(ftype) && "".equals(fdesc)||fname==null&&ftype==null&&fdesc==null) { // 查询条件为空的情况
	    	request.setAttribute("list", foodService.getAllWithFtype());
	    } else { // 查询条件不为空的情况
	    	request.setAttribute("list", foodService.getFoodsByQus(fname,ftype,fdesc));
	    }

%>
    <table border="1">
        <thead>
            <tr>
                <td>商品ID</td>
                <td>商品类别</td>
                <td>商品名称</td>
                <td>商品图片</td>
                <td>商品单价</td>
                <td>商品介绍</td>
                <td>上架时间</td>
                <td>操作</td>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${list}" var="food">
                <tr>
                    <td>${food.fid}</td>
                    <td>${food.ftype.tname}</td>
                    <td>${food.fname}</td>
                    <td><img src="http://localhost:8080/food/foods/${food.fpic}" width="100px" height="100px"></td>
                    <td>${food.fprice}</td>
                    <td>${food.fdesc}</td>
                    <td>${food.fregtime}</td>
                    <td class="action-buttons">
                        <button onclick="location.href='./ShowChange?fid=${food.fid}'">修改</button>
                        <button onclick="location.href='./Remove?fid=${food.fid}'">删除</button>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
