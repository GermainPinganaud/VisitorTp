package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

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
    public String createVisitor(
    		@PathParam("ip") String ip,
    		@PathParam("country") String country,
    		@PathParam("browser") String browser,
    		@PathParam("browser_version") String browser_version,
    		@PathParam("os") String os,
    		@PathParam("os_version") String os_version
	) throws IOException {
    	Visitor visitor = new Visitor();
    	visitor.setIp(ip);
    	visitor.setCountry(country);
    	visitor.setBrowser(browser);
    	visitor.setBrowser_version(browser_version);
    	visitor.setOs(os);
    	visitor.setOs_version(os_version);
    	try {

    		Class.forName("com.mysql.jdbc.Driver");
    		Connection connect = DriverManager
    		.getConnection("jdbc:mysql://localhost:3306/visitor?"
    		+ "user=root&password=&useSSL=false");

    		Statement mySql = connect.createStatement();

    		mySql.executeUpdate("INSERT INTO `info` ("
    				+ "`id`, "
    				+ "`ip`, "
    				+ "`country`, "
    				+ "`browser`, "
    				+ "`browser_version`, "
    				+ "`os`, "
    				+ "`os_version`)"
    				+ "VALUES (NULL, '"+
    				ip+"', '"+
    				country+"', '"+
    				browser+"', '"+
    				browser_version+"', '"+
    				os+"', '"+
    				os_version+"');");

    		connect.close();
		}
    	catch (ClassNotFoundException e) {
			throw new IOException("ClassNotFoundException e");
		}
    	catch (SQLException e) {
			e.printStackTrace();
		}
    	return "ip = " + visitor.getIp() + "<br>country = " + visitor.getCountry();
    }
}

