package se.miun.whiteboiz.rest;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import se.miun.whiteboiz.LunchService;

@Path("/hello")
public class HelloResource {

    @GET
    public String sayHello() {
        return "Hello World";
    }
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/{name}")
    public String doGreeting(@PathParam("name") String someValue,
                             @QueryParam("language") String language)
    {
        return "Hello " + someValue + " with language " + language;
    }
}
