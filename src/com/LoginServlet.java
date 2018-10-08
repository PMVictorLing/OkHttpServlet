package com;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.httpresponse.LoginInfoEntity;
import com.httpresponse.ResponseEntity;

/**
 * ��½�ӿ�
 * 
 * @author yuyi
 *
 */

@WebServlet("/LoginServlet")
public class LoginServlet extends BaseJSONServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected ResponseEntity onHandle(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		//ģ��������׳��쳣
//		Integer.parseInt("aaa");
		
		//����cookie����ʱ��  ��Чʱ����1��
		Cookie cookie = new Cookie("userName", "lwc");
		cookie.setMaxAge(1000);//���ù���ʱ��
		resp.addCookie(cookie);
		
		//���÷�������
		ResponseEntity responseEntity = new ResponseEntity();
		responseEntity.code = "0022";
		responseEntity.msg = "�û������������";
		
		String userName = req.getParameter("userName");
		if ("lwc".equals(userName)) {
			responseEntity.code = "0000";
			responseEntity.msg = "��½�ɹ�";
			
			LoginInfoEntity loginInfo = new LoginInfoEntity();
			loginInfo.userName = userName;
			loginInfo.sex = "��";
			responseEntity.data = JSON.toJSONString(loginInfo);
		}
		
		// TODO Auto-generated method stub
		return responseEntity;
	}


}
