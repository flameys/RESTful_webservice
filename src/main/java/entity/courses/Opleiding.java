package entity.courses;

import javax.persistence.*;

@Entity
public class Opleiding {
    @Id
    @GeneratedValue
    private int id;

    @Column(nullable = false, unique = true)
    private String naam;

    public int getId() { return id;}

    public void setId(int id) {
        this.id = id;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    @Override
    public String toString() {
        return "Opleiding{" +
                "id=" + id +
                ", naam='" + naam + '\'' +
                '}';
    }
}
