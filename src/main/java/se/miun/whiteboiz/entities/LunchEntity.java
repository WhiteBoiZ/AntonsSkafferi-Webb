package se.miun.whiteboiz.entities;

import jakarta.persistence.*;

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

}
