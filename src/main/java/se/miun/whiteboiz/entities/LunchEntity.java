package se.miun.whiteboiz.entities;

import jakarta.inject.Inject;
import jakarta.persistence.*;
import se.miun.whiteboiz.LunchService;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "lunch", schema = "antonsskafferi")
public class LunchEntity {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "titel")
    private String titel;
    @Basic
    @Column(name = "beskrivning")
    private String beskrivning;

    @Inject
    @Transient
    LunchService ls;

    @Transient
    private List<String> selection;


    public List<String> getSelection(){
        selection = ls.findDaysForLunch(this);
        return selection;
    }

    public void setSelection(ArrayList<String> select){
        if(selection == null){
            selection = ls.findDaysForLunch(this);
        }
        if(select.size() < selection.size()){//Lunchen har tagits bort från en dag.
            selection.removeAll(select);
            for (String s : selection) {
                ls.removeLunchVecka(this, ls.getDagFromName(s));
            }
            selection = select;

        } else if(select.size() > selection.size()){
            select.removeAll(selection);
            for(String s : select){
                ls.mapLunchToDay(this, ls.getDagFromName(s));
            }
            selection.addAll(select);

        }
    }

    public LunchEntity() {
    }

    public LunchEntity(String titel, String beskrivning) {
        this.titel = titel;
        this.beskrivning = beskrivning;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitel() {
        return titel;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public String getBeskrivning() {
        return beskrivning;
    }

    public void setBeskrivning(String beskrivning) {
        this.beskrivning = beskrivning;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LunchEntity that = (LunchEntity) o;
        return id == that.id && Objects.equals(titel, that.titel) && Objects.equals(beskrivning, that.beskrivning);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, titel, beskrivning);
    }
}
