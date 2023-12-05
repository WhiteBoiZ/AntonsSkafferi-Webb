package se.miun.whiteboiz.entities;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "ratt_instans", schema = "antonsskafferi", catalog = "")
@IdClass(RattInstansEntityPK.class)
public class RattInstansEntity {
    @Id
    @Column(name = "id")
    private int id;
    @ManyToOne
    @JoinColumn(name = "tag_id")
    private TypEntity tag;

    @Basic
    @Column(name = "ratt_preferenser")
    private String rattPreferenser;
    @Id
    @ManyToOne
    @JoinColumn(name = "bestallning_id")
    private BestallningEntity bestallningId;

    @Id
    @ManyToOne
    @JoinColumn(name = "alacarte_id")
    private AlacarteEntity alacarteId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public TypEntity getTagId() {
        return tag;
    }

    public void setTagId(Integer TypEntity) {
        this.tag = tag;
    }

    public String getRattPreferenser() {
        return rattPreferenser;
    }

    public void setRattPreferenser(String rattPreferenser) {
        this.rattPreferenser = rattPreferenser;
    }

    public BestallningEntity getBestallningId() {
        return bestallningId;
    }

    public void setBestallningId(int BestallningEntity) {
        this.bestallningId = bestallningId;
    }

    public AlacarteEntity getAlacarteId() {
        return alacarteId;
    }

    public void setAlacarteId(int AlacarteEntity) {
        this.alacarteId = alacarteId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RattInstansEntity that = (RattInstansEntity) o;
        return id == that.id && Objects.equals(tag, that.tag) && Objects.equals(rattPreferenser, that.rattPreferenser) && Objects.equals(bestallningId, that.bestallningId) && Objects.equals(alacarteId, that.alacarteId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, tag, rattPreferenser, bestallningId, alacarteId);
    }
}
