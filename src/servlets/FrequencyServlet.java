package servlets;

import java.io.*;
import java.nio.charset.Charset;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FrequencyServlet extends HttpServlet {

public void doGet (HttpServletRequest req, HttpServletResponse res ) 
throws ServletException, IOException {

PrintWriter out = res.getWriter();
out.println( "<HTML>" );
out.println( "<HEAD>");
out.println( "<TITLE>Page generee par une servlet</TITLE>" );
out.println( "</HEAD>" );
out.println( "<BODY>" );
out.println( "<H1>Non valide pour le get il faut requeter le POST</H1>" );
out.println( "</BODY>" );
out.println( "</HTML>" );
out.close();
}

public void doPost (HttpServletRequest req, HttpServletResponse res ) 
throws ServletException, IOException {

String text = getBody(req);


PrintWriter out = res.getWriter();
out.println( "<HTML>" );
out.println( "<HEAD>"
+ "<meta charset='UTF-8'></meta>");
out.println( "<TITLE>Page generee par une servlet</TITLE>" );
out.println( "</HEAD>" );
out.println( "<BODY>" );
out.println( "<H1>"+text+"</h1>" );
out.println( "</BODY>" );
out.println( "</HTML>" );
out.close();

}

private String getBody(HttpServletRequest req) throws IOException {
Reader r = new InputStreamReader(req.getInputStream(), Charset.forName("UTF-8"));
BufferedReader br = new BufferedReader(r);
String text = "";
String ligne = br.readLine();

while (ligne!=null) {
text+=ligne+"\n"; 
ligne = br.readLine();
}
return text;
}


}