package dev.evilasio.jwtauthentication.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.evilasio.jwtauthentication.domain.dto.HelloRoleDto;
import dev.evilasio.jwtauthentication.domain.enums.RoleEnum;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/admin")
@RequiredArgsConstructor
@PreAuthorize("hasRole('ADMIN')")
public class AdminController {

    @GetMapping("/hello")
    public HelloRoleDto helloAdmin(){
        return new HelloRoleDto(RoleEnum.ADMIN);
    }
}
