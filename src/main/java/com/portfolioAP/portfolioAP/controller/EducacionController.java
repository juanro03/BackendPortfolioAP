package com.portfolioAP.portfolioAP.controller;
import com.portfolioAP.portfolioAP.Interface.Dto.dtoEducacion;
import com.portfolioAP.portfolioAP.models.Educacion;
import com.portfolioAP.portfolioAP.services.EducacionService;
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
@RequestMapping("/educacion")
@CrossOrigin(origins = "http://localhost:4200")
public class EducacionController {
    @Autowired EducacionService educacionService;
    

    public EducacionController(EducacionService educacionService){
        this.educacionService = educacionService;
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Educacion> getById(@PathVariable("id") Long id){
        if(!educacionService.existsById(id)){
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        
        Educacion educacion = educacionService.getOne(id).get();
        return new ResponseEntity(educacion,HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> editEducacion(@PathVariable("id") Long id, @RequestBody dtoEducacion dtoEdu){
        if(!educacionService.existsById(id))
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        
        Educacion educacion = educacionService.getOne(id).get();
        educacion.setDescEdu(dtoEdu.getDescEdu());
        
        educacionService.addEducacion(educacion);
        return new ResponseEntity(educacion, HttpStatus.OK);
        
    }
    
    @GetMapping("/all")
    public ResponseEntity<List<Educacion>> obtenerEducacion(){
        List<Educacion> educaciones= educacionService.list();
        return new ResponseEntity<>(educaciones, HttpStatus.OK);
    }
    
    @PostMapping("/add")
    public ResponseEntity<Educacion> addEducacion(@RequestBody dtoEducacion dtoEdu){
        Educacion nuevaEducacion=new Educacion(dtoEdu.getDescEdu());
        educacionService.addEducacion(nuevaEducacion);
        return new ResponseEntity<>(nuevaEducacion,HttpStatus.CREATED);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteEducacion(@PathVariable("id") Long id){
        educacionService.deleteEducacion(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
