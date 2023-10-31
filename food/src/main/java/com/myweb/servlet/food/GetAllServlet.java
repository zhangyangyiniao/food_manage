package com.myweb.servlet.food;



import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.myweb.service.FoodService;
import com.myweb.service.impl.FoodServiceImpl;


@WebServlet("/Food/All")
public class GetAllServlet extends HttpServlet{
	
	private FoodService foodService = new FoodServiceImpl();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setAttribute("list", foodService.getAllWithFtype());
		
		request.getRequestDispatcher("/Food.jsp").forward(request, response);

	
	}

	

}
