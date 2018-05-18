package com.vilt.group.rest;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vilt.group.bean.Credentials;
import com.vilt.group.bean.UserLogged;
import com.vilt.group.util.JWTUtil;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;

@RestController
public class LoginController {
	private String USERNAME = "teste";
	private String PASSWORD = "teste";

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ResponseEntity<UserLogged> login(Credentials credentials) {
		if (this.USERNAME.equals(credentials.getUsername()) && this.PASSWORD.equals(credentials.getPassword())) {
			String token = JWTUtil.create(credentials.getUsername());
			UserLogged me = new UserLogged();
			me.setUsername(credentials.getUsername());
			me.setToken(token);
			return new ResponseEntity(me, HttpStatus.OK);
		} else {
			return new ResponseEntity(new UserLogged(), HttpStatus.UNAUTHORIZED);
		}
	}

	@RequestMapping(value = "/me", method = RequestMethod.GET)
	public UserLogged me(@RequestParam Map<String, String> params) {
		String token = params.get("token");
		Jws<Claims> jws = JWTUtil.decode(token);
		UserLogged me = new UserLogged();
		me.setUsername(jws.getBody().getSubject());
		return me;
	}
}
