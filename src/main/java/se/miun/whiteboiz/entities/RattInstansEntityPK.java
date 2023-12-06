package se.miun.whiteboiz.entities;

import java.io.Serializable;

public class RattInstansEntityPK implements Serializable {
    private int id;
    private int bestallning;
    private int alacarte;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBestallning() {
        return bestallning;
    }

    public void setBestallning(int bestallning) {
        this.bestallning = bestallning;
    }

    public int getAlacarte() {
        return alacarte;
    }

    public void setAlacarte(int alacarte) {
        this.alacarte = alacarte;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RattInstansEntityPK that = (RattInstansEntityPK) o;

        if (id != that.id) return false;
        if (bestallning != that.bestallning) return false;
        if (alacarte != that.alacarte) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + bestallning;
        result = 31 * result + alacarte;
        return result;
    }
}
