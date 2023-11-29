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
     * Método para atualizar ou adicionar um produto no banco de dados.
     */
    public Produto updateProduto(Produto produto) {
        if (produto.getId() == null) {
            em.persist(produto);

            // Criar novo registo no Stock ao adicionar um novo produto
            Stock novoStock = new Stock();
            novoStock.setProduto(produto);
            novoStock.setQuantidade(0); // Definir a quantidade inicial como 0
            em.persist(novoStock);

            produto.setStock(novoStock);
        } else {
            produto = em.merge(produto);
        }
        return produto;
    }

    /**
     * Método para remover um produto no banco de dados.
     */
    public void removeProduto(Produto produto) {
        produto = em.merge(produto);
        em.remove(produto);
    }

    /**
     * Método para encontrar um produto no banco de dados pelo id.
     */
    public Produto findProdutoById(Long id) {
        return em.find(Produto.class, id);
    }

    /**
     * Método para obter uma lista de todos os produtos no banco de dados.
     */   
    @SuppressWarnings("unchecked")
    public List<Produto> findAllProdutos() {
        Query query = em.createQuery("SELECT p FROM Produto p");
        return query.getResultList();
    }

    /**
     * Método para obter uma lista de todas as roupas no banco de dados.
     */
    @SuppressWarnings("unchecked")
    public List<Roupa> findAllRoupas() {
        Query query = em.createQuery("SELECT r FROM Roupa r");
        return query.getResultList();
    }
    
    /**
     * Método para obter uma lista de todos os acessórios no banco de dados.
     */
    @SuppressWarnings("unchecked")
    public List<Acessorios> findAllAcessorios() {
        Query query = em.createQuery("SELECT a FROM Acessorios a");
        return query.getResultList();
    }

    /**
     * Método para obter uma lista de todos os itens de beleza no banco de dados.
     */
    @SuppressWarnings("unchecked")
    public List<Beleza> findAllBeleza() {
        Query query = em.createQuery("SELECT b FROM Beleza b");
        return query.getResultList();
    }

    /**
     * Método para obter uma lista de todos os itens para casa no banco de dados.
     */
    @SuppressWarnings("unchecked")
    public List<Casa> findAllCasa() {
        Query query = em.createQuery("SELECT c FROM Casa c");
        return query.getResultList();
    }
    
}