package se.miun.whiteboiz;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.faces.event.ValueChangeEvent;
import jakarta.faces.model.ListDataModel;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import se.miun.whiteboiz.containers.Alacart;
import se.miun.whiteboiz.containers.Lunch;
import se.miun.whiteboiz.entities.AlacarteEntity;
import se.miun.whiteboiz.entities.BordEntity;
import se.miun.whiteboiz.entities.TypEntity;

import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
@Named
public class AlacartBean {

    @Inject
    private AlacarteService alacarteService;


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
        AlacarteEntity entity = new AlacarteEntity();
        entity.setTyp(alacarteService.findTyp(1));
        entity.setTitel(alaCarteTitle);
        entity.setBeskrivning(alaCarteDescription);
        entity.setVald(true);
        alacarteService.addAlacarte(entity);
    }
    public void addDessert(){
        AlacarteEntity entity = new AlacarteEntity();
        entity.setTyp(alacarteService.findTyp(3));
        entity.setTitel(alaCarteTitle);
        entity.setBeskrivning(alaCarteDescription);
        entity.setVald(true);
        alacarteService.addAlacarte(entity);

    }
    public void addMain(){
        AlacarteEntity entity = new AlacarteEntity();
        entity.setTyp(alacarteService.findTyp(2));
        entity.setTitel(alaCarteTitle);
        entity.setBeskrivning(alaCarteDescription);
        entity.setVald(true);
        alacarteService.addAlacarte(entity);

    }

    public void removeAlacarte(int id){
        alacarteService.removeAlacarte(id);
    }

    public void handleVald(ValueChangeEvent event){

    };

   /** alaCartMenuStarter.add(new Alacart("Gravad lax med hovmästarsås och hembakat knäckebröd",
            "En klassiker med noggrant gravad lax, serverad med den traditionella hovmästarsåsen och knaprigt hemlagat knäckebröd."));
    alaCartMenuStarter.add(new Alacart("Kantarelltoast med vitlök och persilja",
            "Saftiga kantareller stekta med vitlök och persilja, serverade på rostat bröd. En smakrik och säsongsbetonad förrätt."));
    alaCartMenuStarter.add(new Alacart("Rödbetsterrin med getost och valnötter",
            "En läcker terrin av rostade rödbetor, getost och knapriga valnötter. Serveras med en lätt sallad och balsamicoreduktion."));
    alaCartMenuMain.add(new Alacart("Wallenbergare med ärtor, potatismos och lingonsylt",
            "Hemlagade Wallenbergare av kalvfärs, serverade med klassiska tillbehör som ärtor, krämigt potatismos och syrlig lingonsylt."));
    alaCartMenuMain.add(new Alacart("Svensk lövbiff med grönpepparsås, potatisgratäng och sallad",
            "Saftig lövbiff, serverad med krämig grönpepparsås, gratinerad potatisgratäng och en fräsch sallad."));
    alaCartMenuMain.add(new Alacart("Rimmad lax med dillstuvad potatis och gröna ärtor",
            "Lax rimmad i en kryddig blandning, serverad med krämig dillstuvad potatis och lättkokta gröna ärtor."));
    alaCartMenuMain.add(new Alacart("Köttbullar med gräddsås, potatismos och lingon",
            "Traditionella svenska köttbullar av blandfärs, serverade med krämig gräddsås, potatismos och sötsyrliga lingon."));
    alaCartMenuMain.add(new Alacart("Laxfilé med vitvinssås, sparris och pressad potatis",
            "En saftig laxfilé, grillas eller ugnsbakas och serveras med en lätt vitvinssås, färsk sparris och pressad potatis. En fräsch och delikat rätt."));
    alaCartMenuDessert.add(new Alacart("Chokladtryffeltårta med hallon och vispad grädde",
            "En ljuvlig chokladtryffeltårta toppad med färska hallon och krämig vispad grädde. En perfekt avslutning på måltiden."));
    alaCartMenuDessert.add(new Alacart("Vaniljpannacotta med skogsbärskompott",
            "Len vaniljpannacotta toppad med en smakrik kompott av skogsbär. En lätt och fräsch efterrätt.")); **/

}
