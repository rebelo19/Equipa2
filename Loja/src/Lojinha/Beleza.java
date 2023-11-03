package Lojinha;


public class Beleza extends Produto {
	    
	    private String tipo;

	    /**
	     * Construtor da classe Beleza.
	     *
	     * @param nome O nome do produto de beleza.
	     * @param preco O preço do produto de beleza.
	     * @param tipo O tipo do produto de beleza, como por exemplo "maquiagem" ou "creme facial".
	     */
	    public Beleza(String nome, double preco, String tipo) {
	        super(nome, preco);
	        this.tipo = tipo;
	    }

	    /**
	     * Obtém o tipo do produto de beleza.
	     *
	     * @return O tipo do produto de beleza, como por exemplo "maquiagem" ou "creme facial".
	     */
	    public String getTipo() {
	        return tipo;
	    }

}
