package proj;

import javax.persistence.EntityManager;
import java.util.List;

public class AcessorioService {
    private EntityManager em;

    public AcessorioService(EntityManager em) {
        this.em = em;
    }

    public void adicionarAcessorio(Acessorio acessorio) {
        em.getTransaction().begin();
        em.persist(acessorio);
        em.getTransaction().commit();
    }

    public void removerAcessorio(Long id) {
        em.getTransaction().begin();
        Acessorio acessorio = em.find(Acessorio.class, id);
        if (acessorio != null) {
            em.remove(acessorio);
        }
        em.getTransaction().commit();
    }

    public Acessorio encontrarAcessorioPorId(Long id) {
        return em.find(Acessorio.class, id);
    }

    public List<Acessorio> listarAcessorios() {
        return em.createQuery("SELECT a FROM Acessorio a", Acessorio.class).getResultList();
    }
}