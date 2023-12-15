package se.miun.whiteboiz;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebFilter(filterName = "AuthFilter", urlPatterns = {"*.xhtml"})
public class AuthFilter implements Filter {

    public AuthFilter() {
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        try {

            // check whether session variable is set
            HttpServletRequest req = (HttpServletRequest) request;
            HttpServletResponse res = (HttpServletResponse) response;
            HttpSession ses = req.getSession(false);
            //  allow user to proceed if url is login.xhtml or user logged in or user is accessing any page in //public folder
            String reqURI = req.getRequestURI();
            if (reqURI.equals(req.getContextPath() + "/") || reqURI.contains("/login.xhtml") || (ses != null && ses.getAttribute("username") != null)
                    || reqURI.contains("/index.xhtml") || reqURI.contains("jakarta") )
                chain.doFilter(request, response);
            else   // user didn't log in but asking for a page that is not allowed so take user to login page
                res.sendRedirect(req.getContextPath() + "/login.xhtml");  // Anonymous user. Redirect to login page
        }
        catch(Throwable t) {
            System.out.println( t.getMessage());
        }
    } //doFilter

    @Override
    public void destroy() {

    }
}
