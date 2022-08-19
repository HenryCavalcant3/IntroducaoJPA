import DAO.CategoriaDAO;
import DAO.ProdutoDAO;
import br.edu.ifsp.pep.modelo.Categoria;
import java.util.List;

import br.edu.ifsp.pep.modelo.Produto;
import java.math.BigDecimal;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class TesteProdutoCategoria {
    public static void main(String[] args) {
        Categoria categoria = new Categoria();
        categoria.setDescricao("Informatica");
        
        CategoriaDAO categoriaDAO = new CategoriaDAO();
        categoriaDAO.inserir(categoria);

        Produto produto = new Produto();
        produto.setDescricao("Teclado");
        produto.setPreco(new BigDecimal(60.0));
        produto.setQuantidade(100);

        produto.setCategoria(categoria);

        ProdutoDAO produtoDAO = new ProdutoDAO();
        produtoDAO.inserir(produto);
        
        List<Produto> produtos = produtoDAO.listar();

        for(Produto p : produtos) {
            System.out.println("Descricao: " + p.getDescricao());
        }
        
        System.out.println("teste");
    }
}