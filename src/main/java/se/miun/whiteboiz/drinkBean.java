package se.miun.whiteboiz;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.faces.model.ListDataModel;
import jakarta.inject.Named;
import se.miun.whiteboiz.containers.Drink;

import java.util.ArrayList;
@ApplicationScoped
@Named
public class drinkBean {
    private String drinkTitle;
    private String drinkDescription;
    private ArrayList<Drink> drinksMenu = new ArrayList<>();

    public ArrayList<Drink> getDrinksMenu() {
        return drinksMenu;
    }

    public void setDrinksMenu(ArrayList<Drink> drinksList) {
        this.drinksMenu = drinksList;
    }

    public ListDataModel<Drink> getListModelDrink() {
        return listModelDrink;
    }

    public void setListModelDrink(ListDataModel<Drink> listModelDrink) {
        this.listModelDrink = listModelDrink;
    }

    private ListDataModel<Drink> listModelDrink = new ListDataModel<Drink>(drinksMenu);


    public String getDrinkTitle() {
        return drinkTitle;
    }

    public void setDrinkTitle(String drinkTitle) {
        this.drinkTitle = drinkTitle;
    }



    public String getDrinkDesc() {
        return drinkDescription;
    }

    public void setDrinkDesc(String drinkDesc) {
        this.drinkDescription = drinkDesc;
    }

    public void addDrink(){
        drinksMenu.add(new Drink(drinkTitle, drinkTitle));

    }
    public void removeDrink(){
        drinksMenu.remove(listModelDrink.getRowIndex());
    }

}
