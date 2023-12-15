package se.miun.whiteboiz.entities;

import jakarta.persistence.*;


@Entity
@Table(name = "bestallning", schema = "antonsskafferi")
public class BestallningEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "datum")
    private String datum;
    @Basic
    @Column(name = "tid")
    private String tid;
    @Basic
    @Column(name = "kommentar")
    private String kommentar;
    @ManyToOne
    @JoinColumn(name = "bord_id")
    private BordEntity bord;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getKommentar() {
        return kommentar;
    }

    public void setKommentar(String kommentar) {
        this.kommentar = kommentar;
    }

    public BordEntity getBordId() {
        return bord;
    }

    public void setBordId(BordEntity bord) {
        this.bord = bord;
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
        if (bord != null ? !bord.equals(that.bord) : that.bord != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (datum != null ? datum.hashCode() : 0);
        result = 31 * result + (tid != null ? tid.hashCode() : 0);
        result = 31 * result + (kommentar != null ? kommentar.hashCode() : 0);
        result = 31 * result + (bord != null ? bord.hashCode() : 0);
        return result;
    }
}
