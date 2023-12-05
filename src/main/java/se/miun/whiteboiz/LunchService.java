package se.miun.whiteboiz;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import se.miun.whiteboiz.entities.DagEntity;
import se.miun.whiteboiz.entities.LunchEntity;
import se.miun.whiteboiz.entities.LunchVeckaEntity;
import se.miun.whiteboiz.entities.LunchVeckaEntityPK;

import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
@Named @Transactional
public class LunchService {
    private String inputTitel;
    private String inputBeskrivning;

    @PersistenceContext
    private EntityManager em;

    public LunchEntity findLunch(int id){
        return em.find(LunchEntity.class, id);
    }
    public List<LunchEntity> findAllLunches(){
        return em.createQuery("select L from LunchEntity L", LunchEntity.class).getResultList();
    }
    public List<LunchVeckaEntity> findAllLunchesForWeek(){
        return em.createQuery("select L from LunchVeckaEntity L ", LunchVeckaEntity.class).getResultList();
    }

    public List<LunchEntity> findLunchesForDay(String day){
        ArrayList<LunchEntity> dayLunches = new ArrayList<>();
        for (LunchVeckaEntity lunchDag : findAllLunchesForWeek()) {
            if (lunchDag.getDagId().getNamn().equals(day) && lunchDag.getLunchId() != null ){
                dayLunches.add(lunchDag.getLunchId());
            }
        }
        return dayLunches;
    }

    public List<String> findDaysForLunch(LunchEntity lunch){
        ArrayList<String> days = new ArrayList<>();
        for (LunchVeckaEntity lunchVeckaEntity : findAllLunchesForWeek()) {
            if(lunchVeckaEntity.getLunchId() == lunch){
                days.add(lunchVeckaEntity.getDagId().getNamn());
            }
        }
        return days;
    }

    public void setDaysForLunch(List<String> days){

    }
    public void putLunch(){
        em.persist(new LunchEntity(inputTitel, inputBeskrivning));
    }

    public void mapLunchToDay(LunchEntity lunch, DagEntity dag){

    }

    public DagEntity getDagFromName(String name){
        TypedQuery<DagEntity> query = em.createQuery("select D.namn from DagEntity D where D.namn=:nam", DagEntity.class);
        query.setParameter("nam", name);
        return query.getSingleResult();
    }

    public void removeLunch(LunchEntity lunch){
        em.remove(lunch);
    }

    public LunchVeckaEntity findLunchVecka(LunchEntity lunch, DagEntity dag){
        LunchVeckaEntityPK pk = new LunchVeckaEntityPK();
        pk.setLunchId(lunch.getId());
        pk.setDagId(dag.getId());
        return em.find(LunchVeckaEntity.class, pk);
    }
    public void removeLunchVecka(LunchEntity lunch, DagEntity dag){
        em.remove(findLunchVecka(lunch, dag));
    }
    public String getInputTitel() {
        return inputTitel;
    }

    public void setInputTitel(String inputTitel) {
        this.inputTitel = inputTitel;
    }

    public String getInputBeskrivning() {
        return inputBeskrivning;
    }

    public void setInputBeskrivning(String inputBeskrivning) {
        this.inputBeskrivning = inputBeskrivning;
    }
}
