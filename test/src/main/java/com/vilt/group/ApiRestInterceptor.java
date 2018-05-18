package com.vilt.group;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.vilt.group.util.JWTUtil;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.SignatureException;

public class ApiRestInterceptor extends HandlerInterceptorAdapter{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		return true;
//		if (request.getRequestURI().startsWith("/api/login")) {
//			return true;
//		}
//		String token = request.getQueryString();
//		if (token == null || token.trim().isEmpty()) {
//			response.setStatus(401);
//			return false;
//		}
//		String[] aux = token.split("=");
//		token = aux[1];
//		
//		try {
//			Jws<Claims> parser = JWTUtil.decode(token);
//			System.out.println("User request: " + parser.getBody().getSubject());
//			response.setStatus(HttpStatus.OK.value());
//			return true;
//		} catch (SignatureException e) {
//			response.setStatus(401);
//		}
//		return false;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
	}
}
