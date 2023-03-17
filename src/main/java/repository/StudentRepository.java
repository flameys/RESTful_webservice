package repository;

import entity.Docent;
import entity.Student;
import entity.StudentDetail;
import entity.courses.Onderdeel;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

public class StudentRepository {
    private EntityManager entityManager;

    public StudentRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    // CREATE
    public Student createStudent(Student addStudent){
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(addStudent);
            entityManager.getTransaction().commit();
        }
        catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }

        return addStudent;
    }

    // READ-ALL
    public List<Student> getStudents() {
        String query = "select s from Student s";
        TypedQuery<Student> typedQuery = entityManager.createQuery(query, Student.class);
        List<Student> studentList = typedQuery.getResultList();
        return studentList;
    }

    // READ or GET 1 RECORD
    public Student getStudentByName(String studentVoornaam, String studentAchternaam) {
        Query query = entityManager.createQuery("select s from Student s where s.voornaam = :voornaam " +
                "and s.achternaam = :achternaam");
        query.setParameter("voornaam", studentVoornaam);
        query.setParameter("achternaam", studentAchternaam);
        Student result = (Student) query.getSingleResult();

        return result;
    }

    public Student getStudentById(int studentId) {
        Query query = entityManager.createQuery("select s from Student s where s.id = :id ");
        query.setParameter("id", studentId);
        Student result = (Student) query.getSingleResult();

        return result;
    }

    public List<Onderdeel> getStudentOnderdeel(String voornaam, String achternaam){
        Query query = entityManager.createQuery("select s.onderdelen from Student s where s.voornaam = :voornaam " +
                "and s.achternaam = :achternaam");
        query.setParameter("voornaam", voornaam);
        query.setParameter("achternaam", achternaam);
        List<Onderdeel> result = (List<Onderdeel>) query.getResultList();

        return result;
    }

// UPDATE

    public Student updateStudent(Student student){
        entityManager.getTransaction().begin();
        entityManager.merge(student);
        entityManager.getTransaction().commit();

        return student;
    }
    // DELETE ALL RECORDS
    public int deleteAllStudents(){
        int rowsDeleted;
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("DELETE from Student s");
        rowsDeleted = query.executeUpdate();
        System.out.println("Records deleted: " + rowsDeleted);
        entityManager.getTransaction().commit();
        return rowsDeleted;
    }

    // DELETE SPECIFIC RECORD
    public int deleteStudentByName(String studentVoornaam, String studentAchternaam){
        int rowsDeleted;
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("delete from Student s where s.voornaam = :voornaam " +
                "and s.achternaam = :achternaam");
        query.setParameter("voornaam", studentVoornaam);
        query.setParameter("achternaam", studentAchternaam);
        rowsDeleted = query.executeUpdate();
        System.out.println("Records deleted: " + rowsDeleted);
        entityManager.getTransaction().commit();
        return rowsDeleted;

    }

    public void deleteStudentOnderdelen(String studentVoornaam, String studentAchternaam){
        int rowsDeleted;
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("select s from Student s where s.voornaam = :voornaam and s.achternaam = :achternaam");
        query.setParameter("voornaam", studentVoornaam);
        query.setParameter("achternaam", studentAchternaam);
        Student student = (Student) query.getSingleResult();

        for (Onderdeel o: student.getOnderdelen()){
            entityManager.remove(o);
        }

    }

    // DELETE Student ENTITY OBJECT AND ITS OTHER ASSOCIATED ENTITY'S OBJECTS (that referenced them)
    public void deleteStudent(Student student){
        try {
            entityManager.getTransaction().begin();
            System.out.println("Student record: " + student.getVoornaam() + " " +
                    student.getAchternaam() + " " + "has been deleted.");
            entityManager.remove(student);
            entityManager.getTransaction().commit();
        }
        catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }


    }
}
