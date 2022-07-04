package dev.evilasio.jwtauthentication.service.login;

import java.util.Collections;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import dev.evilasio.jwtauthentication.domain.dto.UserAuthDto;
import dev.evilasio.jwtauthentication.domain.entity.User;
import dev.evilasio.jwtauthentication.domain.enums.RoleEnum;
import dev.evilasio.jwtauthentication.domain.form.LoginForm;
import dev.evilasio.jwtauthentication.domain.form.RegisterForm;
import dev.evilasio.jwtauthentication.repository.UserRepository;
import dev.evilasio.jwtauthentication.service.jwt.JwtService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LoginServiceImpl implements LoginService {

    private final UserRepository userRepository;

    private final JwtService jwtService;

    private final PasswordEncoder passwordEncoder;

    @Override
    public UserAuthDto authUser(LoginForm form) {
        User user = userRepository.findByUsername(form.getUsername())
                .orElseThrow(() -> new RuntimeException("usuario não encontrado"));

        checkPassword(user, form.getPassword());

        return jwtService.generateUserAuth(user);
    }

    @Override
    public UserAuthDto register(RegisterForm form) {

        checkUsername(form.getUsername());

        User user = createNewUser(form);

        return jwtService.generateUserAuth(user);
    }

    private User createNewUser(RegisterForm form) {
        User newUser = new User(form.getUsername(), passwordEncoder.encode(form.getPassword()), form.getName(),
                Collections.singleton(RoleEnum.USER));
        return userRepository.save(newUser);
    }

    private void checkUsername(String username) {
        if (userRepository.existsByUsername(username)) {
            throw new RuntimeException("username ja cadastrado");
        }
    }

    private void checkPassword(User user, String password) {
        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new RuntimeException("senha incorreta");
        }
    }
}
