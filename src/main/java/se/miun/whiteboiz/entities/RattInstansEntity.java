package se.miun.whiteboiz.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "ratt_instans", schema = "antonsskafferi", catalog = "")
@IdClass(RattInstansEntityPK.class)
public class RattInstansEntity {
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "tag_id")
    private Integer tagId;
    @Basic
    @Column(name = "ratt_preferenser")
    private String rattPreferenser;
    @Id
    @Column(name = "bestallning_id")
    private int bestallningId;
    @Id
    @Column(name = "alacarte_id")
    private int alacarteId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getTagId() {
        return tagId;
    }

    public void setTagId(Integer tagId) {
        this.tagId = tagId;
    }

    public String getRattPreferenser() {
        return rattPreferenser;
    }

    public void setRattPreferenser(String rattPreferenser) {
        this.rattPreferenser = rattPreferenser;
    }

    public int getBestallningId() {
        return bestallningId;
    }

    public void setBestallningId(int bestallningId) {
        this.bestallningId = bestallningId;
    }

    public int getAlacarteId() {
        return alacarteId;
    }

    public void setAlacarteId(int alacarteId) {
        this.alacarteId = alacarteId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RattInstansEntity that = (RattInstansEntity) o;

        if (id != that.id) return false;
        if (bestallningId != that.bestallningId) return false;
        if (alacarteId != that.alacarteId) return false;
        if (tagId != null ? !tagId.equals(that.tagId) : that.tagId != null) return false;
        if (rattPreferenser != null ? !rattPreferenser.equals(that.rattPreferenser) : that.rattPreferenser != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (tagId != null ? tagId.hashCode() : 0);
        result = 31 * result + (rattPreferenser != null ? rattPreferenser.hashCode() : 0);
        result = 31 * result + bestallningId;
        result = 31 * result + alacarteId;
        return result;
    }
}
