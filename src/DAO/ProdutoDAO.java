/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import br.edu.ifsp.pep.modelo.Produto;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 *
 * @author Henry Cavalcante
 */
public class ProdutoDAO {
    private EntityManagerFactory emf;
    
    public ProdutoDAO() {
        this.emf = Persistence
            .createEntityManagerFactory("aula1PU");
    }
    
    private EntityManager getEntityManager() { 
        return this.emf.createEntityManager();
    }
    
    public void inserir(Produto produto) {
        EntityManager em = getEntityManager();
        
        em.getTransaction().begin();
        em.persist(produto);
        em.getTransaction().commit();
        
        em.close();
    }
    
    public void alterar(Produto produto) {
        EntityManager em = getEntityManager();
        
        em.getTransaction().begin();
        em.merge(produto);
        em.getTransaction().commit();
        
        em.close();
    }
    
    public List<Produto> listar() {
        EntityManager em = getEntityManager();
        
        TypedQuery<Produto> query = em.createQuery("SELECT p FROM Produto p", Produto.class);

        return query.getResultList();
    }
}