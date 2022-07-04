package dev.evilasio.jwtauthentication.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.evilasio.jwtauthentication.domain.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
    
    Optional<User> findByLogin(String login);

    boolean existsByLogin(String login);
}
