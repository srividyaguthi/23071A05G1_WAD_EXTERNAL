import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class ViewCookiesServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html><head><title>View Cookies</title></head><body>");
        out.println("<h2>Stored Cookies (Filtered):</h2>");

        Cookie[] cookies = request.getCookies();

        if (cookies != null && cookies.length > 0) {
            boolean found = false;
            for (Cookie c : cookies) {
                String name = c.getName();
                if ("username".equals(name) || "favoriteColor".equals(name) || "city".equals(name)) {
                    out.println("<p>" + name + ": " + c.getValue() + "</p>");
                    found = true;
                }
            }
            if (!found) {
                out.println("<p>No relevant cookies found!</p>");
            }
        } else {
            out.println("<p>No cookies found!</p>");
        }

        out.println("</body></html>");
    }
}