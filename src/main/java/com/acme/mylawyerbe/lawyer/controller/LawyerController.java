package com.acme.mylawyerbe.lawyer.controller;


import com.acme.mylawyerbe.lawyer.domain.model.entity.Lawyer;
import com.acme.mylawyerbe.lawyer.domain.service.LawyerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Map;

@Configuration
@EnableJpaAuditing
@RestController
@RequestMapping("/lawyer")
public class LawyerController {
    @Autowired
    LawyerService lawyerService;

    @GetMapping()
    public ArrayList<Lawyer> obtenerLawyers(){
        return lawyerService.obtenerLawyers();
    }

    @GetMapping("/test")
    public String mostrarMensaje() {
        return "Hola soy el mensaje";
    }

    @PostMapping()
    public Lawyer crearLawyer(@RequestBody Map<String, String> body){
        String fullName = body.get("fullName");
        String address = body.get("address");
        int age = Integer.parseInt(body.get("age"));
        String email = body.get("email");
        int points = Integer.parseInt(body.get("points"));
        String image = body.get("image");

        Lawyer newLawyer = new Lawyer(fullName, address, age, email,points,image);

        return lawyerService.crearLawyer(newLawyer);
    }

    @DeleteMapping("/{id}")
    public void eliminarLawyer(@PathVariable("id") Long idLawyer){
        lawyerService.eliminarLawyer(idLawyer);
    }

    @PutMapping("/{id}")
    public Lawyer actualizarLawyer(@RequestBody Map<String, String> body, @PathVariable("id") Long idLawyer){
        String fullName = body.get("fullName");
        String address = body.get("address");
        int age = Integer.parseInt(body.get("age"));
        String email = body.get("email");
        int points = Integer.parseInt(body.get("points"));
        String image = body.get("image");

        Lawyer newLawyer = new Lawyer(fullName, address, age, email,points,image);

        return lawyerService.actualizarLawyer(newLawyer, idLawyer);
    }

}
