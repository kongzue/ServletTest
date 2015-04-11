package cn.myzchh.servlet;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ReadApplocationPublicParameter extends HttpServlet {
//读物应用全局参数信息
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ServletContext sc=getServletContext();
		String value=sc.getInitParameter("encoding");
		response.getOutputStream().write(("读取全局参数\"encoding\"的值是："+value).getBytes());
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
