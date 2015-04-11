package cn.myzchh.servlet;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletContextTest2 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//禁止缓存
			response.setHeader("Expires", "0");
			response.addHeader("Cache-Control", "no-cache");
			response.addHeader("Cache-Control", "no-store");  
			response.addHeader("Cache-Control", "must-revalidate");
			response.setHeader("Pragma", "no-cache");
		
		//读取数据共享
			ServletContext sc= getServletContext();
			String obj =(String) sc.getAttribute("a");
			response.getOutputStream().write(("已读取;name=\"a\",obj=\"" + obj + "\"").getBytes());
			
			
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	public void init() throws ServletException {
		
	}

}
