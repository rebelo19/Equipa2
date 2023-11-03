package proj;

import javax.persistence.EntityManager;
import java.util.List;

public class ProdutoService {
    private EntityManager em;

    public ProdutoService(EntityManager em) {
        this.em = em;
    }

    public void adicionarProduto(Produto produto) {
        em.getTransaction().begin();
        em.persist(produto);
        em.getTransaction().commit();
    }

    public void removerProduto(Long id) {
        em.getTransaction().begin();
        Produto produto = em.find(Produto.class, id);
        if (produto != null) {
            em.remove(produto);
        }
        em.getTransaction().commit();
    }

    public Produto encontrarProdutoPorId(Long id) {
        return em.find(Produto.class, id);
    }

    public List<Produto> listarProdutos() {
        return em.createQuery("SELECT p FROM Produto p", Produto.class).getResultList();
    }

    public double calcularTotal() {
        List<Produto> produtos = listarProdutos();
        double total = 0;
        for (Produto produto : produtos) {
            total += produto.getPreco();
        }
        return total;
    }
}