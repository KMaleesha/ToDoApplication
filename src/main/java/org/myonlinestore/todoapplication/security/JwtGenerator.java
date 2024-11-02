package org.myonlinestore.todoapplication.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtGenerator{

    public String generateToken(Authentication authentication) {
        String email = authentication.getPrincipal().toString();
        Date currentDate = new Date();
        Date expireDate = new Date(currentDate.getTime() + SecurityConstant.JWT_EXPIRATION);

        String token = Jwts.builder()
                .setSubject(email)
                .setIssuedAt(new Date())
                .setExpiration(expireDate)
                .signWith(SignatureAlgorithm.HS512, SecurityConstant.JWT_SECRET)
                .compact();
        return token;
    }

    public String getUsernameFromToken(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(SecurityConstant.JWT_SECRET)
                .parseClaimsJws(token)
                .getBody();
        return claims.getSubject();
    }

    public boolean validateToken(String token) {
        try{
            Jwts.parser().setSigningKey(SecurityConstant.JWT_SECRET).parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            throw new AuthenticationCredentialsNotFoundException("JWT token was expired or invalid");
        }
    }
}