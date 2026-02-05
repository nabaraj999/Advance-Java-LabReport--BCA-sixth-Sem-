import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class DisplayCookieIdServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head><title>Display Cookie / Session ID</title></head>");
        out.println("<body>");
        out.println("<h2>Session & Cookie Information</h2>");

        // Get or create session
        HttpSession session = request.getSession();

        // Session ID = value of JSESSIONID cookie
        String sessionId = session.getId();
        boolean isNewSession = session.isNew();

        out.println("<p><b>Session ID (JSESSIONID cookie value):</b> " + sessionId + "</p>");
        out.println("<p><b>Is new session?</b> " + isNewSession + "</p>");
        out.println("<p><b>Session created at:</b> " + new java.util.Date(session.getCreationTime()) + "</p>");
        out.println("<p><b>Last accessed:</b> " + new java.util.Date(session.getLastAccessedTime()) + "</p>");

        // Show actual cookies from request
        out.println("<h3>Cookies received in this request:</h3>");
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                out.println("<p>");
                out.println("<b>Name:</b> " + cookie.getName() + "<br>");
                out.println("<b>Value:</b> " + cookie.getValue() + "<br>");
                out.println("<b>Max Age:</b> " + cookie.getMaxAge() + " seconds");
                out.println("</p>");
            }
        } else {
            out.println("<p><i>No cookies found in this request</i></p>");
        }

        out.println("<hr>");
        out.println("<p><a href='displaycookie'>Refresh page</a></p>");
        out.println("<p><small>Refresh multiple times → same Session ID should appear (until browser closes or session expires)</small></p>");
        out.println("</body></html>");
    }
}