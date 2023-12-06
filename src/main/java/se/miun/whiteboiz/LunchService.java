package se.miun.whiteboiz;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import se.miun.whiteboiz.entities.LunchEntity;
import se.miun.whiteboiz.entities.LunchVeckaEntity;
import se.miun.whiteboiz.entities.LunchVeckaEntityPK;

import java.util.List;

@ApplicationScoped @Named @Transactional
public class LunchService {
    @PersistenceContext
    private EntityManager em;

    public LunchEntity findLunch(int id){
        return em.find(LunchEntity.class, id);
    }
    public void deleteLunch(int lunchId) {
        LunchEntity lunch = em.find(LunchEntity.class, lunchId);
        em.remove(lunch);
    }

    public void addLunch(LunchEntity lunch) {
        em.persist(lunch);
    }

    public List<LunchEntity> findAllLunches(){
        return em.createQuery("select L from LunchEntity L", LunchEntity.class).getResultList();
    }

    public List<LunchVeckaEntity> findAllLunchesForWeek(){
        return em.createQuery("select L from LunchVeckaEntity L ", LunchVeckaEntity.class).getResultList();
    }

    public LunchVeckaEntity findLunchVecka(int dagId, int lunchId){
        LunchVeckaEntityPK pk = new LunchVeckaEntityPK();
        pk.setDagId(dagId);
        pk.setLunchId(lunchId);

        return em.find(LunchVeckaEntity.class, pk);
    }

}
