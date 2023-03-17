package sr.unasat.RESTful_webservice;

import entity.Student;
import entity.StudentDetail;
import service.StudentDetailService;
import service.StudentService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/studenten")
public class StudentController {

    private final StudentService studentService = new StudentService();
    private final StudentDetailService studentDetailService = new StudentDetailService();

    @Path("/alle-studenten")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Student> alleStudenten() {
        return studentService.getAllStudents();
    }

    @Path("/getStudent/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Student onderdeelDocent(@PathParam("id") int id){
        return studentService.getStudentById(id);
    }

    @Path("/insert-student")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Student insertStudent(Student aStudent){return studentService.insertStudent(aStudent);}

    @Path("/delete-student/{id}")
    @DELETE
    public void deleteStudent(@PathParam("id") int id){
        Student delStudent = studentService.getStudentById(id);
        studentService.deleteStudent(delStudent);
    }

    @Path("/update-student/{id}")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Student updateStudent(@PathParam("id") int id, Student student){
        student.setId(id);
        return studentService.updateStudent(student);
    }


    @Path("/update-studentDetail/{id}")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public StudentDetail updateStudentDetail(@PathParam("id") int id, Student student){
       student.setId(id);
        return studentDetailService.updateStudentDetail(student.getStudentDetail());
    }

    @Path("/update-studentAdres/{id}")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public StudentDetail updateAdres(@PathParam("id") int id, String adres){
        Student getStudent = studentService.getStudentById(id);
        StudentDetail adresDetail = getStudent.getStudentDetail();
        adresDetail.setAdress(adres);
        return studentDetailService.updateStudentDetail(adresDetail);
    }

    @Path("/update-studentTelno/{id}")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public StudentDetail updateTelno(@PathParam("id") int id, String tel){
        Student getStudent = studentService.getStudentById(id);
        StudentDetail telDetail = getStudent.getStudentDetail();
        telDetail.setTelefoon_nummer(tel);
        return studentDetailService.updateStudentDetail(telDetail);
    }
}
