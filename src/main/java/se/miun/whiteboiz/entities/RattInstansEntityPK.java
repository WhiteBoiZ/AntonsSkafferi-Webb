package se.miun.whiteboiz.entities;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.io.Serializable;

public class RattInstansEntityPK implements Serializable {
    private int id;
    private int bestallningId;
    private int alacarteId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

        RattInstansEntityPK that = (RattInstansEntityPK) o;

        if (id != that.id) return false;
        if (bestallningId != that.bestallningId) return false;
        if (alacarteId != that.alacarteId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + bestallningId;
        result = 31 * result + alacarteId;
        return result;
    }
}
