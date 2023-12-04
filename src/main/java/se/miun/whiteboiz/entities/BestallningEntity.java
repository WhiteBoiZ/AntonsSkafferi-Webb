package se.miun.whiteboiz.entities;

import jakarta.persistence.*;

import java.sql.Date;
import java.sql.Time;

@Entity
@Table(name = "bestallning", schema = "antonsskafferi", catalog = "")
public class BestallningEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "datum")
    private Date datum;
    @Basic
    @Column(name = "tid")
    private Time tid;
    @Basic
    @Column(name = "kommentar")
    private String kommentar;
    @Basic
    @Column(name = "bord_id")
    private Integer bordId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public Time getTid() {
        return tid;
    }

    public void setTid(Time tid) {
        this.tid = tid;
    }

    public String getKommentar() {
        return kommentar;
    }

    public void setKommentar(String kommentar) {
        this.kommentar = kommentar;
    }

    public Integer getBordId() {
        return bordId;
    }

    public void setBordId(Integer bordId) {
        this.bordId = bordId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BestallningEntity that = (BestallningEntity) o;

        if (id != that.id) return false;
        if (datum != null ? !datum.equals(that.datum) : that.datum != null) return false;
        if (tid != null ? !tid.equals(that.tid) : that.tid != null) return false;
        if (kommentar != null ? !kommentar.equals(that.kommentar) : that.kommentar != null) return false;
        if (bordId != null ? !bordId.equals(that.bordId) : that.bordId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (datum != null ? datum.hashCode() : 0);
        result = 31 * result + (tid != null ? tid.hashCode() : 0);
        result = 31 * result + (kommentar != null ? kommentar.hashCode() : 0);
        result = 31 * result + (bordId != null ? bordId.hashCode() : 0);
        return result;
    }
}
