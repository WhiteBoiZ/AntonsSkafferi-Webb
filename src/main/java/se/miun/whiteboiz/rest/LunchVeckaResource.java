package se.miun.whiteboiz.rest;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import se.miun.whiteboiz.LunchService;
import se.miun.whiteboiz.entities.LunchVeckaEntity;

import java.util.List;

@Path("/lunchvecka")
public class LunchVeckaResource {
    @Inject
    LunchService lunchService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/all")
    public List<LunchVeckaEntity> getAllLunchesForWeek() {
        return lunchService.findAllLunchesForWeek();
    }
}
