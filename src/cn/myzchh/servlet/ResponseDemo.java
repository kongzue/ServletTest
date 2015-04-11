package cn.myzchh.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ResponseDemo extends HttpServlet {
	//字符流输出数据
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			String s="这一句话是UTF-8编码的中文";
			response.setCharacterEncoding("UTF-8");
			response.setHeader("Content-Type", "text/html;charset=UTF-8");	
			//response.setContentType("text/html;charset=UTF-8");					//方式2
			response.getOutputStream().write(s.getBytes("UTF-8"));
			
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
