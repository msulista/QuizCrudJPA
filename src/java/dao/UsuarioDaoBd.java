/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import javax.persistence.EntityManager;
import model.Usuario;
import util.JpaUtil;

/**
 *
 * @author marcus.rodrigues
 */
public class UsuarioDaoBd implements InterfaceDao<Usuario>{  
    

    @Override
    public void inserir(Usuario bean) {
            System.out.println("Teste1");
            EntityManager em = JpaUtil.getEntityManager();
            System.out.println("Test2");
            em.getTransaction().begin();
            
            if(bean.getId()== null){
            em.persist(bean);
            }else{
                em.merge(bean);
            }
                
            em.getTransaction().commit();
            em.close();  
    }

    @Override
    public void deletar(Usuario bean) {
    
        EntityManager em = JpaUtil.getEntityManager();
        em.getTransaction().begin(); 
        
        em.remove(em.merge(bean));
        em.getTransaction().commit();
        
        em.close();        
    }

    @Override
    public void atualizar(Usuario bean) {
    
       
    }

    @Override
    public List listar() {
        
        EntityManager em = JpaUtil.getEntityManager();
        List<Usuario> listaUsuario = em.createQuery("SELECT u FROM Usuario u").getResultList();
        em.close();
        return (listaUsuario);
    }
}
