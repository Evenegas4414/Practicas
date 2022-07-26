package cl.exql.sessionmgt;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Top10Servlet extends HttpServlet {

    private List<String> londonAttractions = new ArrayList<>(10);
    private List<String> parisAttractions = new ArrayList<>(10);

    @Override
    public void init() throws ServletException {
        super.init();
        londonAttractions.add("Buckingham Palace");
        londonAttractions.add("London Eye");
        londonAttractions.add("British Museum");
        londonAttractions.add("National Gallery");
        londonAttractions.add("Big Ben");
        londonAttractions.add("Tower of London");
        londonAttractions.add("Natural History Museum");
        londonAttractions.add("Canary Wharf");
        londonAttractions.add("2012 Olympic Park");
        londonAttractions.add("St Paul's Cathedral");

        parisAttractions.add("Eiffel Tower");
        parisAttractions.add("Notre Dame");
        parisAttractions.add("The Louvre");
        parisAttractions.add("Champs Elysees");
        parisAttractions.add("Arc de Triomphe");
        parisAttractions.add("Sainte Chapelle Church");
        parisAttractions.add("Les Invalides");
        parisAttractions.add("Musee d'Orsay");
        parisAttractions.add("Montmarte");
        parisAttractions.add("Sacre Couer Basilica");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String city = req.getParameter("city");
        if ("london".equals(city) || "paris".equals(city)) {
            // show attractions
            showAttractions(req, resp, city);
        } else {
            // show main page
            showMainPage(req, resp);
        }
    }

    private void showMainPage(HttpServletRequest request,
                              HttpServletResponse response) throws ServletException,
            IOException {
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        writer.print("<!DOCTYPE html><html><head>" +
                "<title>Top 10 Tourist Attractions</title>" +
                "</head><body>" +
                "Please select a city:" +
                "<br/><a href='?city=london'>London</a>" +
                "<br/><a href='?city=paris'>Paris</a>" +
                "</body></html>");
    }

    private void showAttractions(HttpServletRequest request, HttpServletResponse response, String city)
            throws ServletException, IOException {

        int page = 1;
        String pageParameter = request.getParameter("page");
        if (pageParameter != null) {
            try {
                page = Integer.parseInt(pageParameter);
            } catch (NumberFormatException e) {
                // do nothing and retain default value for page
            }
            if (page > 2) {
                page = 1;
            }
        }
        List<String> attractions = null;
        if ("london".equals(city)) {
            attractions = londonAttractions;
        } else if ("paris".equals(city)) {
            attractions = parisAttractions;
        }
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        writer.println("<!DOCTYPE html><html><head>" +
                "<title>Top 10 Tourist Attractions</title>" +
                "</head><body>");
        writer.println("<a href='Top10Servlet'>Select City</a> ");
        writer.println("<hr/>Page " + page + "<hr/>");

        int start = page * 5 - 5;
        for (int i = start; i < start + 5; i++) {
            writer.println(attractions.get(i) + "<br/>");
        }
        writer.print("<hr style='color:blue'/>" +
                "<a href='?city=" + city +
                "&page=1'>Page 1</a>");
        writer.println("&nbsp; <a href='?city=" + city +
                "&page=2'>Page 2</a>");
        writer.println("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}