package sr.unasat.RESTful_webservice;

import entity.Student;
import service.StudentService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/students")
public class StudentController {

    private final StudentService studentService = new StudentService();

@Path("/alle-studenten")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Student> alleStudenten() {
        return studentService.getAllStudents();
    }


}
