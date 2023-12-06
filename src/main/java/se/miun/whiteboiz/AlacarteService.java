package se.miun.whiteboiz;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;
import jakarta.persistence.Entity;
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


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    private String title;


    public void addAlacarte(AlacarteEntity alacartEntity){
        em.persist(alacartEntity);
    }

    public void removeAlacarte(int id){
        AlacarteEntity entity = em.find(AlacarteEntity.class,id);
        if(entity != null){
            em.remove(entity);
        }
    }


    public List<AlacarteEntity> findAllAlacarte(){
        return em.createQuery("SELECT a FROM AlacarteEntity a",AlacarteEntity.class).getResultList();
    }

}
