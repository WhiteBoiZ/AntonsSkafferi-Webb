package se.miun.whiteboiz.entities;

import java.io.Serializable;

public class LunchVeckaEntityPK implements Serializable {

    private int dag;

    private int lunch;

    public int getDag() {
        return dag;
    }

    public void setDag(int dag) {
        this.dag = dag;
    }

    public int getLunch() {
        return lunch;
    }

    public void setLunch(int lunch) {
        this.lunch = lunch;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LunchVeckaEntityPK that = (LunchVeckaEntityPK) o;

        if (dag != that.dag) return false;
        if (lunch != that.lunch) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = dag;
        result = 31 * result + lunch;
        return result;
    }
}
