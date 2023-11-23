package loja;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Classe que representa um carrinho de compras.
 */
public class Carrinho {

	/**
     * Lista de produtos no carrinho.
     */
    private ArrayList<Produto> produtos;
    private String codigoDesconto;
    private static final double DESCONTO_LP = 0.15;

    /**
     * Construtor para inicializar o carrinho.
     */
    public Carrinho() {
        this.produtos = new ArrayList<>();
        this.codigoDesconto = "";
    }

    /**
     * Adiciona um produto ao carrinho.
     */
    public void adicionarProduto(Produto produto) {
        produtos.add(produto);
        System.out.println(produto.getNome() + " adicionado ao carrinho.");
    }

    /**
     * Remove um produto do carrinho.
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
     */
    public double calcularTotal() {
        double total = 0;
        for (Produto produto : produtos) {
            total += produto.getPreco();
        }
        return total;
    }

    /**
     * Finaliza a compra, perguntando ao cliente se deseja aplicar um código de desconto.
     * Se inserido o código "DESCONTOLP", aplica um desconto de 15% sobre o valor final.
     * Exibe os valores com desconto (se aplicável) e apresenta mensagem de agradecimento.
     */
    public void finalizarCompra() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Deseja finalizar a compra? (sim/não)");
        String resposta = scanner.nextLine().toLowerCase();

        if ("sim".equals(resposta)) {
            System.out.println("Possui um código de desconto? (insira o código ou deixe em branco)");
            codigoDesconto = scanner.nextLine();
            double totalFinal = calcularTotalComDesconto();
            System.out.println("Valor final da compra: €" + totalFinal);
            System.out.println("Obrigado por comprar conosco!");
        
        } else {
            System.out.println("Compra cancelada. Obrigado por visitar a nossa loja!");
        }
    }

    /**
     * Calcula o total do carrinho aplicando desconto se um código válido for inserido.
     */
    private double calcularTotalComDesconto() {
        double total = calcularTotal();
        if ("DESCONTOLP".equals(codigoDesconto)) {
            double desconto = total * DESCONTO_LP;
            total -= desconto;
            System.out.println("Valor com desconto aplicado (15%): €" + desconto);
            System.out.println("Valor final da compra com desconto: €" + total);
        }
        return total;
    }
}