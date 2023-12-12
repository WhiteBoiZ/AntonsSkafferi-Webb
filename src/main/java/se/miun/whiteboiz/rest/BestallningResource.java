package se.miun.whiteboiz.rest;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import se.miun.whiteboiz.entities.BestallningEntity;
import se.miun.whiteboiz.BestallningService;
import se.miun.whiteboiz.entities.RattInstansEntity;
import se.miun.whiteboiz.entities.BordEntity;

import java.util.List;

@Path("/bestallning")
public class BestallningResource {

    @Inject
    BestallningService bestallningService;

    //http://localhost:8080/Antons-Skafferi-Webb-1.0-SNAPSHOT/api/bestallning/id/1
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/id/{id}")
    public BestallningEntity findBestallning(@PathParam("id") int id) {
        return bestallningService.findBestallning(id);
    }



    //http://localhost:8080/Antons-Skafferi-Webb-1.0-SNAPSHOT/api/bestallning/all
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/all")
    public List<BestallningEntity> findAllBestallningar() {
        return bestallningService.findAllBestallningar();
    }


    //http://localhost:8080/Antons-Skafferi-Webb-1.0-SNAPSHOT/api/bestallning?datum=2021-10-10&tid=12:00&kommentar=hej&bordId=1
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public void addBestallning(@QueryParam("datum") String datum,
                               @QueryParam("tid") String tid,
                               @QueryParam("kommentar") String kommentar,
                               @QueryParam("bordId") int bordId)
    {
        bestallningService.addBestallning(datum, tid, kommentar, bordId);
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
    public RattInstansEntity findRattInstans(@QueryParam("id") int id,
                                             @QueryParam("alacarteId") int alacarteId,
                                             @QueryParam("bestallningId") int bestallningId)
    {
        return bestallningService.findRattInstans(id, alacarteId, bestallningId);
    }

    //http://localhost:8080/Antons-Skafferi-Webb-1.0-SNAPSHOT/api/bestallning/rattinstans?bestallningId=1
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/rattinstans/bestallning")
    public List<RattInstansEntity> findRattInstansByBestallningId(@QueryParam("bestallningId") int bestallningId) {
        return bestallningService.findRattInstansByBestallningId(bestallningId);
    }

    //http://localhost:8080/Antons-Skafferi-Webb-1.0-SNAPSHOT/api/bestallning/rattinstans?tagId=1&bestallningId=1&alacarteId=1&ratt_preferenser=hej
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/rattinstans")
    public void addRattInstans(@QueryParam("tagId") int tagId,
                               @QueryParam("bestallningId") int bestallningId,
                               @QueryParam("alacarteId") int alacarteId,
                               @QueryParam("ratt_preferenser") String ratt_preferenser)
    {
        bestallningService.addRattInstans(tagId, bestallningId, alacarteId, ratt_preferenser);
    }







}
