package loja;

import javax.persistence.Entity;

/**
 * Classe que representa um produto do tipo Casa na loja. Herda da classe Produto.
 */

@Entity
public class Casa extends Produto {

	/**
	 * Atributos.
	 */
    private boolean paraRecolhaNaLoja;

    /**
     * Getters e setters.
     */
	public boolean isParaRecolhaNaLoja() {
		return paraRecolhaNaLoja;
	}

	public void setParaRecolhaNaLoja(boolean paraRecolhaNaLoja) {
		this.paraRecolhaNaLoja = paraRecolhaNaLoja;
	}

}