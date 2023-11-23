package loja;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Classe que representa um carrinho de compras.
 */
public class Carrinho {
    private List<ItemCarrinho> itens;

    /**
     * Construtor para inicializar um carrinho vazio.
     */
    public Carrinho() {
        this.itens = new ArrayList<>();
    }

    /**
     * Adiciona um produto ao carrinho com uma determinada quantidade.
     * Exibe uma mensagem de erro se a quantidade for menor ou igual a zero.
     */
    public void adicionarProduto(Produto produto, int quantidade) {
        if (quantidade <= 0) {
            System.out.println("Erro: A quantidade deve ser maior que zero. Por favor, corrija.");
            return;
        }

        ItemCarrinho item = new ItemCarrinho(produto, quantidade);
        itens.add(item);

        System.out.println(quantidade + "x " + produto.getNome() + " adicionado ao carrinho.");
    }

    /**
     * Remove um produto do carrinho.
     */
    public void removerProduto(Produto produto) {
        ItemCarrinho itemToRemove = null;
        for (ItemCarrinho item : itens) {
            if (item.getProduto().equals(produto)) {
                itemToRemove = item;
                break;
            }
        }

        if (itemToRemove != null) {
            itens.remove(itemToRemove);
            System.out.println(produto.getNome() + " removido do carrinho.");
        } else {
            System.out.println("Erro: Produto não encontrado no carrinho.");
        }
    }

    /**
     * Lista os produtos no carrinho.
     */
    public void listarProdutos() {
        for (ItemCarrinho item : itens) {
            Produto produto = item.getProduto();
            int quantidade = item.getQuantidade();
            System.out.println(produto.getNome() + " - Quantidade: " + quantidade);
        }
    }

    /**
     * Calcula o total do carrinho para apresentar ao cliente, previamente à opção de colocar código de desconto.
     */
    public double calcularTotal() {
        double total = 0;
        for (ItemCarrinho item : itens) {
            Produto produto = item.getProduto();
            int quantidade = item.getQuantidade();
            total += produto.getPreco() * quantidade;
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
        } else {
            System.out.println("Erro: Código de desconto inválido, tente novamente.");
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
        } else {
            System.out.println("Compra cancelada. Obrigado por visitar nossa loja!");
        }
    }
}