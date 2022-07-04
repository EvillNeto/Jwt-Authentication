package dev.evilasio.jwtauthentication.service.jwt;

import com.auth0.jwt.interfaces.DecodedJWT;

import dev.evilasio.jwtauthentication.domain.dto.UserAuthDto;
import dev.evilasio.jwtauthentication.domain.entity.User;

public interface JwtService {
    
    public UserAuthDto generateUserAuth(User user);

    public DecodedJWT decodeToken(String token);
}
