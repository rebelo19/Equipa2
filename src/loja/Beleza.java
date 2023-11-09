package loja;

import javax.persistence.Entity;

/**
 * Classe que representa um produto do tipo Beleza na loja. Herda da classe Produto.
 */

@Entity
public class Beleza extends Produto {

	/**
	 * Atributos.
	 */
    private String tipo;

    /**
     * Getters e setters.
     */
	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

}