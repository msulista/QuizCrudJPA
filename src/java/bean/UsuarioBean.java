/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.util.List;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import model.Usuario;
import repositorio.UsuarioRepositorio;

/**
 *
 * @author marcus.rodrigues
 */
@ManagedBean(eager = true)
@ApplicationScoped
public class UsuarioBean {
    
    private UsuarioRepositorio usuarioRepositorio;
    private Usuario usuarioSelecionado;
    private Usuario usuarioConfirmacao;
    
    public UsuarioBean() {
        this.usuarioRepositorio = new UsuarioRepositorio();
        this.usuarioSelecionado = new Usuario(); 
    }

    public UsuarioRepositorio getUsuarioRepositorio() {
        return usuarioRepositorio;
    }

    public void setUsuarioRepositorio(UsuarioRepositorio usuarioRepositorio) {
        this.usuarioRepositorio = usuarioRepositorio;
    }

    public Usuario getUsuarioSelecionado() {
        return usuarioSelecionado;
    }

    public void setUsuarioSelecionado(Usuario usuarioSelecionado) {
        this.usuarioSelecionado = usuarioSelecionado;
    }

    
    //Cadastro Usuario    
    
    public String criaUsuario(){ 
        adicionaUsuario(); 
        usuarioConfirmacao = usuarioSelecionado;
        limpaCadastro();
        return "confirmacaoCadastro?faces-redirect=true";
    }
    
    public void adicionaUsuario(){
        this.usuarioRepositorio.addUsuario(usuarioSelecionado);
    }
    
    public String confirmacaoCadastro(){
        return "Usuário " + usuarioConfirmacao.getNome() + " cadastrado com sucesso!!!";
    }
    
    public void limpaCadastro(){
        usuarioSelecionado = new Usuario();
    }
    
    //Editar
    public String editaUsuario(Usuario usuario){
        this.usuarioSelecionado = usuario;
        this.usuarioRepositorio.editar(usuario);
        return "editaAdmin?faces-redirect=true";
    }
//    public String atualizaUsuario(){
//        return "confirmacaoCadastro?faces-redirect=true";
//    }
    public String removeUsuario(Usuario usuario){        
        usuarioRepositorio.deletaUsuario(usuario);
        return "/faces/index.xhtml";
    }
    
    
    public  List<Usuario> getUsuarios(){        
        return usuarioRepositorio.getUsuarios();
    }

    
    
    //Login
//    public String validaUser(){
//        
//        for (Usuario user : usuarioRepositorio.getUsuarios()) {
//            if(user.getEmail().equalsIgnoreCase(email)){
//                if(user.getKey().equalsIgnoreCase(key)){
//                    return "validaUser";
//                }else{
//                    FacesContext context = FacesContext.getCurrentInstance();
//                    FacesMessage menMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR,
//                                                        "Senha incorreta!",
//                                                        "Verifique a senha digitada!!");
//                    context.addMessage(null, menMessage);
//                    return "";
//                }
//            }
//        }
//        return "";
//    }
    
}
