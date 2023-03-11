package entity;

import javax.persistence.*;

@Entity
public class StudentDetail {
    @Id
    @GeneratedValue
    private int id;

    @Column(nullable = false)
    private String enrolledDate;

    @Column(nullable = false)
    private String adress;

    @Column(nullable = false)
    private String telefoon_nummer;

    @Column(nullable = false)
    private String geboorteDatum;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEnrolledDate() {
        return enrolledDate;
    }

    public void setEnrolledDate(String enrolledDate) {
        this.enrolledDate = enrolledDate;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getTelefoon_nummer() {
        return telefoon_nummer;
    }

    public void setTelefoon_nummer(String telefoon_nummer) {
        this.telefoon_nummer = telefoon_nummer;
    }

    public String getGeboorteDatum() {
        return geboorteDatum;
    }

    public void setGeboorteDatum(String geboorteDatum) {
        this.geboorteDatum = geboorteDatum;
    }

    @Override
    public String toString() {
        return "StudentDetail{" +
                "id=" + id +
                ", enrolledDate='" + enrolledDate + '\'' +
                ", adress='" + adress + '\'' +
                ", telefoon_nummer='" + telefoon_nummer + '\'' +
                ", geboorteDatum='" + geboorteDatum + '\'' +
                '}';
    }
}
