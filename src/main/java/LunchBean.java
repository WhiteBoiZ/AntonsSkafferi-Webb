import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@RequestScoped @Named
public class LunchBean {
    private String lunchTitle;
    private String lunchDescription;
    private String lunch;

    public void addLunch() {
        // Add your logic here to process the submitted data
        //System.out.println("Title: " + lunchTitle);
        //System.out.println("Description: " + lunchDescription);

    }

    // Getters and setters for title and description
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
