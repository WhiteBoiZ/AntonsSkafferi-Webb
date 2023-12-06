package se.miun.whiteboiz.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "typ", schema = "antonsskafferi")
public class TypEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "namn")
    private String namn;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNamn() {
        return namn;
    }

    public void setNamn(String namn) {
        this.namn = namn;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TypEntity typEntity = (TypEntity) o;

        if (id != typEntity.id) return false;
        if (namn != null ? !namn.equals(typEntity.namn) : typEntity.namn != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (namn != null ? namn.hashCode() : 0);
        return result;
    }
}
