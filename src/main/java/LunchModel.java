import jakarta.faces.model.ListDataModel;

import java.util.List;

public class LunchModel extends ListDataModel<LunchList> {
    public LunchModel(List<LunchList> list) {
        super(list);
    }
}
