package cl.exql.servletapi1;

import javax.servlet.*;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet (name = "ServletConfigDemoServlet", value = "/ServletConfigDemo",
        initParams = { @WebInitParam( name = "admin", value = "Exequiel"),
        @WebInitParam( name ="email", value = "evenegas4414@gmail.com")})

public class ServletConfigDemoServlet implements Servlet {
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
        ServletConfig servletConfig = getServletConfig();
        String admin = servletConfig.getInitParameter("admin");
        String email = servletConfig.getInitParameter("email");

        servletResponse.setContentType("text/html");
        PrintWriter out = servletResponse.getWriter();
        out.print("<!DOCTYPE html>"
                + "<html>"
                + "<body>"
                + "Admin: " + admin
                + "<br/>Email: " + email
                + "</body></html>");
    }

    @Override
    public String getServletInfo() {
        return "ServletConfigDemo info";
    }

    @Override
    public void destroy() {

    }
}
