package se.miun.whiteboiz;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.faces.model.ListDataModel;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import se.miun.whiteboiz.containers.Drink;
import se.miun.whiteboiz.entities.AlacarteEntity;

import java.util.ArrayList;
@ApplicationScoped
@Named
public class drinkBean {
    @Inject
    AlacarteService alaService;
    private String drinkTitle;
    private String drinkDescription;

    public String getDrinkTitle() {
        return drinkTitle;
    }

    public void setDrinkTitle(String drinkTitle) {
        this.drinkTitle = drinkTitle;
    }

    public String getDrinkDesc() {
        return drinkDescription;
    }

    public void setDrinkDesc(String drinkDesc) {
        this.drinkDescription = drinkDesc;
    }

    public void addDrink(){
        AlacarteEntity dryck = new AlacarteEntity();
        dryck.setTyp(alaService.findTyp(4));
        dryck.setTitel(drinkTitle);
        dryck.setBeskrivning(drinkDescription);
        dryck.setVald(true);
        alaService.addAlacarte(dryck);

    }
    public void removeDrink(AlacarteEntity dryck){
        alaService.removeAlacarte(dryck.getId());
    }

}
