package sr.unasat.RESTful_webservice;

import entity.Docent;
import service.DocentService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/docenten")
public class DocentController {

    private final DocentService docentService = new DocentService();

    @Path("/alle-docenten")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Docent> alleDocenten(){
        return docentService.getAllDocenten();
    }
}
