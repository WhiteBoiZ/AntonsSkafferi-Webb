import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.model.ListDataModel;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.util.Date;

@ApplicationScoped
@Named
public class LunchBean {
    private String lunchTitle;
    private String lunchDescription;
    private LunchList lunches = new LunchList();
    private ListDataModel<Lunch> listModel = new ListDataModel<Lunch>(lunches);

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

    public String now(){
        return new Date().toString();
    }




}
