package se.miun.whiteboiz.containers;

import java.util.ArrayList;

public class WeekLunchMenu extends ArrayList<ArrayList<Lunch>> {
    public WeekLunchMenu() {
        super();
        for(int i = 0; i < 5; i++){
            this.add(new ArrayList<Lunch>());
        }
    }
    public ArrayList<Lunch> getDayMenu(int day){
        return this.get(day);
    }
    public void addToMenu(int day, Lunch lunch){
        ArrayList<Lunch> dayMenu = getDayMenu(day);
        dayMenu.add(lunch);
    }

    /**
     * Removes all instances of a lunch from the week menu. Even duplicates. Potentially very slow for large day menus,
     * but they shouldn't be large.
     * @param lunch Lunch to be removed
     */
    public void removeFromMenu(Lunch lunch){
        for(ArrayList<Lunch> dayMenu : this){
            while(dayMenu.contains(lunch)){
                dayMenu.remove(lunch);
            }
        }
    }

}
