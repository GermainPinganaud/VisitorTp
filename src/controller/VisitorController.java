package controller;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/visitor")
public class VisitorController {
	
    @GET
    @Path("/get")
    public String thisIsAGet() {
        return "This is a get";
    }
    
	@POST
	@Path("/post")
	@Consumes("application/json")
	@Produces("application/json")
	public String thisIsAPost() {
		return "This is a post";
	}
	
}

