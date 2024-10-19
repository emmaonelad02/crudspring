package crud.example.spring.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class AuthFilter extends OncePerRequestFilter {
    public AuthFilter() {
    }

    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        System.out.println("############ authfilter " + request.getRequestURI());
        List<SimpleGrantedAuthority> authorities = new ArrayList();
        authorities.add(new SimpleGrantedAuthority("app"));
        authorities.add(new SimpleGrantedAuthority("ROLE_admin"));
        String username = "Saly";
        filterChain.doFilter(request, response);
    }
}
