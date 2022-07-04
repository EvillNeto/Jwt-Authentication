package dev.evilasio.jwtauthentication.domain.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.validation.constraints.NotBlank;

import dev.evilasio.jwtauthentication.domain.enums.RoleEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User extends BaseEntity {

    @NotBlank
    @Column(unique = true)
    private String login;

    private String password;

    @NotBlank
    private String name;

    @ElementCollection(targetClass = RoleEnum.class, fetch = FetchType.EAGER)
	@CollectionTable(name = "users_profiles")
	@Enumerated(EnumType.STRING)
    private Set<RoleEnum> roles = new HashSet<>();
}
