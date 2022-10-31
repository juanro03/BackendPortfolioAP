
package com.portfolioAP.portfolioAP.Interface.Dto;

import javax.validation.constraints.NotBlank;


public class dtoSkill {
    @NotBlank
    private String nombre;
    private int porcentaje;

    public dtoSkill() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(int porcentaje) {
        this.porcentaje = porcentaje;
    }
    
    
    
}
