package iitu.session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

@WebServlet(value = "/cookiesServlet")
public class CookiesServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(true);

        Date createTime = new Date(session.getCreationTime());

        Date lastAccessTime = new Date(session.getLastAccessedTime());

        String title = "Welcome back!";
        Integer visitCount = new Integer(0);
        String visitCountKey =  new String("visitCount");
        String userIDKey = new String("userID");
        String userID = new String("USER_12345");

        if (session.isNew()) {
            title = "Welcome!";
            session.setAttribute(userIDKey, userID);
        } else {
            visitCount = session.getAttribute(visitCountKey) != null
                    ? (Integer)session.getAttribute(visitCountKey)
                    : visitCount;
            visitCount++;
            userID = (String)session.getAttribute(userIDKey);
        }
        session.setAttribute(visitCountKey, visitCount);

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println(
                "<!doctype html public \"-//w3c//dtd html 4.0 transitional//en\">" +
                        "<html>" +
                        "   <head><title>" + title + "</title></head>" +
                        "   <body bgcolor = \"#f0f0f0\">" +
                        "       <h1 align = \"center\">" + title + "</h1>" +
                        "       <h2 align = \"center\">Session Infomation</h2>" +
                        "       <table border = \"1\" align = \"center\">" +
                        "           <tr bgcolor = \"#949494\">" +
                        "               <th>Session info</th>" +
                        "               <th>value</th>" +
                        "           </tr>" +
                        "           <tr>" +
                        "               <td>id</td>" +
                        "               <td>" + session.getId() + "</td>" +
                        "           </tr>" +
                        "           <tr>" +
                        "               <td>Creation Time</td>" +
                        "               <td>" + createTime + "  </td>" +
                        "           </tr>" +
                        "           <tr>" +
                        "               <td>Time of Last Access</td>" +
                        "               <td>" + lastAccessTime + "  </td>" +
                        "           </tr>" +
                        "           <tr>" +
                        "               <td>User ID</td>" +
                        "               <td>" + userID + "  </td>" +
                        "           </tr>" +
                        "           <tr>" +
                        "               <td>Number of visits</td>" +
                        "               <td>" + visitCount + "</td>" +
                        "           </tr>" +
                        "       </table>" +
                        "   </body>" +
                        "</html>"
        );
    }
}
