package com.springnet.springnet.security;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

public class TokenUtils {

    private final static String ACCESS_TOKEN_SECRET = "4hauh1uy23y13h13123aksk";
    private final static Long ACCESS_TOKE_VALIDTY_SECODNS = 2_592_000L;

    public static String createToken(String name, String email) {
        Long expirationTime = ACCESS_TOKE_VALIDTY_SECODNS * 1_000;
        Date expirationDate = new Date(System.currentTimeMillis() + expirationTime);

        Map<String, Object> extra = new HashMap<>();
        extra.put("name", name);

        return Jwts.builder().setSubject(email).setExpiration(expirationDate).addClaims(extra)
                .signWith(Keys.hmacShaKeyFor(ACCESS_TOKEN_SECRET.getBytes())).compact();
    }
}
