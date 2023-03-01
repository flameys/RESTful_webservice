package entity;

import javax.persistence.*;

@Entity
public class Docent {
    @Id
    @GeneratedValue
    private int id;

    @Column(nullable = false)
    private String naam;

    @Column(nullable = false)
    private String voornaam;

    @Column(nullable = false)
    private String categorie;//dans, taal of gamelan

    @Column(nullable = false)
    private String datumIndienst;

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

    public String getVoornaam() {
        return voornaam;
    }

    public void setVoornaam(String voornaam) {
        this.voornaam = voornaam;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public String getDatumIndienst() {
        return datumIndienst;
    }

    public void setDatumIndienst(String datumIndienst) {
        this.datumIndienst = datumIndienst;
    }
}
