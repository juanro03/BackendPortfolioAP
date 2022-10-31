
package com.portfolioAP.portfolioAP.Interface.Dto;

import javax.validation.constraints.NotBlank;

public class dtoEducacion{
    @NotBlank
    private String descEdu;

    public dtoEducacion() {
    }

    public dtoEducacion(String descEdu) {
        this.descEdu = descEdu;
    }

    public String getDescEdu() {
        return descEdu;
    }

    public void setDescEdu(String descEdu) {
        this.descEdu = descEdu;
    }


}
