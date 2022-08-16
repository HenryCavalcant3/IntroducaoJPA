import java.util.List;

import br.edu.ifsp.pep.modelo.Produto;

public class TesteProdutoCategoria {
    public static void main(String[] args) {
        Persistence em = Persistence
            .createEntityManagerFactory("aulaPU")
            .createEntityManager();

        Categoria categoria = new Categoria();
        categoria.setDescricao("Informatica");

        Produto produto = new Produto();
        produto.setDescricao("Teclado");
        produto.setPreco(new BigDecimal(60.0));
        produto.setQuantidade(100);

        produto.setCategoria(categoria);

        em.getTransaction().begin();
        em.persist(categoria);
        em.persist(produto);
        em.getTransaction().commit();
        
       TypedQuery<Produto> query = em.createQuery("SELECT p FROM Produto p", Produto.class);

        List<Produto> produtos = query.getResultList();

        for(Produto p : produtos) {
            System.out.println("Descricao: " + p.getDescricao());
        }

        em.close();
    }
}