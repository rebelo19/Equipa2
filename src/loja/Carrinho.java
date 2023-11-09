package loja;

import java.util.ArrayList;

/**
 * Classe que representa um carrinho de compras.
 * Nota: Esta classe não precisa de anotações persistência, porque é apenas uma estrutura de dados temporária para armazenar os produtos selecionados durante a execução do programa.
 */
 
public class Carrinho {
	
	/**
     * Lista de produtos no carrinho.
     */
	private ArrayList<Produto> produtos;

	/**
     * Construtor para inicializar o carrinho.
     */
    public Carrinho() {
        this.produtos = new ArrayList<>();
    }

    /**
     * Adiciona um produto ao carrinho.
     *
     * @param produto Produto a ser adicionado ao carrinho.
     */
    public void adicionarProduto(Produto produto) {
        produtos.add(produto);
        System.out.println(produto.getNome() + " adicionado ao carrinho.");
    }

    /**
     * Remove um produto do carrinho.
     *
     * @param produto Produto a ser removido do carrinho.
     */
    public void removerProduto(Produto produto) {
        produtos.remove(produto);
        System.out.println(produto.getNome() + " removido do carrinho.");
    }

    /**
     * Lista os produtos no carrinho.
     */
    public void listarProdutos() {
        for (Produto produto : produtos) {
            System.out.println(produto.getNome());
        }
    }

    /**
     * Calcula o total do carrinho.
     *
     * @return O total dos preços dos produtos no carrinho.
     */
    public double calcularTotal() {
        double total = 0;
        for (Produto produto : produtos) {
            total += produto.getPreco();
        }
        return total;
    }

    /**
     * Finaliza a compra e mostra uma mensagem de agradecimento.
     */
    public void finalizarCompra() {
        System.out.println("Compra finalizada. Obrigado por comprar conosco!");
    }
}