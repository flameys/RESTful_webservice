package entity.courses;

import javax.persistence.*;

@Entity
public class Richting {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(nullable = false)
    private String naam;

    @ManyToOne
    @JoinColumn (name = "fk_opleiding")
    private Opleiding opleiding;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public Opleiding getOpleiding() {
        return opleiding;
    }

    public void setOpleiding(Opleiding opleiding) {
        this.opleiding = opleiding;
    }

    @Override
    public String toString() {
        return "Richting{" +
                "id=" + id +
                ", naam='" + naam + '\'' +
                ", opleiding=" + opleiding +
                '}';
    }
}
