import jakarta.enterprise.context.ApplicationScoped;
import jakarta.faces.model.ListDataModel;
import jakarta.inject.Named;

@ApplicationScoped @Named
public class TestBean {
    private String lunchTitle;
    private String lunchDesc;

    private LunchList lunches = new LunchList();
    private ListDataModel<Lunch> listModel = new ListDataModel<Lunch>(lunches);

    public void addLunch(){
        lunches.add(new Lunch(lunchTitle, lunchDesc));
        System.out.println(lunchTitle);
    }
    public void removeLunch(){
        lunches.remove(listModel.getRowIndex());
    }

    public LunchList getLunches() {
        return lunches;
    }

    public String getLunchTitle() {
        return lunchTitle;
    }

    public void setLunchTitle(String lunchTitle) {
        this.lunchTitle = lunchTitle;
    }

    public String getLunchDesc() {
        return lunchDesc;
    }

    public void setLunchDesc(String lunchDesc) {
        this.lunchDesc = lunchDesc;
    }

    public ListDataModel<Lunch> getListModel() {
        return listModel;
    }




}
