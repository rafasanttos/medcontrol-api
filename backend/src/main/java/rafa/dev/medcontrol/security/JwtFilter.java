package rafa.dev.medcontrol.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;
import rafa.dev.medcontrol.model.Medico;
import rafa.dev.medcontrol.repository.MedicoRepository;

import java.io.IOException;
import java.util.List;

public class JwtFilter extends OncePerRequestFilter {
    private final TokenService tokenService;
    private final MedicoRepository medicoRepository;

    public JwtFilter(TokenService tokenService, MedicoRepository medicoRepository){
        this.tokenService = tokenService;
        this.medicoRepository = medicoRepository;
    }
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        String token = recuperarToken(request);

        System.out.println("JWT FILTER PASSOU AQUI");
        System.out.println("ROTA: " + request.getRequestURI());
        System.out.println("METHOD: " + request.getMethod());

        if(token != null){
            String email = tokenService.validarToken(token);
            Medico  medico = medicoRepository.findByEmail(email)
                    .orElseThrow(()-> new RuntimeException("Usuário não encontrado"));

            UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(medico, null, List.of());
            SecurityContextHolder.getContext().setAuthentication(auth);

            System.out.println("Token recebido " + token);
            System.out.println("Email do token " + email);
            System.out.println("Medico encontrado " + medico.getEmail());
        }

        filterChain.doFilter(request, response);

    }

    private String recuperarToken(HttpServletRequest request){
        String header = request.getHeader("Authorization");
        if(header == null) return null;

        return header.replace("Bearer ","");
    }



}
