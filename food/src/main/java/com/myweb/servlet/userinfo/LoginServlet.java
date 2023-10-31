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
import javax.swing.JOptionPane;

import com.google.gson.Gson;
import com.myweb.entity.Userinfo;
import com.myweb.service.UserinfoService;
import com.myweb.service.impl.*;



@WebServlet("/Userinfo/Login")
public class LoginServlet extends HttpServlet{

	
	private UserinfoService userinfoService = new UserinfoServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {          
		
		String usercode = request.getParameter("usercode");
		String userpwd = request.getParameter("userpwd");
		
		System.out.println(usercode);
		System.out.println(userpwd);
		
		
		Userinfo user = userinfoService.login(new Userinfo(null,usercode,userpwd,null));
		
		Map<String,Object> map = new HashMap<String, Object>();
		
		map.put("isOK",false);
		
		if(user!=null) {
			map.put("isOK",true);
			
			HttpSession session = request.getSession();
			session.setAttribute("loginUser", user);
			int messageType = JOptionPane.INFORMATION_MESSAGE;

		     JOptionPane.showMessageDialog(null, "登录成功！", "提示", messageType);
		
			response.sendRedirect("http://localhost:8080/food/Food/All");
		}else {
					
//		response.getWriter().write(new Gson().toJson(map));
		int messageType = JOptionPane.INFORMATION_MESSAGE;

	     JOptionPane.showMessageDialog(null, "登录失败！请检查您的用户名和密码是否正确。", "提示", messageType);
		
	     response.sendRedirect("http://localhost:8080/food/Login");
		}

		
		
		
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}
	
	

}
