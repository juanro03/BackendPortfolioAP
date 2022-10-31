package com.portfolioAP.portfolioAP.services;

import com.portfolioAP.portfolioAP.models.Sobremi;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.portfolioAP.portfolioAP.repository.SobremiRepo;
import java.util.Optional;

@Service
@Transactional
public class SobremiService {
    @Autowired SobremiRepo sobremiRepo;

    public List<Sobremi> list() {
        return sobremiRepo.findAll();
    }

    public void addSobremi(Sobremi sobremi) {
        sobremiRepo.save(sobremi);
    }

    public Optional<Sobremi> getOne(Long id) {
        return sobremiRepo.findById(id);
    }
    
        public void deleteSobremi(Long id){
        sobremiRepo.deleteById(id);
    }

    public boolean existsById(Long id) {
        return sobremiRepo.existsById(id);
    }
}
