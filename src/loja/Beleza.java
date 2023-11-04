package loja;

import javax.persistence.Entity;

@Entity
public class Beleza extends Produto {

    private String tipo;

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

}