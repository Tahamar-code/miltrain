package com.miltrainApp.security;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.List;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {


    private static final String SECRET = "your-super-long-and-secure-secret-key-32-characters-min";

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {


        String authHeader = request.getHeader("Authorization");

        if (authHeader != null && authHeader.startsWith("Bearer ")) {

            String token = authHeader.substring(7);

            try {

                Claims claims = Jwts.parserBuilder()
                                    .setSigningKey(Keys.hmacShaKeyFor(SECRET.getBytes()))
                                    .build()
                                    .parseClaimsJws(token)
                                    .getBody();


                String login = claims.getSubject();

                UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(login,
                                                                                                             null,
                                                                                                             List.of(new SimpleGrantedAuthority(
                                                                                                                     "ROLE_USER")));


                auth.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));


                SecurityContextHolder.getContext()
                                     .setAuthentication(auth);
            } catch (Exception e) {
                SecurityContextHolder.clearContext();
            }
        }
        filterChain.doFilter(request, response);
    }
}
