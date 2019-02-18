package org.ohdsi.authserver.security.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import javax.crypto.spec.SecretKeySpec;
import javax.servlet.http.HttpServletRequest;
import java.security.Key;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class JwtTokenProvider {

    private final String BEARER_PREFIX = "Bearer ";
    private final String ROLES = "roles";

    @Value("${security.jwt.token.secret-key}")
    private String secretKey = "secret";

    @Value("${security.jwt.token.expire-in-seconds}")
    private long validityInSeconds;

    public String createToken(String username, List<String> roles) {

        Claims claims = Jwts.claims().setSubject(username);
        claims.put(ROLES, roles);

        Date now = new Date();
        Date validity = new Date(now.getTime() + (validityInSeconds * 1000));

        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(now)
                .setExpiration(validity)
                .signWith(getKey())
                .compact();
    }

    public Authentication getAuthentication(String token) {

        try {
            Jws<Claims> claims = Jwts.parser().setSigningKey(getKey()).parseClaimsJws(token);
            String username = claims.getBody().getSubject();
            List<SimpleGrantedAuthority> roles = ((List<String>) claims.getBody().get(ROLES, List.class)).stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList());
        return new UsernamePasswordAuthenticationToken(username, "", roles);
        } catch (Exception ex) {
            throw new InvalidJwtAuthenticationException("Expired or invalid JWT token");
        }
    }

    public String resolveToken(HttpServletRequest request) {

        String bearerToken = request.getHeader(HttpHeaders.AUTHORIZATION);
        if (bearerToken != null && bearerToken.startsWith(BEARER_PREFIX)) {
            return bearerToken.substring(BEARER_PREFIX.length(), bearerToken.length());
        }
        return null;
    }

    private Key getKey() {

        return new SecretKeySpec(secretKey.getBytes(), SignatureAlgorithm.HS256.getJcaName());
    }
}
