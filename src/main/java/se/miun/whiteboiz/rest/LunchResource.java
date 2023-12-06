package se.miun.whiteboiz.rest;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import se.miun.whiteboiz.LunchService;
import se.miun.whiteboiz.entities.LunchEntity;
import se.miun.whiteboiz.entities.LunchVeckaEntity;

import java.util.List;


@Path("/lunch")
public class LunchResource {

    @Inject
    LunchService lunchService;

    //http://localhost:8080/Antons-Skafferi-Webb-1.0-SNAPSHOT/api/lunch/id/1
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/id/{lunch_id}")
    public LunchEntity getLunchById(@PathParam("lunch_id") int lunch_id) {
        return lunchService.findLunch(lunch_id);
    }

    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/id/{lunch_id}")
    public void deleteLunchById(@PathParam("lunch_id") int lunch_id) {
        lunchService.deleteLunch(lunch_id);
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public void addLunch(@QueryParam("titel") String titel, @QueryParam("beskrivning") String beskrivning) {
        LunchEntity lunch = new LunchEntity();
        lunch.setTitel(titel);
        lunch.setBeskrivning(beskrivning);
        lunchService.addLunch(lunch);
    }



    //http://localhost:8080/Antons-Skafferi-Webb-1.0-SNAPSHOT/api/lunch/all
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/all")
    public List<LunchEntity> getAllLunches() {
        return lunchService.findAllLunches();
    }

    //http://localhost:8080/Antons-Skafferi-Webb-1.0-SNAPSHOT/api/lunch/vecka/all
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/vecka/all")
    public List<LunchVeckaEntity> getAllLunchesForWeek() {
        return lunchService.findLunchesForDayWeekNumber();
    }

    //http://localhost:8080/Antons-Skafferi-Webb-1.0-SNAPSHOT/api/lunch/vecka?dag_id=1&lunch_id=1
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/vecka")
    public LunchVeckaEntity getLunchVecka(@QueryParam("dag_id") int dag_id, @QueryParam("lunch_id") int lunch_id) {
        return lunchService.findLunchVecka(dag_id, lunch_id);
    }


}
