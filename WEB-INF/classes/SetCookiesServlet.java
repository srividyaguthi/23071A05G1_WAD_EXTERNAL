import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class SetCookiesServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Read form values
        String name = request.getParameter("name");
        String color = request.getParameter("color");
        String city = request.getParameter("city");

        // Create cookies
        Cookie nameCookie = new Cookie("username", name);
        Cookie colorCookie = new Cookie("favoriteColor", color);
        Cookie cityCookie = new Cookie("city", city);

        // Set expiry (optional)
        nameCookie.setMaxAge(60 * 60 * 24); // 1 day
        colorCookie.setMaxAge(60 * 60 * 24);
        cityCookie.setMaxAge(60 * 60 * 24);

        // Add cookies to response
        response.addCookie(nameCookie);
        response.addCookie(colorCookie);
        response.addCookie(cityCookie);

        // Response page
        out.println("<h2>Cookies Set Successfully!</h2>");
        out.println("<p>Name: " + name + "</p>");
        out.println("<p>Favorite Color: " + color + "</p>");
        out.println("<p>City: " + city + "</p>");
        out.println("<p><a href='viewCookies'>View Cookies</a></p>");
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html><body>");
        out.println("<h2>Set Cookies Form</h2>");
        out.println("<form method='post' action='setCookies'>");
        out.println("Name: <input type='text' name='name'><br>");
        out.println("Favorite Color: <input type='text' name='color'><br>");
        out.println("City: <input type='text' name='city'><br>");
        out.println("<input type='submit' value='Set Cookies'>");
        out.println("</form>");
        out.println("</body></html>");
    }

}