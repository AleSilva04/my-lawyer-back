package com.acme.mylawyerbe.lawyer.api;

import com.acme.mylawyerbe.lawyer.domain.model.entity.Lawyer;
import com.acme.mylawyerbe.lawyer.domain.model.entity.Specialty;
import com.acme.mylawyerbe.lawyer.domain.service.SpecialtyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Map;

public class SpecialtyController {
    @Autowired
    SpecialtyService specialtyService;

    @GetMapping()
    public ArrayList<Specialty> obtenerSpecialty(){
        return specialtyService.obtenerSpecialty();
    }

    @GetMapping("/test")
    public String mostrarMensaje() {
        return "Hola soy el mensaje";
    }

    @PostMapping()
    public Specialty crearSpecialty(@RequestBody Map<String, String> body){
        String specialty = body.get("specialty");

        Specialty newSpecialty = new Specialty(specialty);

        return specialtyService.crearSpecialty(newSpecialty);
    }

    @DeleteMapping("/{id}")
    public void eliminarSpecialty(@PathVariable("id") Long idSpecialty){
        specialtyService.eliminarSpecialty(idSpecialty);
    }

    @PutMapping("/{id}")
    public Specialty actualizarSpecialty(@RequestBody Map<String, String> body, @PathVariable("id") Long idSpecialty){
        String specialty = body.get("specialty");

        Specialty newSpecialty = new Specialty(specialty);

        return specialtyService.actualizarSpecialty(newSpecialty, idSpecialty);
    }
}
