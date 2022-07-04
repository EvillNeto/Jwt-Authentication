package dev.evilasio.jwtauthentication.service.jwt;

import java.time.Duration;
import java.time.Instant;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.auth0.jwt.interfaces.DecodedJWT;

import dev.evilasio.jwtauthentication.domain.dto.UserAuthDto;
import dev.evilasio.jwtauthentication.domain.entity.User;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class JwtServiceImpl implements JwtService {

    private static final Logger log = LoggerFactory.getLogger(JwtServiceImpl.class);

    private static final long TOKEN_EXPIRATION_HOURS = 8l;

    @Value("${jwt.token-secret}")
    private String tokenSecret;

    @Override
    public UserAuthDto generateUserAuth(User user) {

        Instant expiresAt = Instant.now().plusMillis(Duration.ofHours(TOKEN_EXPIRATION_HOURS).toMillis());

        String token =JWT.create()
            .withSubject(user.getId().toString())
            .withExpiresAt(expiresAt)
            .withClaim("roles", user.getRoles().stream().map(Enum::toString).collect(Collectors.toList()))
            .sign(Algorithm.HMAC512(tokenSecret.getBytes()));

        UserAuthDto dto = new UserAuthDto();
        dto.setRoles(user.getRoles());
        dto.setToken(token);

        return dto;
    }

    @Override
    public DecodedJWT decodeToken(String token) {
        try {
            JWTVerifier verifier = JWT.require(Algorithm.HMAC512(tokenSecret.getBytes())).build();
            return verifier.verify(token);
        } catch (SignatureVerificationException ex) {
            log.error("Invalid JWT signature");
            throw new RuntimeException("Invalid JWT signature");
        } catch (TokenExpiredException ex) {
            log.error("Expired JWT token");
            throw new RuntimeException("Expired JWT token");
        } catch (JWTVerificationException ex) {
            log.error(ex.getLocalizedMessage());
            throw new RuntimeException(ex.getLocalizedMessage());
        }
    }

}
