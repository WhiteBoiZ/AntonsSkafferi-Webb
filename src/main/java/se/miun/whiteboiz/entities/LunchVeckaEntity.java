package se.miun.whiteboiz.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "lunch_vecka", schema = "antonsskafferi", catalog = "")
@IdClass(LunchVeckaEntityPK.class)
public class LunchVeckaEntity {
    @Id
    @Column(name = "dag_id")
    private int dagId;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "lunch_id")
    private int lunchId;

    public int getDagId() {
        return dagId;
    }

    public void setDagId(int dagId) {
        this.dagId = dagId;
    }

    public int getLunchId() {
        return lunchId;
    }

    public void setLunchId(int lunchId) {
        this.lunchId = lunchId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LunchVeckaEntity that = (LunchVeckaEntity) o;

        if (dagId != that.dagId) return false;
        if (lunchId != that.lunchId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = dagId;
        result = 31 * result + lunchId;
        return result;
    }
}
