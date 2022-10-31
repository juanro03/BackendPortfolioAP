
package com.portfolioAP.portfolioAP.models;

import com.sun.istack.NotNull;
import java.util.List;
import javax.persistence.*;

@Entity
public class Usuario{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idUser;
    
    @NotNull
    private String nombre;
    @NotNull
    private String imagenUsuario;
    @NotNull
    private String bannerUsuario;
    @NotNull
    private String descUsuario;
    @NotNull
    private String ubiUsuario;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "idEdu")
    private List<Educacion> educacionList;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "idExp")
    private List<Experiencia> experienciaList;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "idSkill")
    private List<Skill> skillList;

    public Usuario() {
    }

    public Usuario(int idUser, String nombre, String imagenUsuario, String bannerUsuario, String descUsuario, String ubiUsuario) {
        this.idUser = idUser;
        this.nombre = nombre;
        this.imagenUsuario = imagenUsuario;
        this.bannerUsuario = bannerUsuario;
        this.descUsuario = descUsuario;
        this.ubiUsuario = ubiUsuario;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
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
