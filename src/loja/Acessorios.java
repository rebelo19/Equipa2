package loja;

import javax.persistence.Entity;

/**
 * Classe que representa um produto do tipo Acessorios na loja. Herda da classe Produto.
 */

@Entity
public class Acessorios extends Produto {

	/**
	 * Atributos.
	 */
    private String material;

    /**
     * Getters e setters.
     */
	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

}