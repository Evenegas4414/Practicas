package cl.exql.servletapi2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

@WebServlet(name = "Form2Servlet", urlPatterns = "/Form2Servlet")
public class Form2Servlet extends HttpServlet {
    private static final String TITLE = "Order Form";

    @Override
    public void init() throws ServletException {
        super.init();

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>" + TITLE + "</title></head>");
        out.println("<body><h1>" + TITLE + "</h1>");

        out.println("<p>Form 2 Servlet Demo Text DO GET</p>");
        out.println("</body>");
        out.println("</html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        writer.println("<html>");
        writer.println("<head>");
        writer.println("<title>" + TITLE + "</title></head>");
        writer.println("</head>");
        writer.println("<body><h1>" + TITLE + "</h1>");
        writer.println("<p>Form 2 Servlet Demo Text DO POST</p>");
        writer.println("</body>");
        writer.println("</html>");
    }
}
