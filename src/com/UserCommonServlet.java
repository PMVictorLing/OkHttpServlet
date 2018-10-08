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
 * ���۽ӿ�
 * 
 * @author yuyi
 *
 */

@WebServlet("/UserCommonServlet")
public class UserCommonServlet extends BaseJSONServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected ResponseEntity onHandle(HttpServletRequest req, HttpServletResponse resp) throws Exception {
//		�жϸ��û���û�е�½��û�е�½���½���ڶ���������
		
		//����cookie����ʱ��  ��Чʱ����1��
		/*Cookie cookie = new Cookie("userName", "lwc");
		cookie.setMaxAge(60*60*24);//���ù���ʱ��
		resp.addCookie(cookie);*/
		
		//���÷�������
		ResponseEntity responseEntity = new ResponseEntity();
		responseEntity.code = "0033";
		responseEntity.msg = "����ʧ�ܣ��û�δ��½";
		
		Cookie[] cookies = req.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				String userName = cookie.getName();
				if (userName != null) {
					responseEntity.code = "0000";
					responseEntity.msg = "���۳ɹ�";
					return responseEntity;
					
				}
				
			}
		}
		
		// TODO Auto-generated method stub
		return responseEntity;
	}


}
