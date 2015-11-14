/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author marcus.rodrigues
 */
public class JpaUtil {
    
    public static  EntityManagerFactory emf;
//    static {emf = Persistence.createEntityManagerFactory("ExemploPU");}

    public static EntityManager getEntityManager(){
        emf = Persistence.createEntityManagerFactory("ExemploPU");
        return emf.createEntityManager();
    }
    
    public static void close(){
        emf.close();
    }
}
