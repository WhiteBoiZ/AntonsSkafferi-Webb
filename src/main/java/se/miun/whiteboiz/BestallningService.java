package se.miun.whiteboiz;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import se.miun.whiteboiz.entities.BestallningEntity;
import se.miun.whiteboiz.entities.RattInstansEntity;
import se.miun.whiteboiz.entities.RattInstansEntityPK;

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
    public BestallningEntity findBestallning(int id){
        return em.find(BestallningEntity.class, id);
    }

    public List<RattInstansEntity> findAllRattInstans(){
        return em.createQuery("select R from RattInstansEntity R", RattInstansEntity.class).getResultList();
    }

    public RattInstansEntity findRattInstans(int id, int alacarteId, int bestallningId){
        RattInstansEntityPK pk = new RattInstansEntityPK();
        pk.setId(id);
        pk.setAlacarteId(alacarteId);
        pk.setBestallningId(bestallningId);

        // Use the primary key when calling find
        return em.find(RattInstansEntity.class, pk);
    }
}
