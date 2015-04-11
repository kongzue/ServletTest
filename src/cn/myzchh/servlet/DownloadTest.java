package cn.myzchh.servlet;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DownloadTest extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			String filepath=getServletContext().getRealPath("/1.jpg");
			//通知客户端以下载方式打开
			response.setHeader("Content-Disposition", "attachment;filename=1.jpg");
			response.setHeader("Content-Type", "application/octet-stream");//通知客户端正文类型
			InputStream in=new FileInputStream(filepath);
			OutputStream out= response.getOutputStream();
			int len=-1;
			byte b[] =new byte[1024];
			while((len=in.read(b))!=-1){
				out.write(b, 0, len);
			}
			in.close();
			out.close();
			
			//以下是具体代码：
			/*
			//得到要下载的文件
			ServletContext sc=getServletContext();		
			String path=sc.getRealPath("/1.jpg");		//获取文件真实路径，以“/”开头代表当前应用
			System.out.println("读取文件路径的值是："+path);
			
			//构建输入流
			response.setHeader("Content-Disposition", "attachment;filename=1.jpg");
			response.setHeader("Content-Type", "application/octet-stream");//通知客户端正文类型
			InputStream in=new FileInputStream(path);
			
			//构建输出流
			OutputStream out=response.getOutputStream();
			int len=-1;
			byte b[] =new byte[1024];
			while((len=in.read(b))!=-1){
				out.write(b, 0, len);
			}
			in.close();
			out.close();
			*/
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
