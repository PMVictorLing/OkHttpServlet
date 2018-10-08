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
 * 评论接口
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
//		判断该用户有没有登陆，没有登陆或登陆过期都不让评论
		
		//设置cookie过期时间  有效时间是1天
		/*Cookie cookie = new Cookie("userName", "lwc");
		cookie.setMaxAge(60*60*24);//设置过期时间
		resp.addCookie(cookie);*/
		
		//设置返回数据
		ResponseEntity responseEntity = new ResponseEntity();
		responseEntity.code = "0033";
		responseEntity.msg = "评论失败，用户未登陆";
		
		Cookie[] cookies = req.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				String userName = cookie.getName();
				if (userName != null) {
					responseEntity.code = "0000";
					responseEntity.msg = "评论成功";
					return responseEntity;
					
				}
				
			}
		}
		
		// TODO Auto-generated method stub
		return responseEntity;
	}


}
