package tech.dimas.example.resources;

import io.dropwizard.auth.Auth;
import tech.dimas.example.api.User;

import javax.annotation.security.PermitAll;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@PermitAll
@Path("/greeting")
public class GreetingResource {

    @GET
    public String greet(@Auth User user) {
        return String.format("Hello, %s!", user.getName());
    }

}