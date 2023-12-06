package se.miun.whiteboiz.entities;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "lunch_vecka", schema = "antonsskafferi")
@IdClass(LunchVeckaEntityPK.class)
public class LunchVeckaEntity {
    @Id
    @ManyToOne
    @JoinColumn(name = "dag_id")
    private DagEntity dag;
    @Id
    @ManyToOne
    @JoinColumn(name = "lunch_id")
    private LunchEntity lunch;

    public DagEntity getDag() {
        return dag;
    }

    public void setDag(int DagEntity) {
        this.dag = dag;
    }

    public LunchEntity getLunch() {
        return lunch;
    }

    public void setLunch(int LunchEntity) {
        this.lunch = lunch;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LunchVeckaEntity that = (LunchVeckaEntity) o;
        return Objects.equals(dag, that.dag) && Objects.equals(lunch, that.lunch);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dag, lunch);
    }
}
