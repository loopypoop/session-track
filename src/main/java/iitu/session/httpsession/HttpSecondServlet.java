package iitu.session.httpsession;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class HttpSecondServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        try {
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();

            HttpSession session=request.getSession(false);
            String n = (String)session.getAttribute("uname");
            out.print("Hello " + n);

            out.close();

        } catch(Exception e) {
            System.out.println(e);
        }
    }
}
