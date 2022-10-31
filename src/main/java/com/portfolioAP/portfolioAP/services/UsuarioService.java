
package com.portfolioAP.portfolioAP.services;

import com.portfolioAP.portfolioAP.models.Usuario;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.portfolioAP.portfolioAP.repository.UsuarioRepo;
import java.util.Optional;

@Service
@Transactional
public class UsuarioService{
    @Autowired UsuarioRepo usuarioRepo;
    
    public List<Usuario> list(){
        return usuarioRepo.findAll();
    }
    
    public Optional<Usuario> getOne(int id){
        return usuarioRepo.findById(id);
    }
    
    public Optional<Usuario> getByNombre(String nombre){
        return usuarioRepo.findByNombre(nombre);
    }
    
    public void addUsuario(Usuario usuario){
        usuarioRepo.save(usuario);
    }
    
    public void deleteUsuario(int id){
        usuarioRepo.deleteById(id);
    }
    
    public boolean existsById(int id){
        return usuarioRepo.existsById(id);
    }
    
    public boolean existsByNombre(String nombre){
        return usuarioRepo.existsByNombre(nombre);
    }
}
