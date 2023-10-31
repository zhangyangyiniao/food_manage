package com.myweb.servlet.userinfo;



import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.myweb.entity.Userinfo;

@WebServlet("/Userinfo/GetUser")
public class GetUserServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
					
		Map<String,Object> map = new HashMap<String, Object>();
		
		HttpSession session = request.getSession();
		Object obj = session.getAttribute("loginUser");
		
		map.put("isOK",false);
		map.put("msg","not login");
		
		if(obj!=null) {
			map.put("isOK",true);
			map.put("msg","already login");
			map.put("loginUser",(Userinfo)obj);
				
		}
		
		response.getWriter().write(new Gson().toJson(map));
		
		
		
		
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}
	
	

}
