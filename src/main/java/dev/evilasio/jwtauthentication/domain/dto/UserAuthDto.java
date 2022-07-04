package dev.evilasio.jwtauthentication.domain.dto;

import java.util.Set;

import dev.evilasio.jwtauthentication.domain.enums.RoleEnum;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserAuthDto {
    
    private String token;

    private Set<RoleEnum> roles;
}
