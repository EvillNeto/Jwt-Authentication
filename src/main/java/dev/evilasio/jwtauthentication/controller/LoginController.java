package dev.evilasio.jwtauthentication.controller;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.evilasio.jwtauthentication.domain.dto.UserAuthDto;
import dev.evilasio.jwtauthentication.domain.form.LoginForm;
import dev.evilasio.jwtauthentication.domain.form.RegisterForm;
import dev.evilasio.jwtauthentication.service.login.LoginService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/login")
@RequiredArgsConstructor
public class LoginController {
    
    private final LoginService loginService;

    @PostMapping
    public ResponseEntity<UserAuthDto> login(@RequestBody @Valid LoginForm form){
        return ResponseEntity.ok(loginService.authUser(form));
    }

    @PostMapping("/register")
    public ResponseEntity<UserAuthDto> register(@RequestBody @Valid RegisterForm form){
        return ResponseEntity.status(HttpStatus.CREATED).body(loginService.register(form));
    }
}
