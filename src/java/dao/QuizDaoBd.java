/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import javax.persistence.EntityManager;
import model.Quiz;
import util.JpaUtil;

/**
 *
 * @author marcus.rodrigues
 */
public class QuizDaoBd implements InterfaceDao<Quiz>{

    @Override
    public void inserir(Quiz bean) { //To change body of generated methods, choose Tools | Templates.
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
    public void deletar(Quiz bean) {//To change body of generated methods, choose Tools | Templates.
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
    public void atualizar(Quiz bean) { //To change body of generated methods, choose Tools | Templates.
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
        List<Quiz> listaQuiz = em.createQuery("SELECT q FROM Quiz q").getResultList();
        em.close();
        return (listaQuiz);
    }
    
}
