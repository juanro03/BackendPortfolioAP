package com.portfolioAP.portfolioAP.services;

import com.portfolioAP.portfolioAP.models.Educacion;
import com.portfolioAP.portfolioAP.repository.EducacionRepo;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class EducacionService {
    @Autowired EducacionRepo educacionRepo;
    
    public List<Educacion> list(){
        return educacionRepo.findAll();
    }
    
    public Optional<Educacion> getOne(Long id){
        return educacionRepo.findById(id);
    }
    
    public void addEducacion(Educacion edu){
        educacionRepo.save(edu);
    }
    
    public void deleteEducacion(Long id){
        educacionRepo.deleteById(id);
    }
    
    public boolean existsById(Long id){
        return educacionRepo.existsById(id);
    }
}
