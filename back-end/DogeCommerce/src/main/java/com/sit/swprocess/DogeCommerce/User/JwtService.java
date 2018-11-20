package com.sit.swprocess.DogeCommerce.User;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;

@Service
public class JwtService {
    Logger logger = LoggerFactory.getLogger(JwtService.class);

    public static Algorithm algorithmHS = Algorithm.HMAC256("secret");
    public static JWTVerifier verifier = JWT.require(algorithmHS).withIssuer("auth0").build();
    public static JWTCreator.Builder signer = JWT.create().withIssuer("auth0");

    public DecodedJWT verify(String token) {
        logger.info("incoming Token: "+token);
        if(token.startsWith("Bearer ")) {
            token = token.substring(token.indexOf(' ')+1, token.length());
            logger.info("substringed Token: "+token);
            DecodedJWT decodedJWT = verifier.verify(token);
            logger.info("It is "+decodedJWT.getClaim("id").asLong()+" session");
            return decodedJWT;
        } else {
            throw new JWTVerificationException("Token is not containing \"Bearer\"");
        }
    }

    public String encodeUser(User user) {
        JWTCreator.Builder signer = JWT.create().withIssuer("auth0");
        Date expireDate = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(expireDate);
        calendar.add(Calendar.DATE, 7);
        expireDate = calendar.getTime();

        String token = signer
                .withClaim("id", user.getId())
                .withClaim("username", user.getUsername())
                .withClaim("email", user.getEmail())
                .withExpiresAt(expireDate)
                .sign(algorithmHS);
        return token;
    }
}
