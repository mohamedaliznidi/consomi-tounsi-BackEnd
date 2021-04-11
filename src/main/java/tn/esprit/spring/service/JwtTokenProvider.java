package tn.esprit.spring.service;


import io.jsonwebtoken.*;
import tn.esprit.spring.config.JwtConfig;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.stream.Collectors;


@Service
public class JwtTokenProvider {


	private static final Logger L = LogManager.getLogger(ProductServiceImpl.class);

	private final JwtConfig jwtConfig;

	public JwtTokenProvider(JwtConfig jwtConfig) {
		this.jwtConfig = jwtConfig;
	}

	public String generateToken(Authentication authentication) {

		Long now = System.currentTimeMillis();
		return Jwts.builder()
				.setSubject(authentication.getName())
				.claim("authorities", authentication.getAuthorities().stream()
						.map(GrantedAuthority::getAuthority).collect(Collectors.toList()))
				.setIssuedAt(new Date(now))
				.setExpiration(new Date(now + jwtConfig.getExpiration() * 1000))  // in milliseconds
				.signWith(SignatureAlgorithm.HS512, jwtConfig.getSecret().getBytes())
				.compact();
	}

	public Claims getClaimsFromJWT(String token) {
		return Jwts.parser()
				.setSigningKey(jwtConfig.getSecret().getBytes())
				.parseClaimsJws(token)
				.getBody();
	}

	public boolean validateToken(String authToken) {
		try {
			Jwts.parser()
			.setSigningKey(jwtConfig.getSecret().getBytes())
			.parseClaimsJws(authToken);

			return true;
		} catch (SignatureException ex) {
			L.error("Invalid JWT signature");
		} catch (MalformedJwtException ex) {
			L.error("Invalid JWT token");
		} catch (ExpiredJwtException ex) {
			L.error("Expired JWT token");
		} catch (UnsupportedJwtException ex) {
			L.error("Unsupported JWT token");
		} catch (IllegalArgumentException ex) {
			L.error("JWT claims string is empty.");
		}
		return false;
	}
}
