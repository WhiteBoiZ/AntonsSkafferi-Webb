package se.miun.whiteboiz;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import se.miun.whiteboiz.entities.EvenemangEntity;

import java.util.List;

@ApplicationScoped
@Named
@Transactional
public class EvenemangService {
    @PersistenceContext
    private EntityManager em;


    private String inputNamn;
    private String inputBeskrivning;
    private String inputDatum;
    private String inputTid;

    //image


    public String getInputNamn() {
        return inputNamn;
    }

    public void setInputNamn(String inputNamn) {
        this.inputNamn = inputNamn;
    }

    public String getInputBeskrivning() {
        return inputBeskrivning;
    }

    public void setInputBeskrivning(String inputBeskrivning) {
        this.inputBeskrivning = inputBeskrivning;
    }

    public String getInputDatum() {
        return inputDatum;
    }

    public void setInputDatum(String inputDatum) {
        this.inputDatum = inputDatum;
    }

    public String getInputTid() {
        return inputTid;
    }

    public void setInputTid(String inputTid) {
        this.inputTid = inputTid;
    }

    public void putEvenemang() {
        em.persist(new EvenemangEntity(inputNamn, inputBeskrivning, inputDatum, inputTid));
    }


    public List<EvenemangEntity> findAllEvenemang(){
        return em.createQuery("select E from EvenemangEntity E", EvenemangEntity.class).getResultList();
    }


}
