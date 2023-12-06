package se.miun.whiteboiz.rest;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import se.miun.whiteboiz.AlacarteService;
import se.miun.whiteboiz.entities.AlacarteEntity;

import java.util.List;

@Path("/alacarte")
public class AlacarteResource {

    @Inject
    AlacarteService alacarteService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/all")
    public List<AlacarteEntity> findAllAlacarte() {
        return alacarteService.findAllAlacarte();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/id/{id}")
    public AlacarteEntity findAlacarte(@PathParam("id") int id) {
        return alacarteService.findAlacarte(id);
    }


}