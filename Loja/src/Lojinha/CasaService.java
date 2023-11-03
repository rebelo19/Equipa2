package proj;

import javax.persistence.EntityManager;
import java.util.List;

public class CasaService {
    private EntityManager em;

    public CasaService(EntityManager em) {
        this.em = em;
    }

    public void adicionarCasa(Casa casa) {
        em.getTransaction().begin();
        em.persist(casa);
        em.getTransaction().commit();
    }

    public void removerCasa(Long id) {
        em.getTransaction().begin();
        Casa casa = em.find(Casa.class, id);
        if (casa != null) {
            em.remove(casa);
        }
        em.getTransaction().commit();
    }

    public Casa encontrarCasaPorId(Long id) {
        return em.find(Casa.class, id);
    }

    public List<Casa> listarCasas() {
        return em.createQuery("SELECT c FROM Casa c", Casa.class).getResultList();
    }
}