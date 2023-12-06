package se.miun.whiteboiz;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import se.miun.whiteboiz.entities.*;

import java.util.List;


@ApplicationScoped
@Named
@Transactional
public class BestallningService {
    @PersistenceContext
    private EntityManager em;
    public BestallningEntity findBestallning(int id){
        return em.find(BestallningEntity.class, id);
    }

    public List<BestallningEntity> findAllBestallningar(){
        return em.createQuery("select B from BestallningEntity B ", BestallningEntity.class).getResultList();
    }
    public void addBestallning(String datum, String tid, String kommentar, int bordId) {
        BestallningEntity bestallning = new BestallningEntity();
        bestallning.setDatum(datum);
        bestallning.setTid(tid);
        bestallning.setKommentar(kommentar);
        bestallning.setBordId(em.find(BordEntity.class, bordId));
        em.persist(bestallning);
    }

    public void deleteBestallning(int bestallningId) {
        BestallningEntity bestallning = em.find(BestallningEntity.class, bestallningId);
        em.remove(bestallning);
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

    public List<RattInstansEntity> findRattInstansByBestallningId(int bestallningId){
        return em.createQuery("select R from RattInstansEntity R where R.bestallningId.id = :bestallningId", RattInstansEntity.class)
                .setParameter("bestallningId", bestallningId)
                .getResultList();
    }

    public void addRattInstans(int tagId, int bestallningId, int alacarteId, String rattPreferenser) {
        RattInstansEntity rattInstans = new RattInstansEntity();
        rattInstans.setTagId(em.find(TypEntity.class, tagId));
        rattInstans.setBestallningId(em.find(BestallningEntity.class, bestallningId));
        rattInstans.setAlacarteId(em.find(AlacarteEntity.class, alacarteId));
        rattInstans.setRattPreferenser(rattPreferenser);
        em.persist(rattInstans);
    }


}
