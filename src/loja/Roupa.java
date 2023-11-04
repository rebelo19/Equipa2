package loja;

import javax.persistence.Entity;

@Entity
public class Roupa extends Produto {

    private String tamanho;

	public String getTamanho() {
		return tamanho;
	}

	public void setTamanho(String tamanho) {
		this.tamanho = tamanho;
	}

}