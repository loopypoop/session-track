package iitu.session.hidden;

import java.io.*;
import javax.servlet.http.*;
public class SecondServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)  {
        try {
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();

            String n=request.getParameter("uname");
            out.print("<a href=\"index.html\">Home</a><br>");
            out.print("<p>Hello</p> " + n);

            out.close();
        } catch(Exception e) {
                System.out.println(e);
            }
    }
}
