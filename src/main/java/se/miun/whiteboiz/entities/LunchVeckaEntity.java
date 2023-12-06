package se.miun.whiteboiz.entities;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "lunch_vecka", schema = "antonsskafferi", catalog = "")
@IdClass(LunchVeckaEntityPK.class)
public class LunchVeckaEntity {
    @Id
    @ManyToOne
    @JoinColumn(name = "dag_id")
    private DagEntity dagId;
    @Id
    @ManyToOne
    @JoinColumn(name = "lunch_id")
    private LunchEntity lunchId;

    public LunchVeckaEntity() {
    }

    public LunchVeckaEntity(DagEntity dagId, LunchEntity lunchId) {
        this.dagId = dagId;
        this.lunchId = lunchId;
    }

    public DagEntity getDagId() {
        return dagId;
    }

    public void setDagId(int DagEntity) {
        this.dagId = dagId;
    }

    public LunchEntity getLunchId() {
        return lunchId;
    }

    public void setLunchId(int LunchEntity) {
        this.lunchId = lunchId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LunchVeckaEntity that = (LunchVeckaEntity) o;
        return Objects.equals(dagId, that.dagId) && Objects.equals(lunchId, that.lunchId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dagId, lunchId);
    }
}
