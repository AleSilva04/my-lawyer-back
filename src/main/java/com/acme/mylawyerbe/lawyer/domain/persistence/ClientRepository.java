package com.acme.mylawyerbe.lawyer.domain.persistence;

import com.acme.mylawyerbe.lawyer.domain.model.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

    //verificar que clases se necesita, buscar porqué?
    Client findByFirstName(String firstName); //encuentra el que tiene este nombre

    List<Client> findAllByAge(int age); //encuentra TODOS que tengan esta edad

    List<Client> findAllByFirstName(String firstName); //encuentra TODOS que tengan este nombre

    Client findByEmail(String email);
}
