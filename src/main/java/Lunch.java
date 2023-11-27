import java.util.ArrayList;

public class Lunch {
    private String title;
    private String description;
    private ArrayList<String> selectedDays = new ArrayList<>();

    public Lunch(String title, String description) {
        this.title = title;
        this.description = description;
        selectedDays.add("Mån");
    }

    public ArrayList<String> getSelectedDays() {
        return selectedDays;
    }

    public void setSelectedDays(ArrayList<String> selectedDays) {
        this.selectedDays = selectedDays;
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

}
