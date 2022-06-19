package com.acme.mylawyerbe.security.middleware;

import io.jsonwebtoken.*;
import org.apache.commons.lang3.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;

import java.util.Date;

public class JwtHandler {
    //esta clase sirve para crear un token

    //en cuanto tiempo va a expirar
    @Value("7")
    private int expirationDays;

    //secret: input para generar el token
    @Value("WriteHereYourSecretForTokenSigningCredentials")
    private String secret;

    private static final Logger logger = LoggerFactory.getLogger(JwtHandler.class);

    //funcion que nos permita crear un token
    public String generateToken(Authentication authentication){

        String subject = ((UserDetailsImpl) authentication.getPrincipal()).getUsername();

        Date issuedAt = new Date();
        Date expiration = DateUtils.addDays(issuedAt, expirationDays);

        return Jwts.builder().setSubject(subject)
                .setIssuedAt(issuedAt)
                .setExpiration(expiration)
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();
    }

    public String getUsernameFrom(String token){
        return Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    //el token sigue siendo valido?
    public boolean validateToken(String token){
        try {
            Jwts.parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(token);
            return true;
        }
        catch (SignatureException e){
            logger.error("Invalid JSON Web Token Signature: {}", e.getMessage());
        }catch (MalformedJwtException e){
            logger.error("Invalid JSON Web Token: {}", e.getMessage());
        }catch (ExpiredJwtException e){
            logger.error("Invalid JSON Web Token is expired: {}", e.getMessage());
        }catch (UnsupportedJwtException e){
            logger.error("JSON Web Token is unsupported: {}", e.getMessage());
        }catch (IllegalArgumentException e){
            logger.error("JSON Web Token claims string is empty: {}", e.getMessage());
        }
        return false;
    }

}
