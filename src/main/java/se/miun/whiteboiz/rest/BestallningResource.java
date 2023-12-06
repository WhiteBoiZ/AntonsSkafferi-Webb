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


    //http://localhost:8080/Antons-Skafferi-Webb-1.0-SNAPSHOT/api/bestallning/all
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/all")
    public List<BestallningEntity> findAllBestallningar() {
        return bestallningService.findAllBestallningar();
    }


    //http://localhost:8080/Antons-Skafferi-Webb-1.0-SNAPSHOT/api/bestallning/id/1
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/id/{id}")
    public BestallningEntity findBestallning(@PathParam("id") int id) {
        return bestallningService.findBestallning(id);
    }


    //http://localhost:8080/Antons-Skafferi-Webb-1.0-SNAPSHOT/api/bestallning/rattinstans/all
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/rattinstans/all")
    public List<RattInstansEntity> findAllRattInstans() {
            return bestallningService.findAllRattInstans();
    }


    //http://localhost:8080/Antons-Skafferi-Webb-1.0-SNAPSHOT/api/bestallning/rattinstans?id=1&alacarteId=1&bestallningId=1
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/rattinstans")
    public RattInstansEntity findRattInstans(@QueryParam("id") int id, @QueryParam("alacarteId") int alacarteId, @QueryParam("bestallningId") int bestallningId) {
        return bestallningService.findRattInstans(id, alacarteId, bestallningId);
    }

}
