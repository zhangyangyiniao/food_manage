	package com.myweb.servlet.food;



import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import javax.swing.JOptionPane;

import com.google.gson.Gson;
import com.myweb.entity.Food;
import com.myweb.entity.Ftype;
import com.myweb.service.FoodService;
import com.myweb.service.impl.FoodServiceImpl;

@WebServlet("/Food/AddAction")
@MultipartConfig
public class AddActionServlet extends HttpServlet{
	
	private FoodService foodService = new FoodServiceImpl();
	
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Collection<Part> coll = request.getParts();
		
		Iterator<Part> it = coll.iterator();
		
		boolean uploadIsOK = false;
		Map<String,Object> map = new HashMap<String, Object>();
		
		
		while(it.hasNext()) {
			Part part = it.next();
						
			String name = part.getName();
			String filename = part.getSubmittedFileName();
			
			
			if(filename!=null) {
				
				
				String path = request.getServletContext().getRealPath("foods");
				String newFilename = UUID.randomUUID().toString().replaceAll("-", "")+"_"+filename;
				
				System.out.println(path);
				System.out.println(newFilename);
				System.out.println(filename);
				
				part.write(path+"/"+newFilename);
				
				uploadIsOK = new File(path+"/"+newFilename).exists();
				map.put("fpic",filename);
				
			}else {
				
				BufferedReader br = new BufferedReader(new InputStreamReader(part.getInputStream(),"UTF-8"));
				
				String value = br.readLine();
				
				System.out.println(name+": "+value);
			    map.put(name, value);
				
				
			}
			
			
			System.out.println("----------------------");
			
			
		}
		
		System.out.println(uploadIsOK);
		
		if(uploadIsOK) {
			
			foodService.add(new Food(null,
					Integer.parseInt(((String) map.get("tid")).trim()),
					(String)map.get("fname"),
					(String)map.get("fpic"),
					Double.parseDouble(((String) map.get("fprice")).trim()),
					null,
					(String)map.get("fdesc"),
					(String)map.get("fregtime"),
					null
					));
			
			int messageType = JOptionPane.INFORMATION_MESSAGE;

		     JOptionPane.showMessageDialog(null, "添加成功！", "提示", messageType);
		     
			response.sendRedirect("http://localhost:8080/food/Food/All");
			
		}else {
			//......
		}
	
	}

	
}
