package se.miun.whiteboiz;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import se.miun.whiteboiz.entities.AlacarteEntity;

import java.util.List;

@ApplicationScoped
@Named
@Transactional
public class AlacarteService {
    @PersistenceContext
    private EntityManager em;

    public AlacarteEntity findAlacarte(int id){
        return em.find(AlacarteEntity.class, id);
    }

    public void deleteAlacarte(int alacarteId) {
        AlacarteEntity alacarte = em.find(AlacarteEntity.class, alacarteId);
        em.remove(alacarte);
    }

    public void addAlacarte(AlacarteEntity alacarte) {
        em.persist(alacarte);
    }


    public List<AlacarteEntity> findAllAlacarte(){
        return em.createQuery("select A from AlacarteEntity A ", AlacarteEntity.class).getResultList();
    }

    public List<AlacarteEntity> findAllAlacarteForrater(){
        return em.createQuery("select A from AlacarteEntity A where A.typ.id = 1", AlacarteEntity.class).getResultList();
    }

    public List<AlacarteEntity> findAllAlacarteHuvudratter(){
        return em.createQuery("select A from AlacarteEntity A where A.typ.id = 2", AlacarteEntity.class).getResultList();
    }

    public List<AlacarteEntity> findAllAlacarteDesserter(){
        return em.createQuery("select A from AlacarteEntity A where A.typ.id = 3", AlacarteEntity.class).getResultList();
    }

}
