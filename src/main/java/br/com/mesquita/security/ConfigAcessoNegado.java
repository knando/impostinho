package br.com.mesquita.security;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.access.AccessDeniedHandler;
import java.io.IOException;

public class ConfigAcessoNegado implements AccessDeniedHandler {

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response,
                       AccessDeniedException accessDeniedException) throws IOException, ServletException {
        
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        
        if (auth != null && auth.isAuthenticated()) {
            // Optional: Log out the user to clear their current session/roles
            request.getSession().invalidate();
            
            // Redirect to login page with a custom error parameter
            response.sendRedirect(request.getContextPath() + "/login?error=insufficient_privileges");
        } else {
            // Default behavior if not authenticated
            response.sendRedirect(request.getContextPath() + "/login");
        }
    }
}
