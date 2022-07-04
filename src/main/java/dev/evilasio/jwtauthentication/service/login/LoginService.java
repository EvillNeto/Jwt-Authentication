package dev.evilasio.jwtauthentication.service.login;

import dev.evilasio.jwtauthentication.domain.dto.UserAuthDto;
import dev.evilasio.jwtauthentication.domain.form.LoginForm;
import dev.evilasio.jwtauthentication.domain.form.RegisterForm;

public interface LoginService {
    
    public UserAuthDto authUser(LoginForm form);

    public UserAuthDto register(RegisterForm form);
}
