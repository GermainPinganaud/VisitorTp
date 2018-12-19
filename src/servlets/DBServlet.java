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
out.println( "<BODY>CONNECTION OK<br>" );


try {

Class.forName("com.mysql.jdbc.Driver");
Connection connect = DriverManager
.getConnection("jdbc:mysql://localhost:3306/test?"
+ "user=root&password=");

Statement mySql = connect.createStatement();

ResultSet selectAll = mySql.executeQuery("SELECT * FROM textes");

while (selectAll.next()) {
	out.print("<br>");
	out.print(selectAll.getString("id"));
	out.print(selectAll.getString("texte"));
}

mySql.executeUpdate("INSERT INTO `textes` (`id`, `texte`) VALUES (NULL, 'un texte');");

connect.close();
} catch (ClassNotFoundException e) {
	throw new IOException("ClassNotFoundException e");
} catch (SQLException e) {
	e.printStackTrace();
}
out.println( "</BODY>" );
out.println( "</HTML>" );
out.close();
}
}