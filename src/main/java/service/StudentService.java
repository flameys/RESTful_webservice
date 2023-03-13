package service;

import configuration.JPAConfiguration;
import entity.Student;
import entity.courses.Onderdeel;
import repository.StudentRepository;

import java.util.List;

public class StudentService {
    private final StudentRepository repository;

    public StudentService() {
        this.repository = new StudentRepository(JPAConfiguration.getEntityManager());
    }

    public Student insertStudent(Student student) {
        return repository.createStudent(student);
    }

    public List<Student> getAllStudents() {
        return repository.getStudents();
    }

    public Student getStudentByName(String studentVoornaam, String studentAchternaam){
        return repository.getStudentByName(studentVoornaam, studentAchternaam);}

    public Student getStudentById(int studentId){return repository.getStudentById(studentId);}

    public List<Onderdeel> getOnderdeelVanStudent(String stVoornaam, String stAchternaam){
        return this.repository.getStudentOnderdeel(stVoornaam, stAchternaam);
    }
    public int deleteStudent(String voornaam, String achternaam){
        return repository.deleteStudentByName(voornaam, achternaam);
    }

}
