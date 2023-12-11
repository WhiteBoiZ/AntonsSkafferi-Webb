package se.miun.whiteboiz.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "evenemang", schema = "antonsskafferi", catalog = "")
public class EvenemangEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "namn")
    private String namn;
    @Basic
    @Column(name = "datum")
    private String datum;
    @Basic
    @Column(name = "tid")
    private String tid;
    @Basic
    @Column(name = "beskrivning")
    private String beskrivning;
    @Basic
    @Column(name = "image")
    private String image;

    public EvenemangEntity(String namn, String beskrivning, String datum, String tid, String image) {
        this.namn = namn;
        this.datum = datum;
        this.tid = tid;
        this.beskrivning = beskrivning;
        this.image = image;
    }

    public EvenemangEntity() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNamn() {
        return namn;
    }

    public void setNamn(String namn) {
        this.namn = namn;
    }

    public String getDatum() {
        return datum;
    }

    public void setDatum(String datum) {
        this.datum = datum;
    }

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

    public String getBeskrivning() {
        return beskrivning;
    }

    public void setBeskrivning(String beskrivning) {
        this.beskrivning = beskrivning;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EvenemangEntity that = (EvenemangEntity) o;

        if (id != that.id) return false;
        if (namn != null ? !namn.equals(that.namn) : that.namn != null) return false;
        if (datum != null ? !datum.equals(that.datum) : that.datum != null) return false;
        if (tid != null ? !tid.equals(that.tid) : that.tid != null) return false;
        if (beskrivning != null ? !beskrivning.equals(that.beskrivning) : that.beskrivning != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (namn != null ? namn.hashCode() : 0);
        result = 31 * result + (datum != null ? datum.hashCode() : 0);
        result = 31 * result + (tid != null ? tid.hashCode() : 0);
        result = 31 * result + (beskrivning != null ? beskrivning.hashCode() : 0);
        return result;
    }
}
