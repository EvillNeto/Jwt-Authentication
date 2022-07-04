package dev.evilasio.jwtauthentication.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.evilasio.jwtauthentication.domain.dto.HelloRoleDto;
import dev.evilasio.jwtauthentication.domain.enums.RoleEnum;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
@PreAuthorize("hasRole('USER')")
public class UserController {

    @GetMapping("/hello")
    public HelloRoleDto helloUser() {
        return new HelloRoleDto(RoleEnum.USER);
    }
}
