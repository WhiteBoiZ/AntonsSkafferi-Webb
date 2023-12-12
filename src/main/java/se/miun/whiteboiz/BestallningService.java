package se.miun.whiteboiz;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import se.miun.whiteboiz.entities.*;

import java.util.ArrayList;
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
    public BestallningEntity addBestallning(String datum, String tid, String kommentar, int bordId) {
        BestallningEntity bestallning = new BestallningEntity();
        bestallning.setDatum(datum);
        bestallning.setTid(tid);
        bestallning.setKommentar(kommentar);
        bestallning.setBordId(em.find(BordEntity.class, bordId));
        em.persist(bestallning);
        return bestallning;
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
        pk.setAlacarte(alacarteId);
        pk.setBestallning(bestallningId);

        // Use the primary key when calling find
        return em.find(RattInstansEntity.class, pk);
    }

    public List<RattInstansEntity> findRattInstansByBestallningId(int bestallningId){
        return em.createQuery("select R from RattInstansEntity R where R.bestallning.id = :bestallningId", RattInstansEntity.class)
                .setParameter("bestallningId", bestallningId)
                .getResultList();
    }

    public void addRattInstans(int tagId, int bestallningId, int alacarteId, String rattPreferenser) {
        RattInstansEntity rattInstans = new RattInstansEntity();
        rattInstans.setTag(em.find(TypEntity.class, tagId));
        rattInstans.setBestallning(em.find(BestallningEntity.class, bestallningId));
        rattInstans.setAlacarte(em.find(AlacarteEntity.class, alacarteId));
        rattInstans.setRattPreferenser(rattPreferenser);
        em.persist(rattInstans);
    }

    public void deleteRattInstans(int id, int alacarteId, int bestallningId) {
        RattInstansEntityPK pk = new RattInstansEntityPK();
        pk.setId(id);
        pk.setAlacarte(alacarteId);
        pk.setBestallning(bestallningId);

        RattInstansEntity rattInstans = em.find(RattInstansEntity.class, pk);
        em.remove(rattInstans);
    }

    public void deleteAllRattInstansInBestallning(int id) {
        List<RattInstansEntity> rattInstanser = em.createQuery("select R from RattInstansEntity R where R.bestallning.id = :bestallningId", RattInstansEntity.class)
                .setParameter("bestallningId", id)
                .getResultList();
        for (RattInstansEntity rattInstans : rattInstanser) {
            em.remove(rattInstans);
        }
    }

    public class BestallningWithRattInstans {
        public BestallningWithRattInstans(BestallningEntity bestallning, List<RattInstansEntity> rattInstanser) {
            this.bestallning = bestallning;
            this.rattInstanser = rattInstanser;
        }
        public BestallningEntity bestallning;
        public List<RattInstansEntity> rattInstanser;
    }

    public List<BestallningWithRattInstans> findAllBestallningarWithRattInstans() {
        ArrayList<BestallningWithRattInstans> resultList = new ArrayList<>();
        List<BestallningEntity> bestallningar = em.createQuery("select B from BestallningEntity B", BestallningEntity.class).getResultList();
        for (BestallningEntity bestallning : bestallningar) {
            List<RattInstansEntity> rattInstanser = em.createQuery("select R from RattInstansEntity R where r.bestallning.id=:b_id", RattInstansEntity.class).setParameter("b_id", bestallning.getId()).getResultList();
            resultList.add(new BestallningWithRattInstans(bestallning, rattInstanser));
        }
        return resultList;

        /*List<BestallningWithRattInstans> bestallningarWithRattInstans = new ArrayList<>();
        for (BestallningEntity bestallning : bestallningar) {
            BestallningWithRattInstans bestallningWithRattInstans = new BestallningWithRattInstans();
            bestallningWithRattInstans.bestallning = bestallning;
            bestallningWithRattInstans.rattInstanser = new ArrayList<>();
            for (RattInstansEntity rattInstans : rattInstanser) {
                if (rattInstans.getBestallning().getId() == bestallning.getId()) {
                    bestallningWithRattInstans.rattInstanser.add(rattInstans);
                }
            }
            bestallningarWithRattInstans.add(bestallningWithRattInstans);
        }
        return bestallningarWithRattInstans;*/
    }



}
