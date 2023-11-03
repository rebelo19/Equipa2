package Lojinha;


	/**
	 * A classe Acessorio representa um produto que é um acessório, herda da classe Produto.
	 */
	public class Acessorio extends Produto {
	    
	    private String material;

	    /**
	     * Construtor da classe Acessorio.
	     *
	     * @param nome     O nome do acessório.
	     * @param preco    O preço do acessório.
	     * @param material O material do qual o acessório é feito, como por exemplo "couro" ou "metal".
	     */
	    public Acessorio(String nome, double preco, String material) {
	        super(nome, preco);
	        this.material = material;
	    }

	    /**
	     * Obtém o material do acessório.
	     *
	     * @return O material do qual o acessório é feito, como por exemplo "couro" ou "metal".
	     */
	    public String getMaterial() {
	        return material;
	    }
	}


