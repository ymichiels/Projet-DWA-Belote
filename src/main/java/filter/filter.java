package filter;

import com.sun.xml.internal.bind.annotation.OverrideAnnotationOf;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

public class filter implements Filter {

    @Override
    public void destroy() {
    }

    @Override
    public void doFilter (ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        // initialisation du servlet context
        ServletContext sc = req.getServletContext();

    }

    @Override
    public void init(FilterConfig arg0) throws ServletException {

    }
}
