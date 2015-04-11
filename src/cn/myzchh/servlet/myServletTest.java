package cn.myzchh.servlet;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class myServletTest extends HttpServlet {
	private ServletConfig config;
	
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setHeader("Content-Type", "text/html;charset=UTF-8");
		PrintWriter out=response.getWriter();
		
		out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">");
		out.write("\n<html xmlns=\"http://www.w3.org/1999/xhtml\">");
		out.write("\n<html>");
		out.write("\n<title>myServletTest</title>");
		out.write("\n<meta http-equiv=\"content-type\" content=\"text/html; charset=UTF-8\">");
		out.write("\n<style>p{font-family: \"微软雅黑 Light\";font-size: 14px;}</style>");
		out.write("\n<body>");
		out.write("\n<p>hello my friend,I'm ZhangChao,this is my first servlet project,now let's test this page load successfully in your webbrowser</p>");
		String value=config.getInitParameter("haha");
		out.write(("\n<p>调用xml的config测试： value="+value+"</p>"));
		out.write(("\n<p>调用下载测试：<a href=\"DownloadTest\">点击下载</a></p>"));
		out.write(("\n<p>自动刷新测试：<a href=\"AutoRefreshPage\">点击进入</a></p>"));
		out.write(("\n<p>不进行缓存测试：<a href=\"NoCache\">点击进入</a></p>"));
		out.write(("\n<p>Servlet之间的数据共享：<a href=\"ServletContextTest\">放入</a>    <a href=\"ServletContextTest2\">读出</a></p>"));
		out.write(("\n<p>读取全局参数：<a href=\"ReadApplocationPublicParameter\">点击进入</a></p>"));
		out.write(("\n<p>调用中文文件名下载测试：<a href=\"DownloadTest2\">点击下载</a></p>"));
		out.write(("\n<p>其他读取资源文件测试：<a href=\"ReadProperties\">点击下载</a></p>"));
		out.write(("\n<p>登陆<a href=\"/ServletTest/login.html\">点击下载</a></p>"));
		out.write(("\n<p>设定缓存时限<a href=\"CacheTime\">点击进入</a></p>"));
		out.write(("\n<p>请求重定向<a href=\"RequestRedirection\">点击进入</a></p>"));
		
		out.write("\n</body>");
		out.write("\n</html>");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
	
	public void init(ServletConfig config) throws ServletException{
		this.config=config;
	}
}
