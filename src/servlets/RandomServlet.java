package servlets;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RandomServlet extends HttpServlet {

public void doGet (HttpServletRequest req, HttpServletResponse res ) 
throws ServletException, IOException {
	String[] tab = req.getRequestURI().split("/");
	Integer max = Integer.parseInt(tab[tab.length-1]);
	Integer min = Integer.parseInt(tab[tab.length-2]);
	
	Integer realMax = Math.max(max,min);
	Integer realMin = Math.min(max,min);
	
	Integer result = (int)(Math.random()*(realMax-realMin)+realMin);
	
	res.setContentType( "text/html" );
	PrintWriter out = res.getWriter();
	out.println( "<HTML>" );
	out.println( "<HEAD>");
	out.println( "<TITLE>Page generee par une servlet</TITLE>" );
	out.println( "</HEAD>" );
	out.println( "<BODY>" );
	out.println( "<H1>"+result+"</H1>" );
	out.println( "</BODY>" );
	out.println( "</HTML>" );
	out.close();
	}
}