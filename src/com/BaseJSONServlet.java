package com;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.httpresponse.ResponseEntity;

public abstract class BaseJSONServlet extends BaseServlet{

	/**
	 * ר�Ŵ���json�Ļ���
	 */
	
	
	private static final long serialVersionUID = 1L;

	@Override
	protected void onResponse(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//��������ͷ
		resp.setContentType("text/html;charset=utf-8");
		
		//��������
		ResponseEntity responseEntity = null;
		
		try {
			responseEntity = onHandle(req,resp);
		} catch (Exception e) {
			responseEntity = new ResponseEntity();
		}
		
		
		PrintWriter printWriter = resp.getWriter();
		//д��json
		String responseJSONStr = JSON.toJSONString(responseEntity);
		printWriter.write(responseJSONStr);
		
		printWriter.flush();
		printWriter.close();
	}

	protected abstract ResponseEntity onHandle(HttpServletRequest req, HttpServletResponse resp) throws Exception;

}
