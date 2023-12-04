package se.miun.whiteboiz.entities;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.io.Serializable;

public class LunchVeckaEntityPK implements Serializable {

    private int dagId;

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

        LunchVeckaEntityPK that = (LunchVeckaEntityPK) o;

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
