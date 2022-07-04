package dev.evilasio.jwtauthentication.seeder;

import java.util.Collections;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import dev.evilasio.jwtauthentication.domain.entity.User;
import dev.evilasio.jwtauthentication.domain.enums.RoleEnum;
import dev.evilasio.jwtauthentication.repository.UserRepository;

@Service
public class DefaultSeeder {

    private static final Logger log = LoggerFactory.getLogger(DefaultSeeder.class);

    private final String seedAdminUsername;

    private final String seedAdminPassword;

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    public DefaultSeeder(@Value("${seed_admin_username}") final String seedAdminUsername,
            @Value("${seed_admin_password}") final String seedAdminPassword, UserRepository userRepository,
            PasswordEncoder passwordEncoder) {
        this.seedAdminUsername = seedAdminUsername;
        this.seedAdminPassword = seedAdminPassword;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void seedAdmin() {
        if (userRepository.count() == 0) {
            log.info("CREATING ADMIN SEED");

            User admin = new User();
            admin.setUsername(seedAdminUsername);
            admin.setPassword(passwordEncoder.encode(seedAdminPassword));
            admin.setName("Default Admin");
            admin.setRoles(Collections.singleton(RoleEnum.ADMIN));

            userRepository.save(admin);
        }
    }
}
