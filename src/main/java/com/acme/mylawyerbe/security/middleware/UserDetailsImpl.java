package com.acme.mylawyerbe.security.middleware;

import com.acme.mylawyerbe.security.domain.model.entity.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@AllArgsConstructor
@Getter
public class UserDetailsImpl implements UserDetails {

    private Long id;
    private String username;
    private String email;
    @JsonIgnore
    private String password;

    private Collection<? extends GrantedAuthority> authorities;

    //validaciones cuando un usuario se quiere logear

    //confirmar la cuenta
    @Override
    public boolean isAccountNonExpired(){
        return true;
    }

    //tu cuenta esta bloqueada
    @Override
    public boolean isAccountNonLocked(){
        return true;
    }

    //tus credenciales han expirado
    @Override
    public boolean isCredentialsNonExpired(){
        return true;
    }

    //que el usuario este activo
    @Override
    public boolean isEnabled(){
        return true;
    }

    @Override
    public boolean equals(Object other){
        if (this == other)
            return true;
        if (other == null || getClass() != other.getClass())
            return false;
        UserDetailsImpl user = (UserDetailsImpl) other;
        return Objects.equals(id, user.id);
    }

    //creacion del usuario
    public static UserDetailsImpl build(User user){
        List<GrantedAuthority> authorities = user.getRoles().stream().map(
                role ->  new SimpleGrantedAuthority(role.getName().name()))
                .collect(Collectors.toList());
        return new UserDetailsImpl(user.getId(), user.getUsername(), user.getEmail(),
                user.getPassword(), authorities);
    }
}
