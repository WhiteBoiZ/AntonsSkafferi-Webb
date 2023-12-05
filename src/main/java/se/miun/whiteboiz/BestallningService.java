package se.miun.whiteboiz;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import se.miun.whiteboiz.entities.BestallningEntity;

import java.util.List;


@ApplicationScoped
@Named
@Transactional
public class BestallningService {
    @PersistenceContext
    private EntityManager em;

    public List<BestallningEntity> findAllBestallningar(){
        return em.createQuery("select B from BestallningEntity B ", BestallningEntity.class).getResultList();
    }
}
