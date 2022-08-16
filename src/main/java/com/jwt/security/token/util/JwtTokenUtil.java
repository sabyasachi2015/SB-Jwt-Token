package com.jwt.security.token.util;

import java.util.Base64;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtTokenUtil {
	
	//generate the token
	
	public static String generateToken(String subject,String secret_key) {
		
		return Jwts.builder()
				   .setId("tk9931")
				   .setSubject(subject)
				   .setIssuer("CTS_Ltd")
				   .setAudience("XYZ_Ltd")
				   .setIssuedAt(new Date(System.currentTimeMillis()))
				   .setExpiration(new Date(System.currentTimeMillis()+TimeUnit.HOURS.toMillis(1)))
				   .signWith(SignatureAlgorithm.HS512, Base64.getEncoder().encode(secret_key.getBytes()))
				   .compact();	
	}
	//validate the token
	
	public static Claims getClaims(String token, String secret_key) {
		
		return Jwts.parser()
				   .setSigningKey(Base64.getEncoder().encode(secret_key.getBytes()))
				   .parseClaimsJws(token)
				   .getBody();
	}

}
