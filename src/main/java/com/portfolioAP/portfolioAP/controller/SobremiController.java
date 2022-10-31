package com.portfolioAP.portfolioAP.controller;
import com.portfolioAP.portfolioAP.Interface.Dto.dtoSobremi;
import com.portfolioAP.portfolioAP.models.Sobremi;
import com.portfolioAP.portfolioAP.services.SobremiService;
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
@RequestMapping("/sobremi")
@CrossOrigin(origins = "http://localhost:4200")
public class SobremiController {
    @Autowired SobremiService sobremiService;
    

    public SobremiController(SobremiService sobremiService){
        this.sobremiService = sobremiService;
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Sobremi> getById(@PathVariable("id") Long id){
        if(!sobremiService.existsById(id)){
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        
        Sobremi sobremi = sobremiService.getOne(id).get();
        return new ResponseEntity(sobremi,HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> editSobremi(@PathVariable("id") Long id, @RequestBody dtoSobremi dtoSobremi){
        if(!sobremiService.existsById(id))
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        
        Sobremi sobremi = sobremiService.getOne(id).get();
        sobremi.setDescripcion(dtoSobremi.getDescSobremi());
        
        sobremiService.addSobremi(sobremi);
        return new ResponseEntity(sobremi, HttpStatus.OK);
        
    }
    
    @GetMapping("/all")
    public ResponseEntity<List<Sobremi>> obtenerSobremi(){
        List<Sobremi> sobremis= sobremiService.list();
        return new ResponseEntity<>(sobremis, HttpStatus.OK);
    }
         
    @PostMapping("/add")
    public ResponseEntity<Sobremi> addSobremi(@RequestBody dtoSobremi dtoSobremi){
        Sobremi nuevaSobremi=new Sobremi(dtoSobremi.getDescSobremi());
        sobremiService.addSobremi(nuevaSobremi);
        return new ResponseEntity<>(nuevaSobremi,HttpStatus.CREATED);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteSobremi(@PathVariable("id") Long id){
        sobremiService.deleteSobremi(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
