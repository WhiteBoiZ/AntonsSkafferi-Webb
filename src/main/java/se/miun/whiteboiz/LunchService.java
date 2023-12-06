package se.miun.whiteboiz;

import jakarta.enterprise.context.ApplicationScoped;
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
    public List<LunchVeckaEntity> findLunchesForDayWeekNumber(){
        return em.createQuery("select L from LunchVeckaEntity L ", LunchVeckaEntity.class).getResultList();
    }

    public List<LunchEntity> findLunchesForDayWeekNumber(int dagId){
        TypedQuery<LunchEntity> query = em.createQuery("select L.lunch from LunchVeckaEntity L where L.dag.id=:dagId", LunchEntity.class);
        query.setParameter("dagId", dagId);
        return query.getResultList();
    }

    public LunchVeckaEntity findLunchVecka(int dagId, int lunchId){
        LunchVeckaEntityPK pk = new LunchVeckaEntityPK();
        pk.setDag(dagId);
        pk.setLunch(lunchId);

        return em.find(LunchVeckaEntity.class, pk);
    }

    public List<LunchEntity> findLunchesForDay(String day){
        ArrayList<LunchEntity> dayLunches = new ArrayList<>();
        for (LunchVeckaEntity lunchDag : findLunchesForDayWeekNumber()) {
            if (lunchDag.getDag().getNamn().equals(day) && lunchDag.getLunch() != null ){
                dayLunches.add(lunchDag.getLunch());
            }
        }
        return dayLunches;
    }


    public List<String> findDaysForLunch(LunchEntity lunch){
        ArrayList<String> days = new ArrayList<>();
        for (LunchVeckaEntity lunchVecka : findLunchesForDayWeekNumber()) {
            if(lunchVecka.getLunch().getId() == lunch.getId() ){
                days.add(lunchVecka.getDag().getNamn());
            }
        }
        return days;
    }

    public List<DagEntity> findDaysEntityForLunch(LunchEntity lunch){
        ArrayList<DagEntity> days = new ArrayList<>();
        for (LunchVeckaEntity lunchVecka : findLunchesForDayWeekNumber()) {
            if(lunchVecka.getLunch().getId() == lunch.getId() ){
                days.add(lunchVecka.getDag());
            }
        }
        return days;
    }

    public List<LunchVeckaEntity> findVeckorForLunch(LunchEntity lunch){
        List<LunchVeckaEntity> lunchveckor = new ArrayList<>();
        for(LunchVeckaEntity vecka : findLunchesForDayWeekNumber()){
            if(vecka.getLunch().getId() == lunch.getId()){
                lunchveckor.add(vecka);
            }
        }
        return lunchveckor;
    }

    public void putLunch(){
        em.persist(new LunchEntity(inputTitel, inputBeskrivning));
    }

    public void mapLunchToDay(LunchEntity lunch, DagEntity dag){
        em.persist(new LunchVeckaEntity(dag, lunch));
    }

    public DagEntity getDagFromName(String name){
        TypedQuery<DagEntity> query = em.createQuery("select D from DagEntity D where D.namn=:nam", DagEntity.class);
        query.setParameter("nam", name);
        return query.getSingleResult();
    }

    public void removeLunch(int id){
        LunchEntity garbage = em.find(LunchEntity.class, id);
        for(LunchVeckaEntity vecka : findVeckorForLunch(garbage)){
            em.remove(vecka);
        }
        em.remove(garbage);
    }

    public LunchVeckaEntity findLunchVecka(LunchEntity lunch, DagEntity dag){
        LunchVeckaEntityPK pk = new LunchVeckaEntityPK();
        pk.setLunch(lunch.getId());
        pk.setDag(dag.getId());
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

    public void setLunchOnDay(LunchEntity lunch, String dagString){
        if(!isLunchOnDay(lunch, dagString)){
            mapLunchToDay(lunch, getDagFromName(dagString));
        }

    }

    public void removeLunchOnDay(LunchEntity lunch, String dagString){
        if(isLunchOnDay(lunch, dagString)){
            removeLunchVecka(lunch, getDagFromName(dagString));
        }

    }
    public boolean isLunchOnDay(LunchEntity lunch, String dagString){
        return findDaysForLunch(lunch).contains(dagString);
    }
}
