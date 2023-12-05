package se.miun.whiteboiz.rest;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import se.miun.whiteboiz.entities.BestallningEntity;
import se.miun.whiteboiz.BestallningService;

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

}
