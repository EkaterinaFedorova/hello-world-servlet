import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.*;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.naming.*;
import javax.sql.*;
import java.sql.*;
import java.sql.SQLException;
import java.net.*;

public class HelloServlet extends HttpServlet {

    protected void service(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        String url = "";
        String hostName = "";

        try {
            Process proc = Runtime.getRuntime().exec("hostname");
            BufferedReader reader = new BufferedReader(new InputStreamReader(proc.getInputStream()));
            hostName = reader.readLine();
        } catch (Exception e) { out.println(e.getMessage()); }

        out.println("<html>");
        out.println("<body>");
        out.println("<h1>Tomcat Demo App</h1>");
	out.println("<h2>Hi! I'm a Tomcat application you successfully deployed  with Murano!</h2>");
	out.println("<h2>I'm using PostgresSQL which was installed in the same environment.</h2>");
        out.println("<p>Machine hostname is <i> " + hostName + "</i></p>");
        out.println("</html>");
        out.println("</body>");
    }

}
