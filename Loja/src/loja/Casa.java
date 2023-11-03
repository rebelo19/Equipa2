package loja;

import javax.persistence.Entity;

@Entity
public class Casa extends Produto {

    private boolean paraRecolhaNaLoja;

	public boolean isParaRecolhaNaLoja() {
		return paraRecolhaNaLoja;
	}

	public void setParaRecolhaNaLoja(boolean paraRecolhaNaLoja) {
		this.paraRecolhaNaLoja = paraRecolhaNaLoja;
	}

}