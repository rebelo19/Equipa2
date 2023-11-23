package loja;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

/**
 * Classe de serviço que fornece operações relacionadas a produtos no banco de dados.
 */
public class ProdutoService {

    /**
     * Gestor de entidades para interagir com o banco de dados.
     */
    protected EntityManager em;

    /**
     * Construtor que recebe um EntityManager como parâmetro.
     */
    public ProdutoService(EntityManager em) {
        this.em = em;
    }

    /**
     * Métodos para realizar operações de CRUD no banco de dados.
     */
    public Produto updateProduto(Produto produto) {
        if (produto.getId() == null) {
            em.persist(produto);
        } else {
            produto = em.merge(produto);
        }
        return produto;
    }

    public void removeProduto(Produto produto) {
        produto = em.merge(produto);
        em.remove(produto);
    }

    public Produto findProdutoById(Long id) {
        return em.find(Produto.class, id);
    }

    @SuppressWarnings("unchecked")
    public List<Produto> findAllProdutos() {
        Query query = em.createQuery("SELECT p FROM Produto p");
        return query.getResultList();
    }

    @SuppressWarnings("unchecked")
    public List<Roupa> findAllRoupas() {
        Query query = em.createQuery("SELECT r FROM Roupa r");
        return query.getResultList();
    }

    @SuppressWarnings("unchecked")
    public List<Acessorios> findAllAcessorios() {
        Query query = em.createQuery("SELECT a FROM Acessorios a");
        return query.getResultList();
    }

    @SuppressWarnings("unchecked")
    public List<Beleza> findAllBeleza() {
        Query query = em.createQuery("SELECT b FROM Beleza b");
        return query.getResultList();
    }

    @SuppressWarnings("unchecked")
    public List<Casa> findAllCasa() {
        Query query = em.createQuery("SELECT c FROM Casa c");
        return query.getResultList();
    }
}