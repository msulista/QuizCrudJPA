/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositorio;

import java.util.ArrayList;
import java.util.List;
import model.Usuario;

/**
 *
 * @author marcus.rodrigues
 */
public class UsuarioRepositorio {
    
    private List<Usuario> usuarios;

    public UsuarioRepositorio() {
        
        this.usuarios = new ArrayList<>();
        //this.usuarios.add(new Usuario("Prof Marcus", "9588.7354", "mv@gmail.com", "1234", true));
        //this.usuarios.add(new Usuario("Dudu", "8126.4587", "dudu@gmail.com", "1234", false));
    }
    
    public void addUsuario(Usuario usuario){
        
       usuarios.add(usuario);
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }
    
    public void deletaUsuario(Usuario usuario){
        usuarios.remove(usuario);
    }
    
        
}
