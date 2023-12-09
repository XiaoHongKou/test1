package edu.iit.sat.itmd4515.xkou.resources;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;

/**
 *
 * @author  xiaoh
 */
@Path("jakartaee10")
public class JakartaEE10Resource {
    
    /**
     *
     * Handles the HTTP GET request to check the availability of this service.
     * 
     * @return A Response object with a message indicating that the Jakarta EE service is reachable.
     */
    @GET
    public Response ping(){
        return Response
                .ok("ping Jakarta EE")
                .build();
    }
}
