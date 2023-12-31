package se.miun.whiteboiz;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import se.miun.whiteboiz.entities.AlacarteEntity;
import se.miun.whiteboiz.entities.TypEntity;

import java.util.List;

@ApplicationScoped
@Named
@Transactional
public class AlacarteService {
    @PersistenceContext
    private EntityManager em;


    public void addAlacarte(AlacarteEntity alacartEntity){
        em.persist(alacartEntity);
    }

    public void removeAlacarte(int id){
        AlacarteEntity entity = em.find(AlacarteEntity.class,id);
        if(entity != null){
            em.remove(entity);
        }
    }


    public void deleteAlacarte(int alacarteId) {
        AlacarteEntity alacarte = em.find(AlacarteEntity.class, alacarteId);
        em.remove(alacarte);
    }

    public AlacarteEntity findAlacarte(int id){
        return em.find(AlacarteEntity.class, id);
    }

    public TypEntity findTyp(int id){
        return em.find(TypEntity.class, id);
    }


    public List<AlacarteEntity> findAllAlacarte(){
        return em.createQuery("select A from AlacarteEntity A ", AlacarteEntity.class).getResultList();
    }

    public List<AlacarteEntity> findAllActiveAlacarteForrater(){
        return em.createQuery("select A from AlacarteEntity A where A.typ.id = 1 and A.vald = true", AlacarteEntity.class).getResultList();
    }

    public List<AlacarteEntity> findAllActiveAlacarteHuvudratter(){
        return em.createQuery("select A from AlacarteEntity A where A.typ.id = 2 and A.vald = true", AlacarteEntity.class).getResultList();
    }

    public List<AlacarteEntity> findAllActiveAlacarteDesserter(){
        return em.createQuery("select A from AlacarteEntity A where A.typ.id = 3 and A.vald = true", AlacarteEntity.class).getResultList();
    }

    public List<AlacarteEntity> findAllActiveAlacarteDrinks(){
        return em.createQuery("select A from AlacarteEntity A where A.typ.id = 4 and A.vald = true", AlacarteEntity.class).getResultList();
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

    public List<AlacarteEntity> findAllAlacarteDrinks(){
        return em.createQuery("select A from AlacarteEntity A where A.typ.id = 4", AlacarteEntity.class).getResultList();
    }


}
