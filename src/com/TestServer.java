package com;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/TestServlet")
public class TestServer extends HttpServlet{
	private static final long SerialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		super.doGet(req, resp);
		doPost(req,resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		super.doPost(req, resp);
		PrintWriter printWriter = resp.getWriter();
		System.out.println("HttpRequest");
		printWriter.write("test post");
		printWriter.flush();
		printWriter.close();
		
	}
	
	@Override
	protected long getLastModified(HttpServletRequest req) {
		//这个文本有没有更新过
		File file = new File(req.getContextPath(),"index.html");
		return file.lastModified();
	}
	
	

}
