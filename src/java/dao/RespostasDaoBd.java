/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import javax.persistence.EntityManager;
import model.Resposta;
import util.JpaUtil;

/**
 *
 * @author marcus.rodrigues
 */
public class RespostasDaoBd implements InterfaceDao<Resposta>{
    
    @Override
    public void inserir(Resposta bean) { //To change body of generated methods, choose Tools | Templates.
        try {
            EntityManager em = JpaUtil.getEntityManager();
            em.getTransaction().begin();
                      
            em.persist(bean);
           
            
            em.getTransaction().commit();
            em.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deletar(Resposta bean) {//To change body of generated methods, choose Tools | Templates.
        try {
            EntityManager em = JpaUtil.getEntityManager();
            em.getTransaction().begin();
            
            em.remove(em.merge(bean));
            
            em.getTransaction().commit();
            em.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void atualizar(Resposta bean) { //To change body of generated methods, choose Tools | Templates.
       try {
            EntityManager em = JpaUtil.getEntityManager();
            em.getTransaction().begin();
            
            em.merge(bean);
                        
            em.getTransaction().commit();
            em.close();
        } catch (Exception e) {
            e.printStackTrace();
        }        
    }

    @Override
    public List listar() {//To change body of generated methods, choose Tools | Templates.
        EntityManager em = JpaUtil.getEntityManager();        
        List<Resposta> listaResposta = em.createQuery("SELECT r FROM Resposta r").getResultList();
        em.close();
        return (listaResposta);
    }
}
