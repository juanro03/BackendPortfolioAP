
package com.portfolioAP.portfolioAP.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Sobremi {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idSobremi;
    private String descSobremi;

    public Sobremi() {
    }
    
    public Sobremi(String descSobremi) {
        this.descSobremi = descSobremi;
    }

    public Long getIdSobremi() {
        return idSobremi;
    }

    public void setIdSobremi(Long idSobremi) {
        this.idSobremi = idSobremi;
    }

    public String getdescSobremi() {
        return descSobremi;
    }

    public void setDescripcion(String descSobremi) {
        this.descSobremi = descSobremi;
    }
    
    
}
