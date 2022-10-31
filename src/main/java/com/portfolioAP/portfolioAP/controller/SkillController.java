package com.portfolioAP.portfolioAP.controller;

import com.portfolioAP.portfolioAP.Interface.Dto.dtoSkill;
import com.portfolioAP.portfolioAP.models.Skill;
import com.portfolioAP.portfolioAP.services.SkillService;
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
@RequestMapping("/skill")
@CrossOrigin(origins = "http://localhost:4200")
public class SkillController {
    @Autowired SkillService skillService;
    

    public SkillController(SkillService skillService){
        this.skillService = skillService;
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Skill> getById(@PathVariable("id") Long id){
        if(!skillService.existsById(id)){
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        
        Skill skill = skillService.getOne(id).get();
        return new ResponseEntity(skill,HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> editSkill(@PathVariable("id") Long id, @RequestBody dtoSkill dtoSkill){
        if(!skillService.existsById(id))
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        
        Skill skill = skillService.getOne(id).get();
        skill.setPorcentaje(dtoSkill.getPorcentaje());
        skill.setNombre(dtoSkill.getNombre());
        
        skillService.addSkill(skill);
        return new ResponseEntity(skill, HttpStatus.OK);
        
    }
    
    @GetMapping("/all")
    public ResponseEntity<List<Skill>> obtenerSkills(){
        List<Skill> skills= skillService.list();
        return new ResponseEntity<>(skills, HttpStatus.OK);
    }
    
    @PostMapping("/add")
    public ResponseEntity<Skill> addSkill(@RequestBody dtoSkill dtoSkill){
        Skill nuevaSkill=new Skill(dtoSkill.getNombre(), dtoSkill.getPorcentaje());
        
        skillService.addSkill(nuevaSkill);
        return new ResponseEntity<>(nuevaSkill,HttpStatus.CREATED);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteSkill(@PathVariable("id") Long id){
        skillService.deleteSkill(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
