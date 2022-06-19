package com.acme.mylawyerbe.security.domain.persistence;

import com.acme.mylawyerbe.security.domain.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    //opciones de acceso a datos que tiene un usuario en termino de seguridad
    //validar si el usuario existe
    Boolean existsByEmail(String email);

    Boolean existsByUsername(String username);

    Optional<User> findByUsername(String username);
}
