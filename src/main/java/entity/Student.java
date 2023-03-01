package entity;

import entity.courses.Onderdeel;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Student {
    @Id
    @GeneratedValue
    private int id;

    @Column(nullable = false)
    private String voornaam;

    @Column(nullable = false)
    private String achternaam;

    @Column(nullable = false, unique = true)
    private String studentID;

    @OneToOne(cascade = CascadeType.REMOVE)
    private StudentDetail studentDetail;

    @ManyToMany
    @JoinTable(name = "student_onderdeel",
            joinColumns = { @JoinColumn(name = "fk_student") },
            inverseJoinColumns = { @JoinColumn(name = "fk_onderdeel")} )
    private List<Onderdeel> onderdelen = new ArrayList<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVoornaam() {
        return voornaam;
    }

    public void setVoornaam(String voornaam) {
        this.voornaam = voornaam;
    }

    public String getAchternaam() {
        return achternaam;
    }

    public void setAchternaam(String achternaam) {
        this.achternaam = achternaam;
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public StudentDetail getStudentDetail() {
        return studentDetail;
    }

    public void setStudentDetail(StudentDetail studentDetail) {
        this.studentDetail = studentDetail;
    }

    public List<Onderdeel> getOnderdelen() {
        return onderdelen;
    }

    public void setOnderdelen(List<Onderdeel> onderdelen) {
        this.onderdelen = onderdelen;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", voornaam='" + voornaam + '\'' +
                ", achternaam='" + achternaam + '\'' +
                ", studentID='" + studentID + '\'' +
                ", studentDetail=" + studentDetail +
                ", onderdelen=" + onderdelen +
                '}';
    }
}
