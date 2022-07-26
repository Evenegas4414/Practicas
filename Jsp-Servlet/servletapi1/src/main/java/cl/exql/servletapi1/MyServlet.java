package cl.exql.servletapi1;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "MyServlet", value = "/MyServlet")
public class MyServlet implements Servlet {

    private transient ServletConfig servletConfig;

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        this.servletConfig = servletConfig;
    }

    @Override
    public ServletConfig getServletConfig() {
        return servletConfig;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        String servletName = servletConfig.getServletName();
        servletResponse.setContentType("text/html");
        PrintWriter out = servletResponse.getWriter();
        out.print("<!DOCTYPE html>"
                + "<html>"
                + "<body>Hello from " + servletName
                + "</body>"
                + "</html>");

    }

    @Override
    public String getServletInfo() {
        return "My servletapi1 info";
    }

    @Override
    public void destroy() {

    }
}
