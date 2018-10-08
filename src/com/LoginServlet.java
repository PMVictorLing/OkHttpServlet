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
 * 登陆接口
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
		//模拟服务器抛出异常
//		Integer.parseInt("aaa");
		
		//设置cookie过期时间  有效时间是1天
		Cookie cookie = new Cookie("userName", "lwc");
		cookie.setMaxAge(1000);//设置过期时间
		resp.addCookie(cookie);
		
		//设置返回数据
		ResponseEntity responseEntity = new ResponseEntity();
		responseEntity.code = "0022";
		responseEntity.msg = "用户名或密码错误";
		
		String userName = req.getParameter("userName");
		if ("lwc".equals(userName)) {
			responseEntity.code = "0000";
			responseEntity.msg = "登陆成功";
			
			LoginInfoEntity loginInfo = new LoginInfoEntity();
			loginInfo.userName = userName;
			loginInfo.sex = "男";
			responseEntity.data = JSON.toJSONString(loginInfo);
		}
		
		// TODO Auto-generated method stub
		return responseEntity;
	}


}
