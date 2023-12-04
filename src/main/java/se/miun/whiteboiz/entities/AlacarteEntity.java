package se.miun.whiteboiz.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "alacarte", schema = "antonsskafferi", catalog = "")
public class AlacarteEntity {
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
    @Basic
    @Column(name = "typ_id")
    private Integer typId;
    @Basic
    @Column(name = "vald")
    private Byte vald;
    @Basic
    @Column(name = "pris")
    private Integer pris;

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

    public Integer getTypId() {
        return typId;
    }

    public void setTypId(Integer typId) {
        this.typId = typId;
    }

    public Byte getVald() {
        return vald;
    }

    public void setVald(Byte vald) {
        this.vald = vald;
    }

    public Integer getPris() {
        return pris;
    }

    public void setPris(Integer pris) {
        this.pris = pris;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AlacarteEntity that = (AlacarteEntity) o;

        if (id != that.id) return false;
        if (titel != null ? !titel.equals(that.titel) : that.titel != null) return false;
        if (beskrivning != null ? !beskrivning.equals(that.beskrivning) : that.beskrivning != null) return false;
        if (typId != null ? !typId.equals(that.typId) : that.typId != null) return false;
        if (vald != null ? !vald.equals(that.vald) : that.vald != null) return false;
        if (pris != null ? !pris.equals(that.pris) : that.pris != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (titel != null ? titel.hashCode() : 0);
        result = 31 * result + (beskrivning != null ? beskrivning.hashCode() : 0);
        result = 31 * result + (typId != null ? typId.hashCode() : 0);
        result = 31 * result + (vald != null ? vald.hashCode() : 0);
        result = 31 * result + (pris != null ? pris.hashCode() : 0);
        return result;
    }
}
