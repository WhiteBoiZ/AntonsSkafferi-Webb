package se.miun.whiteboiz.entities;

import jakarta.persistence.*;

import java.util.Objects;

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
    private int vald;
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

    public int getVald() {
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
        return id == that.id && vald == that.vald && Objects.equals(titel, that.titel) && Objects.equals(beskrivning, that.beskrivning) && Objects.equals(typId, that.typId) && Objects.equals(pris, that.pris);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, titel, beskrivning, typId, vald, pris);
    }
}
