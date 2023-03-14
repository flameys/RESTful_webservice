package sr.unasat.RESTful_webservice;

import entity.Docent;
import entity.courses.Onderdeel;
import entity.courses.Opleiding;
import entity.courses.Richting;
import service.DocentService;
import service.OnderdeelService;
import service.OpleidingService;
import service.RichtingService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/opleidingen")
public class OpleidingController {

    private final OpleidingService opleidingService = new OpleidingService();
    private final RichtingService richtingService = new RichtingService();
    private final OnderdeelService onderdeelService = new OnderdeelService();
    private final DocentService docentService1 = new DocentService();

    @Path("/alle-opleidingen")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Opleiding> alleOpleidingen() {
        return opleidingService.getAllOpleidingen();
    }


    @Path("/alle-richtingen")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Richting> alleRichtingenVanOpleiding(int opleidingId) {
        return richtingService.getAllRichtingOpleiding(opleidingId);
    }

    @Path("/onderdelen-docent/{delete-id}")
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    public int removeDocent(@PathParam("delete-id") int id){
        Docent delDocent = docentService1.getDocentById(id);
        return onderdeelService.removeDocent(delDocent.getNaam());
    }

    @Path("/onderdelen-docent/{put-id}")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Onderdeel addDocent(@PathParam("put-id") int id){
        Docent putDocent = docentService1.getDocentById(id);
        Onderdeel docentObject = new Onderdeel();
        docentObject.setDocent(putDocent);
        return onderdeelService.addDocent1(docentObject);
    }

    @Path("/onderdelen-docent/{add-docent}")
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    public int addDocent1(@PathParam("add-docent") int docentId, String onderdeelNaam){
        Docent getDocent = docentService1.getDocentById(docentId);
        return onderdeelService.addDocent(getDocent.getId(), onderdeelNaam);
    }

}