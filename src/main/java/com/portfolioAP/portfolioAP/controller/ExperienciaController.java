package com.portfolioAP.portfolioAP.controller;

import com.portfolioAP.portfolioAP.Interface.Dto.dtoExperiencia;
import com.portfolioAP.portfolioAP.models.Experiencia;
import com.portfolioAP.portfolioAP.services.ExperienciaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@CrossOrigin(origins = "http://localhost:4200")
@CrossOrigin(origins = "https://portfolioap-auth.web.app")
public class ExperienciaController {
    @Autowired ExperienciaService experienciaService;

    public ExperienciaController(ExperienciaService experienciaService) {
        this.experienciaService = experienciaService;
    }

    @GetMapping("/experiencia/detail/{id}")
    public ResponseEntity<Experiencia> getById(@PathVariable("id") Long id) {
        if (!experienciaService.existsById(id)) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }

        Experiencia experiencia = experienciaService.getOne(id).get();
        return new ResponseEntity(experiencia, HttpStatus.OK);
    }

    @PutMapping("/experiencia/update/{id}")
    public ResponseEntity<?> editExperiencia(@PathVariable("id") Long id, @RequestBody dtoExperiencia dtoEdu) {
        if (!experienciaService.existsById(id)) {
            return new ResponseEntity(("El id no existe."), HttpStatus.BAD_REQUEST);
        }

        Experiencia experiencia = experienciaService.getOne(id).get();
        experiencia.setDescExp(dtoEdu.getDescExp());

        experienciaService.addExperiencia(experiencia);
        return new ResponseEntity(experiencia, HttpStatus.OK);
    }

    @GetMapping("/experiencia/all")
    public ResponseEntity<List<Experiencia>> obtenerExperiencia() {
        List<Experiencia> experiencias = experienciaService.list();
        return new ResponseEntity<>(experiencias, HttpStatus.OK);
    }

    @PostMapping("/experiencia/add")
    public ResponseEntity<Experiencia> addExperiencia(@RequestBody dtoExperiencia dtoExp) {
        Experiencia nuevaExperiencia = new Experiencia(dtoExp.getDescExp());
        experienciaService.addExperiencia(nuevaExperiencia);
        return new ResponseEntity<>(nuevaExperiencia, HttpStatus.CREATED);
    }

    @DeleteMapping("/experiencia/delete/{id}")
    public ResponseEntity<?> deleteExperiencia(@PathVariable("id") Long id) {
        experienciaService.deleteExperiencia(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
