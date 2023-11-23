package loja;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Classe que representa um carrinho de compras.
 * Nota: Esta classe não precisa de anotações de persistência, porque é apenas uma estrutura de dados temporária para armazenar os produtos selecionados durante a execução do programa.
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
     * Calcula o total do carrinho com desconto, tendo em conta a aplicação do código de desconto.
     */
    public double calcularTotalComDesconto(String codigoDesconto) {
        double total = calcularTotal();

        if ("DESCONTOLP".equals(codigoDesconto)) {
            double desconto = 0.15; // 15% de desconto
            double valorDesconto = total * desconto;
            double totalComDesconto = total - valorDesconto;

            System.out.println("Desconto aplicado: 15%");
            System.out.println("Total da compra (com desconto): €" + totalComDesconto);
            return totalComDesconto;
        } 
        else {
            System.out.println("Código de desconto inválido ou não aplicável.");
            return total;
        }
    }

    /**
     * Finaliza a compra, solicitando ao cliente se deseja finalizar a compra e se possui um código de desconto.
     * Exibe mensagens de agradecimento e o valor final a ser pago.
     */
    public void finalizarCompra() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Deseja finalizar a compra? (Digite 'sim' ou 'nao')");
        String resposta = scanner.nextLine();
        if ("sim".equalsIgnoreCase(resposta)) {
            System.out.println("Você possui um código de desconto? (Digite o código ou deixe em branco)");
            String codigoDesconto = scanner.nextLine();
            double totalFinal = calcularTotalComDesconto(codigoDesconto);
            System.out.println("Obrigado por comprar conosco!");
            System.out.println("Valor final a ser pago: €" + totalFinal);
        } 
        else {
            System.out.println("Compra cancelada. Obrigado por visitar nossa loja!");
        }
    
    }
    
}