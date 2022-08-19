/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import br.edu.ifsp.pep.modelo.Categoria;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 *
 * @author Henry Cavalcante
 */
public class CategoriaDAO {
    private EntityManagerFactory emf;
    
    public CategoriaDAO() {
        this.emf = Persistence
            .createEntityManagerFactory("aula1PU");
    }
    
    private EntityManager getEntityManager() { 
        return this.emf.createEntityManager();
    }
    
    public void inserir(Categoria categoria) {
        EntityManager em = getEntityManager();
        
        em.getTransaction().begin();
        em.persist(categoria);
        em.getTransaction().commit();
        
        em.close();
    }
    
    public void alterar(Categoria categoria) {
        EntityManager em = getEntityManager();
        
        em.getTransaction().begin();
        em.merge(categoria);
        em.getTransaction().commit();
        
        em.close();
    }
    
    public List<Categoria> listar() {
        EntityManager em = getEntityManager();
        
        TypedQuery<Categoria> query = em.createQuery("SELECT c FROM Categoria c", Categoria.class);

        return query.getResultList();
    }
}
