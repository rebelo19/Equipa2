package Lojinha;
/**
 * A classe Roupa representa um produto que é uma peça de roupa, herda da classe Produto.
 */
public class Roupa extends Produto {
	
	 private String tamanho;

	    /**
	     * Construtor da classe Roupa.
	     *
	     * @param nome    O nome da roupa.
	     * @param preco   O preço da roupa.
	     * @param tamanho O tamanho da roupa.
	     */
	 public Roupa(String tamanho,String nome, double preco) {
			super(nome, preco);
			this.tamanho = tamanho;
	 }

	    /**
	     * Obtém o tamanho da roupa.
	     *
	     * @return O tamanho da roupa.
	     */
	 public String getTamanho() {
	        return tamanho;
	    }

		/**
		 * @param nome
		 * @param preco
		 */
		public Roupa(String nome, double preco) {
			super(nome, preco);
			// TODO Auto-generated constructor stub
		}

		/**
		 * 
		 */
		
}
