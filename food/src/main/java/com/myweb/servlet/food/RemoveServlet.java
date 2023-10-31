package com.myweb.servlet.food;


import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import com.google.gson.Gson;
import com.myweb.service.FoodService;
import com.myweb.service.impl.FoodServiceImpl;

import com.google.gson.Gson;

@WebServlet("/Food/Remove")
public class RemoveServlet extends HttpServlet{
	
	private FoodService foodService = new FoodServiceImpl();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Map<String,Object> map = new HashMap<String, Object>();
		
		map.put("isOK",foodService.remove(Integer.parseInt(request.getParameter("fid"))));
		int messageType = JOptionPane.INFORMATION_MESSAGE;
	     JOptionPane.showMessageDialog(null, "修改成功！", "提示", messageType);
		
		response.sendRedirect("http://localhost:8080/food/Food/All");
	}
}
