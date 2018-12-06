package controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/exemple")
public class ExempleController {
	
	@GET
	@Path("/bonjour")
	public String direBonjour() {
		return "Bonjour";
	}
}
