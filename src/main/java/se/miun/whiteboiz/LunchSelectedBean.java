package se.miun.whiteboiz;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import se.miun.whiteboiz.entities.LunchEntity;

import java.util.ArrayList;
import java.util.List;

@Named @ApplicationScoped
public class LunchSelectedBean {
    @Inject
    LunchService ls;
    private LunchEntity lunch;

    private List<String> selected;

    public LunchSelectedBean() {
    }

    public void listen(){

    }
    public LunchSelectedBean chooseLunch(LunchEntity aLunch){
        lunch = aLunch;
        return this;
    }

    public List<String> getSelected() {
        selected = ls.findDaysForLunch(lunch);
        return selected;
    }

    public void setSelected(List<String> select){
        //List<String> selected = ls.findDaysForLunch(lunch);
        for(String s : select){
            ls.mapLunchToDay(lunch, ls.getDagFromName(s));
        }
        selected = select;

        /*if(select.size() < selected.size()){//Lunchen har tagits bort från en dag.
            selected.removeAll(select);
            for (String s : selected) {
                ls.removeLunchVecka(lunch, ls.getDagFromName(s));
            }

        } else if(select.size() > selected.size()){//Lunch har lagts till på en dag
            select.removeAll(selected);
            for(String s : select){
                ls.mapLunchToDay(lunch, ls.getDagFromName(s));
            }
        }*/
    }
}
