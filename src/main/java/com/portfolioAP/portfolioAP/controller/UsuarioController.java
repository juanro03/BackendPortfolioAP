
package com.portfolioAP.portfolioAP.controller;

import com.portfolioAP.portfolioAP.Interface.Dto.dtoUsuario;
import com.portfolioAP.portfolioAP.models.Usuario;
import com.portfolioAP.portfolioAP.services.UsuarioService;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "https://portfolioap-auth.web.app")
public class UsuarioController{
    @Autowired UsuarioService usuarioService;
    
    public UsuarioController(UsuarioService usuarioService){
        this.usuarioService = usuarioService;
    }
    
    @GetMapping("/usuario/all")
    public ResponseEntity<List<Usuario>> obtenerUsuario(){
        List<Usuario> usuarios= usuarioService.list();
        return new ResponseEntity<>(usuarios, HttpStatus.OK);
    }
    
    @GetMapping("/usuario/detail/{id}")
    public ResponseEntity<Usuario> getById(@PathVariable("id") int id){
        if(!usuarioService.existsById(id)){
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        
        Usuario usuario = usuarioService.getOne(id).get();
        return new ResponseEntity(usuario,HttpStatus.OK);
    }
    
    @PutMapping("/usuario/update/{id}")
    public ResponseEntity<?> editUsuario(@PathVariable("id") int id, @RequestBody dtoUsuario dtousuario){
        
        if(!usuarioService.existsById(id))
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        
        if(StringUtils.isBlank(dtousuario.getNombre())){
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(dtousuario.getImagenUsuario())){
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(dtousuario.getBannerUsuario())){
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(dtousuario.getDescUsuario())){
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(dtousuario.getUbiUsuario())){
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        
        Usuario usuario = usuarioService.getOne(id).get();
        
        usuario.setNombre(dtousuario.getNombre());
        usuario.setImagenUsuario(dtousuario.getImagenUsuario());
        usuario.setBannerUsuario(dtousuario.getBannerUsuario());
        usuario.setDescUsuario(dtousuario.getDescUsuario());
        usuario.setUbiUsuario(dtousuario.getUbiUsuario());
        
        usuarioService.addUsuario(usuario);
        return new ResponseEntity(usuario, HttpStatus.OK);
        
    }
    
    
    
    /*@PostMapping("/add")
    public ResponseEntity<Usuario> addUsuario(@RequestBody dtoUsuario dtoEdu){
        Usuario nuevaUsuario=new Usuario(dtoEdu.getDescEdu());
        usuarioService.addUsuario(nuevaUsuario);
        return new ResponseEntity<>(nuevaUsuario,HttpStatus.CREATED);
    }
    /*
    
    /*@DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteUsuario(@PathVariable("id") Long id){
        usuarioService.deleteUsuario(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    */
    
}
