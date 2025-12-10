package com.jwt;

import java.security.Key;
import java.util.Date;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

public class JwtUtil {

	private static final Key SECRET_KEY = Keys.hmacShaKeyFor(
			"this_is_my_secret_key_for_project_lms_system_1611".getBytes()
		); 
	
	private static final long EXPIRATION_MS = 1000 * 60 * 30;
	
	public static String generateToken(String username, String role) {
		Date now = new Date();
		
		Date expiry = new Date(now.getTime() + EXPIRATION_MS);
		
		return Jwts.builder()
				.setSubject(username)
				.claim("role", role)
				.setIssuedAt(now)
				.setExpiration(expiry)
				.signWith(SECRET_KEY, SignatureAlgorithm.HS256)
				.compact();
	}
	
}
