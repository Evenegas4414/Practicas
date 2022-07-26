package cl.exql.servletapi1;

import javax.servlet.*;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "GenericServletConfigDemoServlet", value = "/GenericServletConfigDemo",
        initParams = { @WebInitParam( name = "admin", value = "Venegas"),
                @WebInitParam( name ="email", value = "evenegas4414@gmail.com")})

public class GenericServletConfigDemoServlet extends GenericServlet {

    @Override
    public void init() throws ServletException {
        super.init();
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
}
