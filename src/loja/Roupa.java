package loja;

import javax.persistence.Entity;

/**
 * Classe que representa um produto do tipo Roupa na loja. Herda da classe Produto.
 */

@Entity
public class Roupa extends Produto {

	/**
     * Atributos.
     */
    private String tamanho;

    /**
     * Getters e setters.
     */
	public String getTamanho() {
		return tamanho;
	}

	public void setTamanho(String tamanho) {
		this.tamanho = tamanho;
	}

}