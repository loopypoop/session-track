package iitu.session.urlRewriting;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;


public class UrlReFirstServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        try {

            response.setContentType("text/html");
            PrintWriter out = response.getWriter();

            String n=request.getParameter("userName");
            out.print("Welcome " + n + " <br>");

            //appending the username in the query string
            out.print("<a href='servlet2url?uname="+n+"'>visit</a>");

            out.close();

        } catch(Exception e) {
            System.out.println(e);
        }
    }

}
