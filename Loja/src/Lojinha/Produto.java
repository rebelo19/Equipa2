package Lojinha;
/**
	 * A classe Produto representa um produto com um nome e um preço.
	 */
	
	    
public class Produto {
	
	
	    
	    private String nome;
	    private double preco;

	    /**
	     * Construtor da classe Produto.
	     *
	     * @param nome  O nome do produto.
	     * @param preco O preço do produto.
	     */
	    public Produto(String nome, double preco) {
	        this.nome = nome;
	        this.preco = preco;
	    }

	    /**
	     * Obtém o nome do produto.
	     *
	     * @return O nome do produto.
	     */
	    public String getNome() {
	        return nome;
	    }

	    /**
	     * Obtém o preço do produto.
	     *
	     * @return O preço do produto.
	     */
	    public double getPreco() {
	        return preco;
	    }
}
