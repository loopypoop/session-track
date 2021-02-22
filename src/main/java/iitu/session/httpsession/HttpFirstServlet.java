package iitu.session.httpsession;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;


public class HttpFirstServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        try {
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();

            String n=request.getParameter("userName");
            out.print("Welcome "+n);

            HttpSession session=request.getSession();
            session.setAttribute("uname",n);

            out.print("<br><a href='httpServlet2'>visit profile</a>");

            out.close();

        } catch(Exception e) {
            System.out.println(e);
        }
    }
}
