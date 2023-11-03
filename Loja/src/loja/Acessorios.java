package loja;

import javax.persistence.Entity;

@Entity
public class Acessorios extends Produto {

    private String material;

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

}