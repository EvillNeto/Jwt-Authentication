package dev.evilasio.jwtauthentication.domain.dto;

import dev.evilasio.jwtauthentication.domain.enums.RoleEnum;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HelloRoleDto {
    
    private String response;

    public HelloRoleDto(RoleEnum role){
        this.response = "Hello, "+role.toString();
    }
}
