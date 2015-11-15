/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import model.Usuario;
import repositorio.UsuarioRepositorio;

/**
 *
 * @author marcus.rodrigues
 */
@ManagedBean
@SessionScoped
public class LoginMB {    
    
    private String email;
    private String senha;
    
    private Usuario usuarioLogado;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Usuario getUsuarioLogado() {
        return usuarioLogado;
    }

    public void setUsuarioLogado(Usuario usuarioLogado) {
        this.usuarioLogado = usuarioLogado;
    }
    
    public boolean logadoOn(){
        return (usuarioLogado != null);
    }
    public boolean eAdmin(){
        return (this.logadoOn() && this.getUsuarioLogado().getAdmin());
    }
    
    public String verificaLogin(){
        
        FacesContext context = FacesContext.getCurrentInstance();
        UsuarioBean usuarioBean = (UsuarioBean) context.getExternalContext().getApplicationMap().get("usuarioBean");
        List<Usuario> usuarios = usuarioBean.getUsuarios();
        
        for (Usuario usuario: usuarios){
            if(usuario.verificaLogin(email, senha)){
                usuarioLogado = usuario;
                if(usuario.getAdmin()){
                    return ("/admin/index?faces-redirect=true");
                }else{
                    return ("/usuario/index?faces-redirect=true");
                }
                
            }
        }
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                "Login inválido!", "Usuário ou senha não existem!");
        context.addMessage("idMessage", message);
        return ("/login");
    }
    
    public String logout(){
        usuarioLogado = null;
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return ("/faces/login");
    }
    
    //Editar
    public String editaUsuario(Usuario usuario){
        usuarioLogado = usuario;
        return "editaAdmin?faces-redirect=true";
    }
    public String atualizaUsuario(){
        return "index?faces-redirect=true";
    }
    public void removeUsuario(Usuario usuario){
        usuarioLogado = usuario;
        UsuarioBean ub = new UsuarioBean();
        ub.getUsuarioRepositorio().deletaUsuario(usuarioLogado);
        logout();
    }
}
