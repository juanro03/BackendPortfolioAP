package com.portfolioAP.portfolioAP.Interface.Dto;

import javax.validation.constraints.NotBlank;

public class dtoExperiencia {

    @NotBlank
    private String descExp;

    public dtoExperiencia() {
    }

    public dtoExperiencia(String descExp) {
        this.descExp = descExp;
    }
    

    public String getDescExp() {
        return descExp;
    }

    public void setDescExp(String descExp) {
        this.descExp = descExp;
    }


}
