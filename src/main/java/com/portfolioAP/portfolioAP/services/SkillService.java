
package com.portfolioAP.portfolioAP.services;

import com.portfolioAP.portfolioAP.models.Skill;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.portfolioAP.portfolioAP.repository.SkillRepo;
import java.util.Optional;

@Service
@Transactional
public class SkillService {
    @Autowired SkillRepo skillRepo;

    public List<Skill> list() {
        return skillRepo.findAll();
    }

    public Optional<Skill> getOne(Long id) {
        return skillRepo.findById(id);
    }

    public void addSkill(Skill edu) {
        skillRepo.save(edu);
    }

    public void deleteSkill(Long id) {
        skillRepo.deleteById(id);
    }

    public boolean existsById(Long id) {
        return skillRepo.existsById(id);
    }
}
