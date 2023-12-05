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
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public LunchEntity getLunchById(@QueryParam("lunch_id") int lunch_id) {
        return lunchService.findLunch(lunch_id);
    }
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/all")
    public List<LunchEntity> getAllLunches() {
        return lunchService.findAllLunches();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/vecka/all")
    public List<LunchVeckaEntity> getAllLunchesForWeek() {
        return lunchService.findAllLunchesForWeek();
    }


}
