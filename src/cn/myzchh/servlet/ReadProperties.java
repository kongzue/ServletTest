package cn.myzchh.servlet;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.ResourceBundle;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//读取资源文件方式
public class ReadProperties extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getOutputStream().write(("\n<p>ServletContext方法（读取任何文件，只能在Web环境下用）：</p>").getBytes());
		//利用ServletContext读取a1.properties资源文件
			ServletContext sc=getServletContext();
			String path=sc.getRealPath("/WEB-INF/a1.properties");
			Properties props=new Properties();
			props.load(new FileInputStream(path));
			String value =props.getProperty("username");
			response.getOutputStream().write(("<p>从a1.properties文件中读取到的\"username\"的值是："+value+"</p>").getBytes());
			
		//利用ServletContext读取a2.properties资源文件
			ServletContext sc2=getServletContext();
			String path2=sc2.getRealPath("/WEB-INF/classes/a2.properties");
			Properties props2=new Properties();
			props2.load(new FileInputStream(path2));
			String value2 =props2.getProperty("username");
			response.getOutputStream().write(("\n<p>从a2.properties文件中读取到的\"username\"的值是："+value2+"</p>").getBytes());
		
		//利用ServletContext读取a3.properties资源文件
			ServletContext sc3=getServletContext();
			String path3=sc3.getRealPath("/WEB-INF/classes/cn/myzchh/properties/a3.properties");
			Properties props3=new Properties();
			props3.load(new FileInputStream(path3));
			String value3 =props3.getProperty("username");
			response.getOutputStream().write(("\n<p>从a3.properties文件中读取到的\"username\"的值是："+value3+"</p>").getBytes());

		response.getOutputStream().write(("\n<p>ResourceBundle方法（可在非Web环境下。但是只能读取路径中的Prooerties文件）：</p>").getBytes());
		
		//利用ResourceBundle读取a2.properties资源文件
			ResourceBundle rb=ResourceBundle.getBundle("a2");		//基名
			String value4 =rb.getString("username");
			response.getOutputStream().write(("\n<p>从a2.properties文件中读取到的\"username\"的值是："+value4+"</p>").getBytes());

		//利用ResourceBundle读取a3.properties资源文件
			ResourceBundle rb2=ResourceBundle.getBundle("cn.myzchh.properties.a3");		//基名
			String value5 =rb2.getString("username");
			response.getOutputStream().write(("\n<p>从a3.properties文件中读取到的\"username\"的值是："+value5+"</p>").getBytes());
			
			response.getOutputStream().write(("\n<p>ResourceBundle方法无法读取a1的值</p>").getBytes());

			response.getOutputStream().write(("\n<p>利用加载器读取配置文件方法（可在非Web环境下。但是读取任何路径中的文件）：</p>").getBytes());
		
		//利用加载器读取配置文件方法
			ClassLoader c1=ReadProperties.class.getClassLoader();//得到ReadProperties类加载器
			//InputStream in= c1.getResourceAsStream("a2.properties");
			InputStream in= c1.getResourceAsStream("cn.myzchh.properties.a3.properties");//加载a3
			Properties props6=new Properties();
			props6.load(in);
			String value6=props6.getProperty("username");
			response.getOutputStream().write(("\n<p>从a2.properties文件中读取到的\"username\"的值是："+value6+"</p>").getBytes());
	
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
