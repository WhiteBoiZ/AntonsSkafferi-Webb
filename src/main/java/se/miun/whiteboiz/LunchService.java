package se.miun.whiteboiz;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import se.miun.whiteboiz.entities.LunchEntity;

import java.util.List;

@ApplicationScoped @Named @Transactional
public class LunchService {
    @PersistenceContext
    private EntityManager em;

    public LunchEntity findLunch(int id){
        return em.find(LunchEntity.class, id);
    }
    public List<LunchEntity> findAllLunches(){
        return em.createQuery("select L from LunchEntity L", LunchEntity.class).getResultList();
    }
}
