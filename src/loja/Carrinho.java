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
     *
     * @param produto    O produto a ser adicionado ao carrinho.
     * @param quantidade A quantidade do produto a ser adicionada ao carrinho.
     */
    public void adicionarProduto(Produto produto, int quantidade) {
        if (quantidade <= 0) {
            System.out.println("Erro: A quantidade deve ser maior que zero. Por favor, corrija.");
            return;
        }

        ItemCarrinho item = new ItemCarrinho(produto, quantidade);
        itens.add(item);

        String mensagem = (quantidade > 1)
                ? quantidade + " " + produto.getNome() + " adicionados ao carrinho."
                : quantidade + " " + produto.getNome() + " adicionado ao carrinho.";

        System.out.println(mensagem);
    }

    /**
     * Remove um produto do carrinho.
     */
    public void removerProduto(Produto produto) {
        for (ItemCarrinho item : itens) {
            if (item.getProduto().equals(produto)) {
                itens.remove(item);
                System.out.println(produto.getNome() + " removido do carrinho.");
                return;
            }
        }
        System.out.println("Produto não encontrado no carrinho.");
    }

    /**
     * Lista os produtos no carrinho.
     */
    public void listarProdutos() {
        for (ItemCarrinho item : itens) {
            System.out.println(item.getQuantidade() + " " + item.getProduto().getNome());
        }
    }

    /**
     * Calcula o total do carrinho.
     */
    public double calcularTotal() {
        double total = 0;
        for (ItemCarrinho item : itens) {
            total += item.getProduto().getPreco() * item.getQuantidade();
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
            System.out.println("Código de desconto inválido ou não aplicável.");
            return total;
        }
    }

    /**
     * Aplica descontos automáticos com base na quantidade de produtos no carrinho.
     */
    public void aplicarDescontosAutomaticos() {
        int quantidadeProdutos = itens.size();

        if (quantidadeProdutos >= 5) {
            aplicarDesconto(0.20); // 20% de desconto para 5 ou mais produtos
        } else if (quantidadeProdutos >= 3) {
            aplicarDesconto(0.10); // 10% de desconto para 3 ou mais produtos
        }
    }

    private void aplicarDesconto(double percentualDesconto) {
        double desconto = calcularTotal() * percentualDesconto;
        double totalComDesconto = calcularTotal() - desconto;

        System.out.println("Desconto aplicado: " + (percentualDesconto * 100) + "%");
        System.out.println("Total da compra (com desconto): €" + totalComDesconto);
    }

    /**
     * Finaliza a compra, solicitando ao cliente se deseja finalizar a compra e se possui um código de desconto.
     * Apresenta mensagens de agradecimento e o valor final a ser pago.
     */
    public void finalizarCompra() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Deseja finalizar a compra? (Digite 'sim' ou 'nao')");
        String resposta = scanner.nextLine();
        if ("sim".equalsIgnoreCase(resposta)) {
            System.out.println("Possui um código de desconto? (Digite o código ou deixe em branco)");
            String codigoDesconto = scanner.nextLine();

            // Aplica descontos automáticos antes de calcular o total com desconto
            aplicarDescontosAutomaticos();

            double totalFinal = calcularTotalComDesconto(codigoDesconto);
            System.out.println("Obrigado por comprar conosco!");
            System.out.println("Valor final a ser pago: €" + totalFinal);
        } else {
            System.out.println("Compra cancelada. Obrigado por visitar nossa loja!");
        }
    }
}