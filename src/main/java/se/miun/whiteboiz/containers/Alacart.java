package se.miun.whiteboiz.containers;

public class Alacart {
    public enum AlaCarteCategory{
        STARTER, MAIN, DESSERT
    }
    private String title;
    private String description;
    private AlaCarteCategory alaCarteCategory;

    public Alacart(String title, String description){
        //this.alaCarteCategory = category;
        this.title = title;
        this.description = description;


    }
    //Getters & Setters
    public AlaCarteCategory getAlaCarteCategory(){
        return alaCarteCategory;
    }
    public void setAlaCarteCategory(AlaCarteCategory category){
        this.alaCarteCategory = category;
    }
    public String getTitel() {
        return title;
    }

    public void setTitel(String titel) {
        this.title = title;
    }



    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
