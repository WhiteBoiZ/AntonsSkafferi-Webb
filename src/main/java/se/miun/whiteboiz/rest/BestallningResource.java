package se.miun.whiteboiz.rest;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import se.miun.whiteboiz.entities.BestallningEntity;
import se.miun.whiteboiz.BestallningService;
import se.miun.whiteboiz.entities.RattInstansEntity;

import java.util.List;

@Path("/bestallning")
public class BestallningResource {

    @Inject
    BestallningService bestallningService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/all")
    public List<BestallningEntity> findAllBestallningar() {
        return bestallningService.findAllBestallningar();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/id/{id}")
    public BestallningEntity findBestallning(@PathParam("id") int id) {
        return bestallningService.findBestallning(id);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/rattinstans/all")
    public List<RattInstansEntity> findAllRattInstans() {
            return bestallningService.findAllRattInstans();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/rattinstans/id/{id}")
    public RattInstansEntity findRattInstans(@PathParam("id") int id) {
        return bestallningService.findRattInstans(id);
    }

}
