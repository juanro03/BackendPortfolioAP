
package com.portfolioAP.portfolioAP.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Experiencia{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idExp;
    private String descExp;

    public Experiencia() {
    }

    public Experiencia(String descExp) {
        this.descExp = descExp;
    }

    public Long getIdExp() {
        return idExp;
    }

    public void setIdExp(Long idExp) {
        this.idExp = idExp;
    }

    public String getDescExp() {
        return descExp;
    }

    public void setDescExp(String descExp) {
        this.descExp = descExp;
    }

}
