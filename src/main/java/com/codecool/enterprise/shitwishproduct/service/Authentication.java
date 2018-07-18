package com.codecool.enterprise.shitwishproduct.service;



import org.jose4j.jwa.AlgorithmConstraints;
import org.jose4j.jwk.HttpsJwks;
import org.jose4j.jws.AlgorithmIdentifiers;
import org.jose4j.jwt.JwtClaims;
import org.jose4j.jwt.MalformedClaimException;
import org.jose4j.jwt.consumer.InvalidJwtException;
import org.jose4j.jwt.consumer.JwtConsumer;
import org.jose4j.jwt.consumer.JwtConsumerBuilder;
import org.jose4j.keys.resolvers.HttpsJwksVerificationKeyResolver;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class Authentication {

    private HttpsJwksVerificationKeyResolver resolver;

    public Authentication(HttpsJwks httpsJwks) {
        this.resolver = new HttpsJwksVerificationKeyResolver(httpsJwks);
    }

    public String authorize(String token) {

        String[] tokenParts = token.split(" ");

        if (tokenParts.length != 2){
            return  null;
        }

        token = tokenParts[1];

        try {
            JwtConsumer jwtConsumer = new JwtConsumerBuilder()
                    .setRequireExpirationTime()
                    .setExpectedIssuer(System.getenv("ISSUER"))
                    .setExpectedAudience(System.getenv("AUDIENCE"))
                    .setVerificationKeyResolver(resolver)
                    .setJweAlgorithmConstraints(
                            new AlgorithmConstraints(
                                    AlgorithmConstraints.ConstraintType.WHITELIST,
                                    AlgorithmIdentifiers.RSA_USING_SHA256
                            )
                    )
                    .build();
            JwtClaims claims = jwtConsumer.processToClaims(token);
            if (claims.getExpirationTime().getValueInMillis() < new Date().getTime()) {
                System.out.println("Token has already expired!");
                return null;
            }
            return claims.getSubject();
        } catch (InvalidJwtException | MalformedClaimException e) {
            System.out.println("Invalid token!\n" + e);
            return null;
        }
    }
}
