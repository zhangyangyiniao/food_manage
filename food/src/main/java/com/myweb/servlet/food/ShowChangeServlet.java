package com.myweb.servlet.food;



import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.myweb.service.FoodService;
import com.myweb.service.FtypeService;
import com.myweb.service.impl.FoodServiceImpl;
import com.myweb.service.impl.FtypeServiceImpl;

;

@WebServlet("/Food/ShowChange")
public class ShowChangeServlet extends HttpServlet{
	
	private FoodService foodService = new FoodServiceImpl();
	private	FtypeService ftypeService = new FtypeServiceImpl();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int fid = Integer.parseInt(request.getParameter("fid"));
		
		request.setAttribute("food", foodService.getByFid(fid));
		request.setAttribute("list", ftypeService.getAll());
		
		request.getRequestDispatcher("/ShowChange.jsp").forward(request, response);
		
		
		
		
		
		
		
		
	
	}

	
}
