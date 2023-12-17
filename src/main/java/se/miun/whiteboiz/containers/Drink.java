package se.miun.whiteboiz.containers;

import jakarta.faces.model.ListDataModel;

public class Drink {
    private String title;
    private String description;
    public String getTitle() {
        return title;
    }
    public Drink(String title, String description){
        this.title = title;
        this.description = description;
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
