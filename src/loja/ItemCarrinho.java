package loja;

/**
 * Classe que representa um item no carrinho de compras.
 */
public class ItemCarrinho {
	
    private Produto produto;
    private int quantidade;

    /**
     * Construtor para inicializar um ItemCarrinho com um produto e quantidade.
     */
    public ItemCarrinho(Produto produto, int quantidade) {
        this.produto = produto;
        this.quantidade = quantidade;
    }

    /**
     * Getters e setters.
     */
	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
    
}