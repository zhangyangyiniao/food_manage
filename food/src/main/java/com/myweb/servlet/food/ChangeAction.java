package com.myweb.servlet.food;


import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.Iterator;
import java.util.UUID;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import javax.swing.JOptionPane;

import com.myweb.entity.Food;
import com.myweb.service.FoodService;
import com.myweb.service.impl.FoodServiceImpl;



@WebServlet("/Food/ChangeAction")
@MultipartConfig
public class ChangeAction extends HttpServlet{
	
	private FoodService foodService = new FoodServiceImpl();
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			Collection<Part> coll = request.getParts();
			
			Iterator<Part> it = coll.iterator();
			
			Map<String,Object> map = new HashMap<String, Object>();
			
			boolean uploadIsOK = false;
			
			String path;
			String newFilename;
			
			
			while(it.hasNext()) {
				Part part = it.next();
							
				String name = part.getName();
				String filename = part.getSubmittedFileName();
				
				if(filename!= null) {
					
					System.out.println("filename:" + filename);
					
					path = request.getServletContext().getRealPath("foods");
					newFilename = UUID.randomUUID().toString().replaceAll("-", "")+"_"+filename;
					
					System.out.println(path);
					System.out.println(newFilename);
					
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
			
			String a;
			
			if(map.get("fpic") == "") {
				a = (String)map.get("picname");
			}else {
				a = (String)map.get("fpic");
			}
			System.out.println("a:"+a);
			if(uploadIsOK) {
				foodService.update(new Food(Integer.parseInt(((String) map.get("fid")).trim()),
						Integer.parseInt(((String) map.get("tid")).trim()),
						(String)map.get("fname"),
						a,
						Double.parseDouble(((String) map.get("fprice")).trim()),
						null,
						(String)map.get("fdesc"),
						(String)map.get("fregtime"),
						null
						));

				int messageType = JOptionPane.INFORMATION_MESSAGE;
			     JOptionPane.showMessageDialog(null, "修改成功！", "提示", messageType);
			     
					response.sendRedirect("http://localhost:8080/food/Food/All");
			}else {
				//......
			}
				
			
			
	}
}
