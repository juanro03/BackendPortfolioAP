
package com.portfolioAP.portfolioAP.repository;

import com.portfolioAP.portfolioAP.models.Sobremi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SobremiRepo extends JpaRepository<Sobremi,Long>{
    
}
