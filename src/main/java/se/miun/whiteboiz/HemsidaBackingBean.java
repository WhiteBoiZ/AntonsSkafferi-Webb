package se.miun.whiteboiz;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import se.miun.whiteboiz.entities.EvenemangEntity;

import java.time.LocalDate;
import java.time.format.TextStyle;
import java.time.temporal.WeekFields;
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
        List<EvenemangEntity> events = evenemangService.findAllEvenemang();
        EvenemangEntity nextEvent = null;
        for (EvenemangEntity event : events) {
            if (nextEvent == null) {
                nextEvent = event;
            } else {
                if (event.getDatum().compareTo(nextEvent.getDatum()) < 0) {
                    nextEvent = event;
                }
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
