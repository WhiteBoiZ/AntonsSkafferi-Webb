package se.miun.whiteboiz;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;
import se.miun.whiteboiz.containers.Alacart;
import se.miun.whiteboiz.containers.Lunch;

import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
@Named
public class AlacartBean {

    public List<Alacart> getAlaCartMenu() {
        return alaCartMenu;
    }

    public void setAlaCartMenu(List<Alacart> alaCartMenu) {
        this.alaCartMenu = alaCartMenu;
    }

    private List<Alacart> alaCartMenu = new ArrayList<>();

    public void addAlaCarteItem(Alacart item){
        alaCartMenu.add(item);
    }


    public String getAlaCarteTitle() {
        return alaCarteTitle;
    }

    public void setAlaCarteTitle(String alaCarteTitle) {
        this.alaCarteTitle = alaCarteTitle;
    }

    private String alaCarteTitle;

    public String getAlaCarteDescription() {
        return alaCarteDescription;
    }

    public void setAlaCarteDescription(String alaCarteDescription) {
        this.alaCarteDescription = alaCarteDescription;
    }

    private String alaCarteDescription;

    public void addStarter(){
        alaCartMenu.add(new Alacart(alaCarteTitle, alaCarteDescription));

    }
    public void addDessert(){
        alaCartMenu.add(new Alacart(alaCarteTitle, alaCarteDescription));

    }
    public void addMain(){
        alaCartMenu.add(new Alacart(alaCarteTitle, alaCarteDescription));

    }




}
