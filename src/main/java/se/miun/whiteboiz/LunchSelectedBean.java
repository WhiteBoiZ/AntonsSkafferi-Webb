package se.miun.whiteboiz;

import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import se.miun.whiteboiz.entities.LunchEntity;

import java.util.ArrayList;
import java.util.List;

@Named @RequestScoped
public class LunchSelectedBean {
    @Inject
    LunchService ls;
    private LunchEntity lunch;

    public LunchSelectedBean() {
    }
    public LunchSelectedBean(LunchEntity lunch) {
        this.lunch = lunch;
    }

    public LunchSelectedBean chooseLunch(LunchEntity aLunch){
        lunch = aLunch;
        return this;
    }

    public List<String> getSelected() {
        return ls.findDaysForLunch(lunch);
    }

    public void setSelected(ArrayList<String> select){
        List<String> currentSelect = ls.findDaysForLunch(lunch);
        if(select.size() < currentSelect.size()){//Lunchen har tagits bort från en dag.
            currentSelect.removeAll(select);
            for (String s : currentSelect) {
                ls.removeLunchVecka(lunch, ls.getDagFromName(s));
            }

        } else if(select.size() > currentSelect.size()){//Lunch har lagts till på en dag
            select.removeAll(currentSelect);
            for(String s : select){
                ls.mapLunchToDay(lunch, ls.getDagFromName(s));
            }
        }
    }
}
