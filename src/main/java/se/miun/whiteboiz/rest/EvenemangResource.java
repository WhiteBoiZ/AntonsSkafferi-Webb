package se.miun.whiteboiz.rest;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.Path;
import se.miun.whiteboiz.EvenemangService;
import se.miun.whiteboiz.entities.EvenemangEntity;

import java.util.List;

@Path("/evenemang")

public class EvenemangResource {
    @Inject
    EvenemangService evenemangService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/all")
    public List<EvenemangEntity> findAllEvenemang() {
        return evenemangService.findAllEvenemang();
    }
}
