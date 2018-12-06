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

public void doGet (HttpServletRequest req, HttpServletResponse res ) 
throws ServletException, IOException{

res.setContentType( "text/html" );
PrintWriter out = res.getWriter();
out.println( "<HTML>" );
out.println( "<HEAD>");
out.println( "<TITLE></TITLE>" );
out.println( "</HEAD>" );



try {

Class.forName("com.mysql.jdbc.Driver");
Connection connect = DriverManager
.getConnection("jdbc:mysql://localhost:3306/test?"
+ "user=root&password=");

Statement st = connect.createStatement();
ResultSet rs = st.executeQuery("SELECT * FROM textes");

while (rs.next()) {
out.print(rs.getString("id"));
out.print(rs.getString("texte"));
}

connect.close();
} catch (ClassNotFoundException e) {
	throw new IOException("ClassNotFoundException e");
} catch (SQLException e) {
	e.printStackTrace();
}

out.println( "<BODY>CONNECTION OK" );
out.println( "</BODY>" );
out.println( "</HTML>" );
out.close();
}
}