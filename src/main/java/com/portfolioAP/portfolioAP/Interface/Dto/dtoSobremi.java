
package com.portfolioAP.portfolioAP.Interface.Dto;

import javax.validation.constraints.NotBlank;

public class dtoSobremi {
    @NotBlank
    private String descSobremi;

    public dtoSobremi() {
    }

    public dtoSobremi(String descSobremi) {
        this.descSobremi = descSobremi;
    }

    public String getDescSobremi() {
        return descSobremi;
    }

    public void getDescSobremi(String descSobremi) {
        this.descSobremi = descSobremi;
    }
    
    
}
