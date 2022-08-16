package com.jwt.security.token.runner;

import java.util.Base64;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.jwt.security.token.util.JwtTokenUtil;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

@Component
public class JwtTokenRunner implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {
		
		
		String secret_key="J@!gt*K";
		
		//code to generate the token
		
		String generateToken = JwtTokenUtil.generateToken("Token1", secret_key);
		System.out.println("-----------------TOKEN--------------");
		System.out.println(generateToken);
		
		System.out.println("------------------------CLAIMS----------------------------------------------------");
		//code to test parsed token : Claims
		
		Claims claims = Jwts.parser()
		    .setSigningKey(Base64.getEncoder().encode(secret_key.getBytes()))
		    .parseClaimsJws(generateToken)
		    .getBody();
		
		 /*String secret_key = "J@!gt*K";
		    
				
				// code to test generated Token
				String token= JwtTokenUtil.generateToken("token", secret_key);
				System.out.println("------------------------TOKEN----------------------------------------------------");
				System.out.println(token);
				System.out.println();
				System.out.println("------------------------CLAIMS----------------------------------------------------");
				
				//code to test parsed token : Claims
				
		
		  Claims claims= Jwts.parser()
		                     .setSigningKey(Base64.getEncoder().encode(secret_key.getBytes()))
		                     .parseClaimsJws(token) .getBody();*/
		 

	}

}
