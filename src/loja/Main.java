package loja;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Classe principal que contém o método main para executar o programa. De acordo com CRUD.
 */
public class Main {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("LibraryLoja");
        EntityManager em = emf.createEntityManager();
        ProdutoService produtoService = new ProdutoService(em);
        StockService stockService = new StockService(em); // Adicione esta linha

        try {
            /**
             * Iniciar uma transação
             */
            em.getTransaction().begin();

            /**
             * Inserir produtos.
             */

            // Roupas
            Roupa camisaazul = new Roupa();
            camisaazul.setNome("Camisa Azul");
            camisaazul.setPreco(9.99);
            camisaazul.setTamanho("M");

            Roupa calcasganga = new Roupa();
            calcasganga.setNome("Calças Ganga");
            calcasganga.setPreco(19.99);
            calcasganga.setTamanho("34");

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
            conjuntoPanelas.setPreco(99.99);
            conjuntoPanelas.setParaRecolhaNaLoja(false);

            /**
             * Persistir produtos.
             */
            produtoService.updateProduto(camisaazul);
            produtoService.updateProduto(calcasganga);
            produtoService.updateProduto(relogio);
            produtoService.updateProduto(oculosDeSol);
            produtoService.updateProduto(perfume);
            produtoService.updateProduto(batomVermelho);
            produtoService.updateProduto(almofada);
            produtoService.updateProduto(conjuntoPanelas);

            /**
             * Dar commit da transação.
             */
            em.getTransaction().commit();

            /**
             * Dar commit da transação.
             */
            stockService.addStock(camisaazul, 50);
            stockService.addStock(relogio, 30);

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
             * Listar roupas.
             */
            System.out.println("ROUPAS:");
            for (Roupa roupa : roupas) {
                int quantidadeDisponivel = stockService.getQuantidadeDisponivel(roupa);
                System.out.println(roupa.getNome() + " - Tamanho: " + roupa.getTamanho() + " - Preço: €" + roupa.getPreco() + " - Quantidade Disponível: " + quantidadeDisponivel);
            }
            System.out.println("-------------------------");

            /**
             * Listar acessórios.
             */
            System.out.println("ACESSÓRIOS:");
            for (Acessorios acessorio : acessorios) {
                int quantidadeDisponivel = stockService.getQuantidadeDisponivel(acessorio);
                System.out.println(acessorio.getNome() + " - Material: " + acessorio.getMaterial() + " - Preço: €" + acessorio.getPreco() + " - Quantidade Disponível: " + quantidadeDisponivel);
            }
            System.out.println("-------------------------");

            /**
             * Listar produtos de beleza.
             */
            System.out.println("PRODUTOS DE BELEZA:");
            for (Beleza produtoBeleza : beleza) {
                int quantidadeDisponivel = stockService.getQuantidadeDisponivel(produtoBeleza);
                System.out.println(produtoBeleza.getNome() + " - Tipo: " + produtoBeleza.getTipo() + " - Preço: €" + produtoBeleza.getPreco() + " - Quantidade Disponível: " + quantidadeDisponivel);
            }
            System.out.println("-------------------------");
            
            /**
             * Listar produtos para casa.
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
        	 * Adicionar produtos ao carrinho.
        	 */
            Carrinho carrinho = new Carrinho();
            carrinho.adicionarProduto(camisaazul, 1);
            carrinho.adicionarProduto(relogio,1);
            carrinho.adicionarProduto(conjuntoPanelas, 3);

            /**
        	 * Remover produtos do carrinho.
        	 */
            carrinho.removerProduto(camisaazul);

            /**
        	 * Listar produtos no carrinho.
        	 */
            System.out.println("Produtos no carrinho:");
            carrinho.listarProdutos();

            /**
        	 * Finalizar a compra.
        	 */
            double totalCompra = carrinho.calcularTotal();
            System.out.println("Total da compra: €" + totalCompra);
            carrinho.finalizarCompra();

            /**
             * Consultar quantidade disponível de um produto.
             */
            int quantidadeCamisaAzul = stockService.getQuantidadeDisponivel(camisaazul);
            System.out.println("Quantidade disponível de Camisa Azul: " + quantidadeCamisaAzul);

            /**
             * Listar quantidades disponíveis de todos os produtos.
             */
            List<Stock> quantidadesDisponiveis = stockService.listarQuantidadesDisponiveis();
            for (Stock stock : quantidadesDisponiveis) {
                System.out.println("Produto: " + stock.getProduto().getNome() + ", Quantidade disponível: " + stock.getQuantidade());
            }

        } catch (Exception e) {
            // Se ocorrer algum erro, fazer rollback na transação
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {

            /**
             * Fechar o EntityManager e o EntityManagerFactory.
             */
            em.close();
            emf.close();
        }

    }

}