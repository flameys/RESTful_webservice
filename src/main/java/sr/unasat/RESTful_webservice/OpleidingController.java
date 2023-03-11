package sr.unasat.RESTful_webservice;

import entity.courses.Opleiding;
import entity.courses.Richting;
import service.OpleidingService;
import service.RichtingService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/opleidingen")
public class OpleidingController {

    private final OpleidingService opleidingService = new OpleidingService();
    private final RichtingService richtingService = new RichtingService();

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

}