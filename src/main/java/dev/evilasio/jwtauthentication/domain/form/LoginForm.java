package dev.evilasio.jwtauthentication.domain.form;

import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginForm {
    
    @NotBlank(message = "field 'login' is null or blank")
    @Length(max = 64, message = "field 'login' is too long, max=64 caracters")
    private String login;

    @NotBlank(message = "field 'password' is null or blank")
    @Length(max = 32, message = "field 'password' is too long, max=32 caracters")
    private String password;
}
