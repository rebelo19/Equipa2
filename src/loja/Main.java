package loja;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("LibraryLoja");
        EntityManager em = emf.createEntityManager();
        ProdutoService produtoService = new ProdutoService(em);

        try {
            // Iniciar uma transação
            em.getTransaction().begin();

            // APAGADO ESTE MÉTODO QUE SERVIA PARA APAGAR DADOS, 08/11 em.createQuery("DELETE FROM Produto").executeUpdate();

            // Inserir novos produtos
            // Roupas
            Roupa camisaazul = new Roupa();
            camisaazul.setNome("Camisa Azul");
            camisaazul.setPreco(9.99);
            camisaazul.setTamanho("M");
            produtoService.updateProduto(camisaazul);

            Roupa calcasganga = new Roupa();
            calcasganga.setNome("Calças Ganga");
            calcasganga.setPreco(19.99);
            calcasganga.setTamanho("34");
            produtoService.updateProduto(calcasganga);

            // Acessórios
            Acessorios relogio = new Acessorios();
            relogio.setNome("Relógio Swatch");
            relogio.setPreco(99.99);
            relogio.setMaterial("Metal");
            produtoService.updateProduto(relogio);

            Acessorios oculosDeSol = new Acessorios();
            oculosDeSol.setNome("Óculos de Sol");
            oculosDeSol.setPreco(5.99);
            oculosDeSol.setMaterial("Plástico");
            produtoService.updateProduto(oculosDeSol);

            // Beleza
            Beleza perfume = new Beleza();
            perfume.setNome("Invictus");
            perfume.setPreco(49.99);
            perfume.setTipo("Perfume");
            produtoService.updateProduto(perfume);

            Beleza batomVermelho = new Beleza();
            batomVermelho.setNome("Batom Vermelho");
            batomVermelho.setPreco(2.99);
            batomVermelho.setTipo("Maquilhagem");
            produtoService.updateProduto(batomVermelho);

            // Casa
            Casa almofada = new Casa();
            almofada.setNome("Almofada Comprida");
            almofada.setPreco(19.99);
            almofada.setParaRecolhaNaLoja(true);
            produtoService.updateProduto(almofada);

            Casa conjuntoPanelas = new Casa();
            conjuntoPanelas.setNome("Conjunto de Panelas");
            conjuntoPanelas.setPreco(99.99);
            conjuntoPanelas.setParaRecolhaNaLoja(false);
            produtoService.updateProduto(conjuntoPanelas);

            // Commitar a transação
            em.getTransaction().commit();

            // Listar produtos por categorias
            List<Roupa> roupas = produtoService.findAllRoupas();
            List<Acessorios> acessorios = produtoService.findAllAcessorios();
            List<Beleza> beleza = produtoService.findAllBeleza();
            List<Casa> casa = produtoService.findAllCasa();

            System.out.println("");
            System.out.println("------ PRODUTOS DISPONÍVEIS NA LOJA ------");
            System.out.println("");

            // Listar roupas
            System.out.println("ROUPAS:");
            for (Roupa roupa : roupas) {
                System.out.println(roupa.getNome() + " - Tamanho: " + roupa.getTamanho());
            }
            System.out.println("-------------------------");

            // Listar acessórios
            System.out.println("ACESSÓRIOS:");
            for (Acessorios acessorio : acessorios) {
                System.out.println(acessorio.getNome() + " - Material: " + acessorio.getMaterial());
            }
            System.out.println("-------------------------");

            // Listar produtos de beleza
            System.out.println("PRODUTOS DE BELEZA:");
            for (Beleza produtoBeleza : beleza) {
                System.out.println(produtoBeleza.getNome() + " - Tipo: " + produtoBeleza.getTipo());
            }
            System.out.println("-------------------------");

            // Listar produtos de casa
            System.out.println("PRODUTOS PARA CASA:");
            for (Casa produtoCasa : casa) {
                System.out.println(produtoCasa.getNome() + " - Para Recolha na Loja: " + produtoCasa.isParaRecolhaNaLoja());
            }
            
            System.out.println("");
            System.out.println("");
            System.out.println("------ EXEMPLO DE COMPRA -------");
            System.out.println("");
            
            // Adicionar produtos ao carrinho
            Carrinho carrinho = new Carrinho();
            carrinho.adicionarProduto(camisaazul);
            carrinho.adicionarProduto(relogio);
            carrinho.adicionarProduto(conjuntoPanelas);

            // Remover produto do carrinho
            carrinho.removerProduto(camisaazul);

            // Listar produtos no carrinho
            System.out.println("Produtos no carrinho:");
            carrinho.listarProdutos();

            // Finalizar a compra
            double totalCompra = carrinho.calcularTotal();
            System.out.println("Total da compra: €" + totalCompra);
            carrinho.finalizarCompra();
            
        } catch (Exception e) {
            // Se ocorrer algum erro, fazer rollback na transação
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            // Fechar o EntityManager e o EntityManagerFactory
            em.close();
            emf.close();
        }
    }
}