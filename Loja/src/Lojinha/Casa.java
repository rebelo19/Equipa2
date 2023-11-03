package Lojinha;
/**
 * 
 */

/**
 * @author gonca
 *
 */
public class Casa extends Produto {
	
	private boolean paraRecolhaNaLoja;

    /**
     * Construtor da classe Casa.
     *
     * @param nome               O nome do produto para casa.
     * @param preco              O preço do produto para casa.
     * @param paraRecolhaNaLoja  Um indicador booleano que indica se o produto pode ser recolhido na loja (true) ou não (false).
     */
    public Casa(String nome, double preco, boolean paraRecolhaNaLoja) {
        super(nome, preco);
        this.paraRecolhaNaLoja = paraRecolhaNaLoja;
    }

    /**
     * Verifica se o produto para casa pode ser recolhido na loja.
     *
     * @return true se o produto pode ser recolhido na loja, false caso contrário.
     */
    public boolean isParaRecolhaNaLoja() {
        return paraRecolhaNaLoja;
    }

}
