import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@RequestScoped @Named
public class LunchBean {
    private String lunchTitle;
    private String lunchDescription;
    private String lunch;

    public String getLunchTitle() {
        return lunchTitle;
    }
    public void setLunchTitle(String lunchTitle) {
        this.lunchTitle = lunchTitle;
    }
    public String getLunchDescription() {
        return lunchDescription;
    }
    public void setLunchDescription(String lunchDescription) {
        this.lunchDescription = lunchDescription;
    }

    public void showLunch(String title, String desc){

         lunch = "Titel: " + title + " " + "Beskrivning: " + desc;
    }
    public String getLunch(){
        return this.lunch;
    }



}
