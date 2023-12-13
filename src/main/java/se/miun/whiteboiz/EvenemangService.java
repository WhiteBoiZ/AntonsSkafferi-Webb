package se.miun.whiteboiz;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import jakarta.transaction.Transactional;
import se.miun.whiteboiz.entities.EvenemangEntity;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@ApplicationScoped
@Named
@Transactional
public class EvenemangService {
    @PersistenceContext
    private EntityManager em;


    private String inputNamn;
    private String inputBeskrivning;
    private LocalDate inputDatum;
    private LocalTime inputTid;
    private String inputImageName;
    public String getInputImageName() {
        return inputImageName;
    }

    public void setInputImageName(String inputImageName) {
        this.inputImageName = inputImageName;
    }


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

    public LocalDate getInputDatum() {
        return inputDatum;
    }

    public void setInputDatum(LocalDate inputDatum) {
        this.inputDatum = inputDatum;
    }

    public LocalTime getInputTid() {
        return inputTid;
    }

    public void setInputTid(LocalTime inputTid) {
        this.inputTid = inputTid;
    }

    public void putEvenemang() {
        String inputDatumString = inputDatum.toString();
        String inputTidString = inputTid.toString();
        em.persist(new EvenemangEntity(inputNamn, inputBeskrivning, inputDatumString, inputTidString, inputImageName));
    }


    public List<EvenemangEntity> findAllEvenemang(){
        return em.createQuery("select E from EvenemangEntity E", EvenemangEntity.class).getResultList();
    }

    //Använder CriteriaBuilder för att sortera evenemang efter datum i stigande eller fallande ordning
    public List<EvenemangEntity> findAllEvenemangByDate(String sortDirection) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<EvenemangEntity> query = cb.createQuery(EvenemangEntity.class);
        Root<EvenemangEntity> root = query.from(EvenemangEntity.class);

        // Adjust the path expression based on your entity structure
        query.orderBy(
                "desc".equalsIgnoreCase(sortDirection) ? cb.desc(root.get("datum")) :
                        "asc".equalsIgnoreCase(sortDirection) ? cb.asc(root.get("datum")) :
                                cb.desc(root.get("datum"))
        );

        return em.createQuery(query).getResultList();
    }

    public void deleteEvenemang(EvenemangEntity evenemang) {
        em.remove(em.merge(evenemang));
    }


}
