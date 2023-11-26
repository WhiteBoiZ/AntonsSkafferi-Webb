import jakarta.el.MethodExpression;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.model.ListDataModel;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.util.*;

@ApplicationScoped
@Named
public class LunchBean {
    private String lunchTitle;
    private String lunchDescription;
    private ArrayList<Lunch> lunches = new ArrayList<>();
    private ListDataModel<Lunch> listModel = new ListDataModel<Lunch>(lunches);
    private Lunch[] lunchMenu = new Lunch[5];

    private String[] selected;



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

    public void addLunch(){
        lunches.add(new Lunch(lunchTitle, lunchDescription));
        System.out.println(lunchTitle);
    }
    public void removeLunch(){
        lunches.remove(listModel.getRowIndex());
    }

    public ListDataModel<Lunch> getListModel() {
        return listModel;
    }

    public void setLunchMenu() {
        int lunchIndex = listModel.getRowIndex();
        lunchMenu[lunchIndex] = lunches.get(lunchIndex);
    }

    public List<Boolean> getSelection(){
        List<Boolean> selection = Arrays.asList(new Boolean[5]);
        for(int i = 0; i < lunchMenu.length; i++) {
            if(lunchMenu[i] == lunches.get(listModel.getRowIndex())) {
                selection.set(i, true);
            }
        }
        return selection;
    }

    public String[] getSelected() {
        ArrayList<String> sel = new ArrayList<>();
        Lunch currentLunch = lunches.get(listModel.getRowIndex());
        for(int i = 0; i < currentLunch.getDaySelected().length; i++){
            if(currentLunch.getDaySelected()[i]){
                sel.add(dayIntToString(i));
            }
        }
        return sel.toArray(new String[sel.size()]);
    }

    public void setSelected(String[] selected) {
        this.selected = selected;
        for(String sel:selected){
            System.out.println(sel);
        }
    }

    public void selectedOptionsChanged() {
        Lunch currentLunch = lunches.get(listModel.getRowIndex());
        Arrays.fill(currentLunch.getDaySelected(), false);
        if (selected != null){
            for(String sel: selected){
                currentLunch.selectDay(dayStringToInt(sel));
            }
        }
    }

    private static int dayStringToInt(String day){
        switch (day) {
            case "man":
                return 0;
            case "tis":
                return 1;
            case "ons":
                return 2;
            case "tor":
                return 3;
            case "fre":
                return 4;
            case "lor":
                return 5;
            case "son":
                return 6;
            default:
                return 100;
        }
    }

    private static String dayIntToString(int day){
        switch (day) {
            case 0:
                return "man";
            case 1:
                return "tis";
            case 2:
                return "ons";
            case 3:
                return "tor";
            case 4:
                return "fre";
            case 5:
                return "lor";
            case 6:
                return "son";
            default:
                return "100";
        }
    }
}
