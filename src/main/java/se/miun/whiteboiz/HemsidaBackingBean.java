package se.miun.whiteboiz;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;

import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;

@ApplicationScoped
@Named
public class HemsidaBackingBean {
    public String getCurrentDay() {
        return LocalDate.now().getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.getDefault());
    }
    public int getCurrentDayNumber() {
        return LocalDate.now().getDayOfWeek().getValue();
    }
}
