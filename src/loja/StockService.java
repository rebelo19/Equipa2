package loja;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;

/**
 * Classe que gere operações relacionadas com o stock na loja.
 */
public class StockService {
    private EntityManager entityManager;

    /**
     * Construtor que recebe um EntityManager como parâmetro.
     */
    public StockService(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    /**
     * Adiciona ou atualiza o stock de um produto na loja.
     */
    public void addOrUpdateStock(Produto produto, int quantidade) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        Stock stock = getStock(produto);

        if (stock == null) {
            // Se o produto não existir no stock, cria um novo registo no stock.
            stock = new Stock();
            stock.setProduto(produto);
            stock.setQuantidade(quantidade);
            entityManager.persist(stock);
        } else {
            // Se o produto já existir no stock, atualiza a quantidade existente.
            stock.setQuantidade(stock.getQuantidade() + quantidade);
            entityManager.merge(stock);
        }

        transaction.commit();
    }

    /**
     * Atualiza a quantidade disponível no stock para um produto específico.
     */
    public void updateStock(Produto produto, int newQuantidade) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        Stock stock = getStock(produto);

        if (stock != null) {
            stock.setQuantidade(newQuantidade);
        }

        transaction.commit();
    }

    /**
     * Obtém o registo de stock associado a um produto específico.
     */
    public Stock getStock(Produto produto) {
        return entityManager.find(Stock.class, produto.getId());
    }

    /**
     * Obtém uma lista de todos os registos de stock na loja.
     */
    public List<Stock> getAllStock() {
        Query query = entityManager.createQuery("SELECT s FROM Stock s", Stock.class);
        return query.getResultList();
    }

    /**
     * Obtém a quantidade disponível no stock para um produto específico.
     */
    public int getQuantidadeDisponivel(Produto produto) {
        Stock stock = getStock(produto);
        return (stock != null) ? stock.getQuantidade() : 0;
    }
}