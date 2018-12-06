package controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/controller")
public class ExempleController {
	
	@GET
	@Path("/exemple")
	public String direBonjour() {
		return "Inside ExempleController";
	}
}
