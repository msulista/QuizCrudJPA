/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import javax.persistence.EntityManager;
import model.Turma;
import util.JpaUtil;

/**
 *
 * @author marcus.rodrigues
 */
public class TurmaDaoBd implements InterfaceDao<Turma>{

   @Override
    public void inserir(Turma bean) { //To change body of generated methods, choose Tools | Templates.
        try {
            EntityManager em = JpaUtil.getEntityManager();
            em.getTransaction().begin();
            
            if(bean.getId() == null){
                em.persist(bean);
            }else{
                em.merge(bean);
            }
            
            em.getTransaction().commit();
            em.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deletar(Turma bean) {//To change body of generated methods, choose Tools | Templates.
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
    public void atualizar(Turma bean) { //To change body of generated methods, choose Tools | Templates.
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
        List<Turma> listaTurma = em.createQuery("SELECT q FROM Turma q").getResultList();
        em.close();
        return (listaTurma);
    }
    
}
