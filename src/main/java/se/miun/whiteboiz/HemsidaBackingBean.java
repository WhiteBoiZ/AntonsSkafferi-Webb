package se.miun.whiteboiz;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import se.miun.whiteboiz.entities.EvenemangEntity;

import javax.swing.text.DateFormatter;
import java.text.DateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.time.temporal.WeekFields;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@ApplicationScoped
@Named
public class HemsidaBackingBean {
    @Inject
    private EvenemangService evenemangService;

    public String getCurrentDay() {
        return LocalDate.now().getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.getDefault());
    }
    public int getCurrentDayNumber() {
        return LocalDate.now().getDayOfWeek().getValue();
    }
    public int getCurrentWeekNumber() {
        return LocalDate.now().get(WeekFields.ISO.weekOfWeekBasedYear());
    }

    public EvenemangEntity getNextEvent() {
        List<EvenemangEntity> events = evenemangService.findAllEvenemangByDate();
        EvenemangEntity nextEvent = null;
        LocalDate currentDate = LocalDate.now();
        //compare with current date and get the upcoming event
        for (EvenemangEntity event : events) {
            LocalDate eventDate = LocalDate.parse(event.getDatum());
            if (nextEvent == null || currentDate.compareTo(eventDate) < 0) {
                nextEvent = event;
            }
        }
        return nextEvent;
    }

    public List<EvenemangEntity> getFutureEvents() {
        List<EvenemangEntity> events = evenemangService.findAllEvenemang();
        events.removeIf(event -> event.getDatum().compareTo(LocalDate.now().toString()) < 0);
        return events;
    }

    public List<EvenemangEntity> getPastEvents() {
        List<EvenemangEntity> events = evenemangService.findAllEvenemang();
        events.removeIf(event -> event.getDatum().compareTo(LocalDate.now().toString()) >= 0);
        return events;
    }
}
