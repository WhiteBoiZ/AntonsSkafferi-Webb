package se.miun.whiteboiz.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "lunch", schema = "antonsskafferi", catalog = "")
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


    @OneToMany(cascade = CascadeType.ALL, mappedBy = "")


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

        if (id != that.id) return false;
        if (titel != null ? !titel.equals(that.titel) : that.titel != null) return false;
        if (beskrivning != null ? !beskrivning.equals(that.beskrivning) : that.beskrivning != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (titel != null ? titel.hashCode() : 0);
        result = 31 * result + (beskrivning != null ? beskrivning.hashCode() : 0);
        return result;
    }
}
