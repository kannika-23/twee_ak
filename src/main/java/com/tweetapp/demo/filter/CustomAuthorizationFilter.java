package com.tweetapp.demo.filter;
/*
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;
import java.util.function.Function;

import static org.springframework.http.HttpHeaders.AUTHORIZATION;


public class CustomAuthorizationFilter extends OncePerRequestFilter{

	@Autowired
	private JwtUtil jwtUtil;

	//@Value("${jwt.secret}")
	private String jwtSecret="secretkey";

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		if(request.getServletPath().equals("/login") || request.getServletPath().equals("/register")
		|| request.getServletPath().equals("/forgetPassword") ) {
			System.out.println("in Authorization "+ request.getServletPath());
			filterChain.doFilter(request, response);
		} else {
			String authorizationHeader = request.getHeader(AUTHORIZATION);
			System.out.println(authorizationHeader);
		if(authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
			try {
//						String token = authorizationHeader.substring("Bearer ".length());
////					Algorithm algorithm = Algorithm.HMAC256("secret".getBytes());
////					JWTVerifier verifier = 	JWT.require(algorithm).build();
////					DecodedJWT decodedJWT = verifier.verify(token);
////					String username = decodedJWT.getSubject();
////					System.out.println("USERNAME: "+ username);
////					Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
////					UsernamePasswordAuthenticationToken authenticationToken =
////							new UsernamePasswordAuthenticationToken(username, null, authorities);
////
////					SecurityContextHolder.getContext().setAuthentication(authenticationToken);
////					System.out.println("moving to chain");
				String token = authorizationHeader.substring("Bearer ".length());
				System.out.println("beforee validate"+ token);
				System.out.println(token.isEmpty());
				//Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token);
				System.out.println("check "+isTokenExpired(token));

				if(jwtUtil.validateToken(token) != null) {
					System.out.println(token.isEmpty());
					filterChain.doFilter(request, response);
				}
				}catch(Exception e) {
					response.setHeader("error", e.getMessage());
					Map<String, String> error = new HashMap<>();
					error.put("Error_msg", e.getMessage());
					new ObjectMapper().writeValue(response.getOutputStream(), error);
				}
				
			}else {
				filterChain.doFilter(request, response);
			}
		}
		
	}

	private Boolean isTokenExpired(String token) {
		System.out.println(token);
		final Date expiration = getExpirationDateFromToken(token);
		System.out.println("exp "+ expiration);
		return expiration.before(new Date());
	}
	public Date getExpirationDateFromToken(String token) {
		System.out.println("in exp "+token);
		return getClaimFromToken(token, Claims::getExpiration);
	}

	public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
		System.out.println("in claims "+token);
		final Claims claims = getAllClaimsFromToken(token);
		System.out.print(claims.getExpiration());
		return claimsResolver.apply(claims);
	}

	public Claims getAllClaimsFromToken(String token) {
		System.out.println(Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token));
		return Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody();
	}

}
*/