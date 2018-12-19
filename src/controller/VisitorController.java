package controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import model.Visitor;

@Path("/visitor")
public class VisitorController {
	
    @GET
    @Path("/get/"+
    		"ip={ip}&"+
    		"country={country}&"+
    		"browser={browser}&"+
    		"browser_version={browser_version}&"+
    		"os={os}&"+
    		"os_version={os_version}")
    public void createVisitor(
    		@PathParam("ip") String ip,
    		@PathParam("country") String country,
    		@PathParam("browser") String browser,
    		@PathParam("browser_version") String browser_version,
    		@PathParam("os") String os,
    		@PathParam("os_version") String os_version
	) {
    	Visitor visitor = new Visitor();
    	visitor.setIp(ip);
    	visitor.setCountry(country);
    	visitor.setBrowser(browser);
    	visitor.setBrowser_version(browser_version);
    	visitor.setOs(os);
    	visitor.setOs_version(os_version);
    }
}

