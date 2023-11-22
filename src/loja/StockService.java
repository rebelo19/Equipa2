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

    public StockService(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void addStock(Produto produto, int quantidade) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        Stock stock = getStock(produto);
        if (stock == null) {
            stock = new Stock();
            stock.setProduto(produto);
            entityManager.persist(stock);
        }
        stock.setQuantidade(stock.getQuantidade() + quantidade);

        transaction.commit();
    }

    public void updateStock(Produto produto, int newQuantidade) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        Stock stock = getStock(produto);
        if (stock != null) {
            stock.setQuantidade(newQuantidade);
        }

        transaction.commit();
    }

    public Stock getStock(Produto produto) {
        return entityManager.find(Stock.class, produto.getId());
    }

    public List<Stock> getAllStock() {
        Query query = entityManager.createQuery("SELECT s FROM Stock s", Stock.class);
        return query.getResultList();
    }
}