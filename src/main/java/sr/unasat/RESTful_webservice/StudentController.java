package sr.unasat.RESTful_webservice;

import entity.Student;
import service.StudentService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/studenten")
public class StudentController {

    private final StudentService studentService = new StudentService();

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

}
