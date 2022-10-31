
package com.portfolioAP.portfolioAP.repository;

import com.portfolioAP.portfolioAP.models.Experiencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExperienciaRepo extends JpaRepository<Experiencia,Long>{
    
}
