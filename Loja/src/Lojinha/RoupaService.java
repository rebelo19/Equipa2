package proj;

import javax.persistence.EntityManager;
import java.util.List;

public class RoupaService {
    private EntityManager em;

    public RoupaService(EntityManager em) {
        this.em = em;
    }

    public void adicionarRoupa(Roupa roupa) {
        em.getTransaction().begin();
        em.persist(roupa);
        em.getTransaction().commit();
    }

    public void removerRoupa(Long id) {
        em.getTransaction().begin();
        Roupa roupa = em.find(Roupa.class, id);
        if (roupa != null) {
            em.remove(roupa);
        }
        em.getTransaction().commit();
    }

    public Roupa encontrarRoupaPorId(Long id) {
        return em.find(Roupa.class, id);
    }

    public List<Roupa> listarRoupas() {
        return em.createQuery("SELECT r FROM Roupa r", Roupa.class).getResultList();
    }
}