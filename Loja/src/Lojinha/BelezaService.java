package proj;

import javax.persistence.EntityManager;
import java.util.List;

public class BelezaService {
    private EntityManager em;

    public BelezaService(EntityManager em) {
        this.em = em;
    }

    public void adicionarBeleza(Beleza beleza) {
        em.getTransaction().begin();
        em.persist(beleza);
        em.getTransaction().commit();
    }

    public void removerBeleza(Long id) {
        em.getTransaction().begin();
        Beleza beleza = em.find(Beleza.class, id);
        if (beleza != null) {
            em.remove(beleza);
        }
        em.getTransaction().commit();
    }

    public Beleza encontrarBelezaPorId(Long id) {
        return em.find(Beleza.class, id);
    }

    public List<Beleza> listarBelezas() {
        return em.createQuery("SELECT b FROM Beleza b", Beleza.class).getResultList();
    }
}