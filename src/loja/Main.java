package loja;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Classe principal que contém o método main para executar o programa e realizar operações CRUD em uma loja.
 */
public class Main {

    public static void main(String[] args) {
        // Configurar o EntityManager e a fábrica EntityManager
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("LibraryLoja");
        EntityManager em = emf.createEntityManager();
        ProdutoService produtoService = new ProdutoService(em);
        StockService stockService = new StockService(em);

        try {
            /**
             * Iniciar uma transação para operações no banco de dados.
             */
            em.getTransaction().begin();

            /**
             * Inserir produtos na base de dados.
             */

            // Roupa
            Roupa camisaAzul = new Roupa();
            camisaAzul.setNome("Camisa Azul");
            camisaAzul.setPreco(9.99);
            camisaAzul.setTamanho("M");

            Roupa calcasGanga = new Roupa();
            calcasGanga.setNome("Calças Ganga");
            calcasGanga.setPreco(19.99);
            calcasGanga.setTamanho("34");

            // Acessórios
            Acessorios relogio = new Acessorios();
            relogio.setNome("Relógio Swatch");
            relogio.setPreco(99.99);
            relogio.setMaterial("Metal");

            Acessorios oculosDeSol = new Acessorios();
            oculosDeSol.setNome("Óculos de Sol");
            oculosDeSol.setPreco(5.99);
            oculosDeSol.setMaterial("Plástico");

            // Beleza
            Beleza perfume = new Beleza();
            perfume.setNome("Invictus");
            perfume.setPreco(49.99);
            perfume.setTipo("Perfume");

            Beleza batomVermelho = new Beleza();
            batomVermelho.setNome("Batom Vermelho");
            batomVermelho.setPreco(2.99);
            batomVermelho.setTipo("Maquilhagem");

            // Casa
            Casa almofada = new Casa();
            almofada.setNome("Almofada Comprida");
            almofada.setPreco(19.99);
            almofada.setParaRecolhaNaLoja(true);

            Casa conjuntoPanelas = new Casa();
            conjuntoPanelas.setNome("Conjunto de Panelas");
            conjuntoPanelas.setPreco(65.99);
            conjuntoPanelas.setParaRecolhaNaLoja(false);

            /**
             * Persistir produtos na base de dados.
             */
            produtoService.updateProduto(camisaAzul);
            produtoService.updateProduto(calcasGanga);
            produtoService.updateProduto(relogio);
            produtoService.updateProduto(oculosDeSol);
            produtoService.updateProduto(perfume);
            produtoService.updateProduto(batomVermelho);
            produtoService.updateProduto(almofada);
            produtoService.updateProduto(conjuntoPanelas);

            /**
             * Confirmar as alterações na transação.
             */
            em.getTransaction().commit();

            /**
             * Persistir informações de estoque na base de dados.
             */
            stockService.addStock(camisaAzul, 33);
            stockService.addStock(relogio, 20);
            stockService.addStock(conjuntoPanelas, 12);
            stockService.addStock(almofada, 7);
            stockService.addStock(batomVermelho, 65);

            /**
             * Listar produtos por categorias.
             */
            List<Roupa> roupas = produtoService.findAllRoupas();
            List<Acessorios> acessorios = produtoService.findAllAcessorios();
            List<Beleza> beleza = produtoService.findAllBeleza();
            List<Casa> casa = produtoService.findAllCasa();

            System.out.println("");
            System.out.println("------ PRODUTOS DISPONÍVEIS NA LOJA ------");
            System.out.println("");

            /**
             * Listar roupas disponíveis.
             */
            System.out.println("ROUPAS:");
            for (Roupa roupa : roupas) {
                int quantidadeDisponivel = stockService.getQuantidadeDisponivel(roupa);
                System.out.println(roupa.getNome() + " - Tamanho: " + roupa.getTamanho() + " - Preço: €" + roupa.getPreco() + " - Quantidade Disponível: " + quantidadeDisponivel);
            }
            System.out.println("-------------------------");

            /**
             * Listar acessórios disponíveis.
             */
            System.out.println("ACESSÓRIOS:");
            for (Acessorios acessorio : acessorios) {
                int quantidadeDisponivel = stockService.getQuantidadeDisponivel(acessorio);
                System.out.println(acessorio.getNome() + " - Material: " + acessorio.getMaterial() + " - Preço: €" + acessorio.getPreco() + " - Quantidade Disponível: " + quantidadeDisponivel);
            }
            System.out.println("-------------------------");

            /**
             * Listar produtos de beleza disponíveis.
             */
            System.out.println("PRODUTOS DE BELEZA:");
            for (Beleza produtoBeleza : beleza) {
                int quantidadeDisponivel = stockService.getQuantidadeDisponivel(produtoBeleza);
                System.out.println(produtoBeleza.getNome() + " - Tipo: " + produtoBeleza.getTipo() + " - Preço: €" + produtoBeleza.getPreco() + " - Quantidade Disponível: " + quantidadeDisponivel);
            }
            System.out.println("-------------------------");

            /**
             * Listar produtos para casa disponíveis.
             */
            System.out.println("PRODUTOS PARA CASA:");
            for (Casa produtoCasa : casa) {
                int quantidadeDisponivel = stockService.getQuantidadeDisponivel(produtoCasa);
                System.out.println(produtoCasa.getNome() + " - Para Recolha na Loja: " + produtoCasa.isParaRecolhaNaLoja() + " - Preço: €" + produtoCasa.getPreco() + " - Quantidade Disponível: " + quantidadeDisponivel);
            }

            /**
             * Exemplo de compra.
             */
            System.out.println("");
            System.out.println("");
            System.out.println("------ EXEMPLO DE COMPRA -------");
            System.out.println("");

            /**
             * Adicionar produtos ao carrinho de compras.
             */
            Carrinho carrinho = new Carrinho();
            carrinho.adicionarProduto(camisaAzul, 1);
            carrinho.adicionarProduto(relogio, 1);
            carrinho.adicionarProduto(conjuntoPanelas, 3);

            /**
             * Remover produtos do carrinho de compras.
             */
            carrinho.removerProduto(camisaAzul);

            /**
             * Listar produtos no carrinho de compras.
             */
            System.out.println("Produtos no carrinho de compras:");
            carrinho.listarProdutos();

            /**
             * Finalizar a compra.
             */
            double totalCompra = carrinho.calcularTotal();
            System.out.println("Total da compra: €" + totalCompra);
            carrinho.finalizarCompra();

            /**
             * Consultar quantidade disponível de um produto específico.
             */
            int quantidadeCamisaAzul = stockService.getQuantidadeDisponivel(camisaAzul);
            System.out.println("Quantidade disponível de Camisa Azul: " + quantidadeCamisaAzul);

            /**
             * Listar quantidades disponíveis de todos os produtos.
             */
            List<Stock> quantidadesDisponiveis = stockService.listarQuantidadesDisponiveis();
            for (Stock stock : quantidadesDisponiveis) {
                System.out.println("Produto: " + stock.getProduto().getNome() + ", Quantidade disponível: " + stock.getQuantidade());
            }

        } catch (Exception e) {
            // Em caso de erro, realizar rollback na transação e imprimir a stack trace.
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {

            /**
             * Fechar EntityManager e EntityManagerFactory.
             */
            em.close();
            emf.close();
        }

    }

}