package loja;

import java.util.ArrayList;

// Nota: Esta classe não precisa de anotações persistência, porque é apenas uma estrutura de dados temporária para armazenar os produtos selecionados durante a execução do programa. 
public class Carrinho {
	private ArrayList<Produto> produtos;

    public Carrinho() {
        this.produtos = new ArrayList<>();
    }

    public void adicionarProduto(Produto produto) {
        produtos.add(produto);
        System.out.println(produto.getNome() + " adicionado ao carrinho.");
    }

    public void removerProduto(Produto produto) {
        produtos.remove(produto);
        System.out.println(produto.getNome() + " removido do carrinho.");
    }

    public void listarProdutos() {
        for (Produto produto : produtos) {
            System.out.println(produto.getNome());
        }
    }

    public double calcularTotal() {
        double total = 0;
        for (Produto produto : produtos) {
            total += produto.getPreco();
        }
        return total;
    }

    public void finalizarCompra() {
        System.out.println("Compra finalizada. Obrigado por comprar conosco!");
    }
}