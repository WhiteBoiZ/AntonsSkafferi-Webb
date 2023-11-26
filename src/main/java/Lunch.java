import java.util.HashMap;

public class Lunch {
    private String title;
    private String description;
    private Boolean[] daySelected = new Boolean[5];

    public Lunch(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public void selectDay(int day){
        daySelected[day] = true;
    }

    public void unselectDay(int day){
        daySelected[day] = false;
    }

    public void putSelection(int day, boolean choice){
        daySelected[day] = choice;
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean[] getDaySelected() {
        return daySelected;
    }

    public void setDaySelected(Boolean[] daySelected) {
        this.daySelected = daySelected;
    }
}
