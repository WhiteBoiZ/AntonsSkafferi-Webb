package se.miun.whiteboiz.containers;

public class Alacart {
    public enum AlaCarteCategory{
        STARTER, MAIN, DESSERT
    }
    private String title;
    private String description;
    private AlaCarteCategory alaCarteCategory;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private int id;

    public Alacart(int id,String title, String description){
        //this.alaCarteCategory = category;
        this.title = title;
        this.description = description;
        this.id = id;


    }
    //Getters & Setters


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
