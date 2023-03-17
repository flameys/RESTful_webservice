package sr.unasat.RESTful_webservice;

import entity.Docent;
import entity.courses.Onderdeel;
import service.DocentService;
import service.OnderdeelService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/docenten")
public class DocentController {

    private final DocentService docentService = new DocentService();
    private final OnderdeelService onderdeelService = new OnderdeelService();

    @Path("/alle-docenten")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Docent> alleDocenten(){
        return docentService.getAllDocenten();
    }


    @Path("/docent-onderdelen/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Onderdeel> onderdeelDocent(@PathParam("id") int id){
        Docent docent = docentService.getDocentById(id);
        return onderdeelService.getOnderdeelNamenByDocent(docent.getId());
    }

    @Path("/insert-docent")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Docent insertDocent(Docent aDocent){return docentService.insertDocent(aDocent);}

    @Path("/delete-docent/{id}")
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    public void deleteDocent(@PathParam("id") int id){
        Docent docent = docentService.getDocentById(id);
        onderdeelService.removeDocent(docent.getNaam());
        docentService.deleteDocent(docent);
    }

}
