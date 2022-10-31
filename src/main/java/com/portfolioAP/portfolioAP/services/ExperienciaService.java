
package com.portfolioAP.portfolioAP.services;


import com.portfolioAP.portfolioAP.models.Experiencia;
import com.portfolioAP.portfolioAP.repository.ExperienciaRepo;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ExperienciaService {
    @Autowired ExperienciaRepo experienciaRepo;
    
    public List<Experiencia> list(){
        return experienciaRepo.findAll();
    }
    
    public Optional<Experiencia> getOne(Long id){
        return experienciaRepo.findById(id);
    }
    
    public void addExperiencia(Experiencia edu){
        experienciaRepo.save(edu);
    }
    
    public void deleteExperiencia(Long id){
        experienciaRepo.deleteById(id);
    }
    
    public boolean existsById(Long id){
        return experienciaRepo.existsById(id);
    }
}
