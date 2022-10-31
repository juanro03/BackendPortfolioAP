
package com.portfolioAP.portfolioAP.repository;

import com.portfolioAP.portfolioAP.models.Skill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SkillRepo extends JpaRepository<Skill,Long>{
    
}
