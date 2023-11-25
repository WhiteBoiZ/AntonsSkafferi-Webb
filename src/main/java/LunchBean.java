import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

@RequestScoped @Named
public class LunchBean {
    private String lunchTitle;
    private String lunchDescription;

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


}
