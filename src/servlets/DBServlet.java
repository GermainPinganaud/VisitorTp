package servlets;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DBServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

public void doGet (HttpServletRequest req, HttpServletResponse res ) 
throws ServletException, IOException{

res.setContentType( "text/html" );
PrintWriter out = res.getWriter();
out.println( "<HTML>" );
out.println( "<HEAD>");
out.println( "<TITLE></TITLE>" );
out.println( "</HEAD>" );
out.println( "<BODY>" );
out.println( "<h1>Base de donn�es</h1>" );
out.println( "<p>Cette page est une servlet qui affiche le contenu de la base de donn�e.<p>" );
out.print("<ul>");

try {

	Class.forName("com.mysql.jdbc.Driver");
	Connection connect = DriverManager
	.getConnection("jdbc:mysql://localhost:3306/visitor?"
	+ "user=root&password=");
	
	Statement mySql = connect.createStatement();
	
	ResultSet selectAll = mySql.executeQuery("SELECT * FROM info");
	
	while (selectAll.next()) {
		out.print("<li>");
		out.print("id : ");
		out.print(selectAll.getString("id"));
		out.print(", ip : ");
		out.print(selectAll.getString("ip"));
		out.print(", country : ");
		out.print(selectAll.getString("country"));
		out.print(", browser : ");
		out.print(selectAll.getString("browser"));
		out.print(", version : ");
		out.print(selectAll.getString("browser_version"));
		out.print(", os : ");
		out.print(selectAll.getString("os"));
		out.print(", version : ");
		out.print(selectAll.getString("os_version"));
		out.print("</li>");}
	
	
	connect.close();
	
}
catch (ClassNotFoundException e) {
	throw new IOException("ClassNotFoundException e");
} catch (SQLException e) {
	e.printStackTrace();
}
out.println( "</ul>" );
out.println( "</BODY>" );
out.println( "</HTML>" );
out.close();
}
}