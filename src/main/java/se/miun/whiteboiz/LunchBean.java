package se.miun.whiteboiz;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.faces.model.ListDataModel;
import jakarta.inject.Named;
import se.miun.whiteboiz.containers.Lunch;
import se.miun.whiteboiz.containers.WeekLunchMenu;

import java.util.*;

@ApplicationScoped
@Named
public class LunchBean {
    private static String mon ="mån", tue ="tis", ons ="ons", tor ="tor", fri ="fre";
    private String lunchTitle;
    private String lunchDescription;
    private ArrayList<Lunch> lunches = new ArrayList<>();
    private ListDataModel<Lunch> listModel = new ListDataModel<Lunch>(lunches);
    private Lunch[] lunchMenu = new Lunch[5];

    private String[] lunchArray = new String[10];

    private WeekLunchMenu weekLunchMenu = new WeekLunchMenu();



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

    public String[] getLunchArray(){
        return lunchArray;
    }
    public void setLunchArray(String[] lunchArray){
        this.lunchArray = lunchArray;
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

    public Lunch getLunch(){
        return lunches.get(listModel.getRowIndex());
     }

     public List<String> getDaySelection(){ return getLunch().getSelectedDays();
     }
     public void setDaySelection(ArrayList<String> selection){
        getLunch().setSelectedDays(selection);
     }
     public String onValueUpdate(){
        StringBuilder builder = new StringBuilder();
        for(String s: getLunch().getSelectedDays()){
            builder.append(s);
        }
        return builder.toString();
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

    public static String dayIntToString(int day){
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

    public void updateLunchPreview(){
        Lunch currentLunch = getLunch();
        List<String> selectedDays = currentLunch.getSelectedDays();
        weekLunchMenu.removeFromMenu(currentLunch);
        for(String day : selectedDays){
            if(mon.equalsIgnoreCase(day)){
                weekLunchMenu.addToMenu(0, currentLunch);
            }
            if(tue.equalsIgnoreCase(day)){
                weekLunchMenu.addToMenu(1, currentLunch);
            }
            if(ons.equalsIgnoreCase(day)){
                weekLunchMenu.addToMenu(2, currentLunch);
            }
            if(tor.equalsIgnoreCase(day)){
                weekLunchMenu.addToMenu(3, currentLunch);
            }
            if(fri.equalsIgnoreCase(day)){
                weekLunchMenu.addToMenu(4, currentLunch);
            }
        }
    }

    public WeekLunchMenu getWeekLunchMenu() {
        return weekLunchMenu;
    }

    public static String getFri() {
        return fri;
    }

    public static String getMon() {
        return mon;
    }

    public static String getOns() {
        return ons;
    }

    public static String getTor() {
        return tor;
    }

    public static String getTue() {
        return tue;
    }

}
