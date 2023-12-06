package se.miun.whiteboiz.entities;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "ratt_instans", schema = "antonsskafferi")
@IdClass(RattInstansEntityPK.class)
public class RattInstansEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    private BestallningEntity bestallning;

    @Id
    @ManyToOne
    @JoinColumn(name = "alacarte_id")
    private AlacarteEntity alacarte;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public TypEntity getTag() {
        return tag;
    }

    public void setTag(TypEntity tag) {
        this.tag = tag;
    }

    public String getRattPreferenser() {
        return rattPreferenser;
    }

    public void setRattPreferenser(String rattPreferenser) {
        this.rattPreferenser = rattPreferenser;
    }

    public BestallningEntity getBestallning() {
        return bestallning;
    }

    public void setBestallning(BestallningEntity bestallning) {
        this.bestallning = bestallning;
    }

    public AlacarteEntity getAlacarte() {
        return alacarte;
    }

    public void setAlacarte(AlacarteEntity alacarte) {
        this.alacarte = alacarte;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RattInstansEntity that = (RattInstansEntity) o;
        return id == that.id && Objects.equals(tag, that.tag) && Objects.equals(rattPreferenser, that.rattPreferenser) && Objects.equals(bestallning, that.bestallning) && Objects.equals(alacarte, that.alacarte);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, tag, rattPreferenser, bestallning, alacarte);
    }
}
