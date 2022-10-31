
package com.portfolioAP.portfolioAP.Interface.Dto;

import javax.validation.constraints.NotBlank;


public class dtoUsuario {
    @NotBlank
    private String nombre;
    @NotBlank
    private String imagenUsuario;
    @NotBlank
    private String bannerUsuario;
    @NotBlank
    private String descUsuario;
    @NotBlank
    private String ubiUsuario;

    public dtoUsuario() {
    }

    public dtoUsuario(String nombre, String imagenUsuario, String bannerUsuario, String descUsuario, String ubiUsuario) {
        this.nombre = nombre;
        this.imagenUsuario = imagenUsuario;
        this.bannerUsuario = bannerUsuario;
        this.descUsuario = descUsuario;
        this.ubiUsuario = ubiUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getImagenUsuario() {
        return imagenUsuario;
    }

    public void setImagenUsuario(String imagenUsuario) {
        this.imagenUsuario = imagenUsuario;
    }

    public String getBannerUsuario() {
        return bannerUsuario;
    }

    public void setBannerUsuario(String bannerUsuario) {
        this.bannerUsuario = bannerUsuario;
    }

    public String getDescUsuario() {
        return descUsuario;
    }

    public void setDescUsuario(String descUsuario) {
        this.descUsuario = descUsuario;
    }

    public String getUbiUsuario() {
        return ubiUsuario;
    }

    public void setUbiUsuario(String ubiUsuario) {
        this.ubiUsuario = ubiUsuario;
    }
    
    
}
