package com.mysycorp.Backendjo.security;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.mysycorp.Backendjo.util.JwtTokenUtil;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtRequestFilter extends OncePerRequestFilter {

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Override
    protected void doFilterInternal(HttpServletRequest request, 
                                    HttpServletResponse response, 
                                    FilterChain chain) throws ServletException, IOException {

        // Récupération de l'en-tête Authorization
        final String authorizationHeader = request.getHeader("Authorization");

        String username = null;
        String jwt = null;

        // Vérification que l'en-tête commence par "Bearer "
        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            jwt = authorizationHeader.substring(7);
            // Extraction du nom d'utilisateur depuis le token JWT
            username = jwtTokenUtil.extractUsername(jwt);
        }

        // Si un utilisateur est extrait du JWT et qu'il n'est pas déjà authentifié
        if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            // Chargement des détails de l'utilisateur
            UserDetails userDetails = this.userDetailsService.loadUserByUsername(username);

            // Validation du token JWT avec les détails de l'utilisateur
            if (jwtTokenUtil.validateToken(jwt, userDetails)) {
                // Création de l'authentification à partir des détails de l'utilisateur et des autorités
                UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
                        userDetails, null, userDetails.getAuthorities());
                // Définition des détails supplémentaires de la requête
                authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                // Placement de l'authentification dans le contexte de sécurité
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
        }

        // Poursuite de la chaîne de filtres
        chain.doFilter(request, response);
    }
}
