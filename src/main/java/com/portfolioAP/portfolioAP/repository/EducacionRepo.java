
package com.portfolioAP.portfolioAP.repository;

import com.portfolioAP.portfolioAP.models.Educacion;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EducacionRepo extends JpaRepository<Educacion,Long>{
}
