package cn.myzchh.servlet;

import java.io.IOException;
import java.util.Random;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AutoRefreshPage extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Random r=new Random();
		String s=r.nextInt()+"";
		response.setHeader("Refresh", "2");//间隔一秒刷新一次
		//response.setHeader("Refresh", "3;URL=/WebTest/MyHtml.html");
		response.getOutputStream().write(("<p>这是一个随机数字的测试，你可以看看网页源代码，什么都没有，他是通过Servlet来执行的，每两秒会产生一个新的随机数字并刷新。</p>").getBytes());
		response.getOutputStream().write(s.getBytes());
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
