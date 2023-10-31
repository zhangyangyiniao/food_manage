package com.myweb.servlet.food;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.myweb.service.FtypeService;
import com.myweb.service.impl.FtypeServiceImpl;




@WebServlet("/Food/Add")
public class ShowAddServlet extends HttpServlet{

	private	FtypeService ftypeService = new FtypeServiceImpl();


	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("list", ftypeService.getAll());
           
		request.getRequestDispatcher("/ShowAdd.jsp").forward(request, response);
		
		
		
		
	}
	
}