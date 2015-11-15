/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositorio;

import dao.UsuarioDaoBd;
import java.util.ArrayList;
import java.util.List;
import model.Usuario;

/**
 *
 * @author marcus.rodrigues
 */
public class UsuarioRepositorio {
    
    private UsuarioDaoBd usuarioDaoBd;

    public UsuarioRepositorio() {
        this.usuarioDaoBd = new UsuarioDaoBd();
    }
    
    public void addUsuario(Usuario usuario){
        
       this.usuarioDaoBd.inserir(usuario);
    }

    public void editar(Usuario usuario){
        this.editar(usuario);
    }
    
    public List<Usuario> getUsuarios() {
        return usuarioDaoBd.listar();
    }
    
    public void deletaUsuario(Usuario usuario){
        this.usuarioDaoBd.deletar(usuario);
    }
    
        
}
