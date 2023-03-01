package entity.courses;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class ModuleDuur {
    @Id
    @GeneratedValue
    private int id;

    @Column(nullable = false)
    private String naam;

    @Column(nullable = false)
    private String duur;

    @ManyToOne
    @JoinColumn(name = "fk_richting")
    private Richting richting;

    @OneToMany(mappedBy = "module")
    private List<Onderdeel> onderdelen = new ArrayList<Onderdeel>();

    public int getId() {return id;}

    public void setId(int id) {
        this.id = id;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public String getDuur() {
        return duur;
    }

    public void setDuur(String duur) {
        this.duur = duur;
    }

    public Richting getRichting() {
        return richting;
    }

    public void setRichting(Richting richting) {
        this.richting = richting;
    }

    public List<Onderdeel> getOnderdelen() {
        return onderdelen;
    }

    public void setOnderdelen(List<Onderdeel> onderdelen) {
        this.onderdelen = onderdelen;
    }

// ---- method for bidirectional association with Onderdeel class ----

    public void addOnderdeel(Onderdeel onderdeel){
        this.onderdelen.add(onderdeel);
        onderdeel.setModule(this);
    }

    public void removeOnderdeel(Onderdeel onderdeel){
        onderdeel.setModule(null);
        this.onderdelen.remove(onderdeel);
    }

}
