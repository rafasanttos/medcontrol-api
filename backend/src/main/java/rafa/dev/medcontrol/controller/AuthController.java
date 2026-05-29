package rafa.dev.medcontrol.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import rafa.dev.medcontrol.dto.LoginDto;
import rafa.dev.medcontrol.dto.TokenDto;
import rafa.dev.medcontrol.model.Medico;
import rafa.dev.medcontrol.repository.MedicoRepository;
import rafa.dev.medcontrol.security.TokenService;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final MedicoRepository medicoRepository;
    private final TokenService tokenService;



    public AuthController(MedicoRepository medicoRepository, TokenService tokenService){
        this.medicoRepository = medicoRepository;
        this.tokenService = tokenService;
    }

    @PostMapping("/login")
    public ResponseEntity<TokenDto> login(@RequestBody LoginDto dto){


        Medico medico = medicoRepository.findByEmail(dto.email())
                .orElseThrow(()-> new RuntimeException("Usuário não encontrado"));
        if(!new BCryptPasswordEncoder().matches(dto.password(), medico.getPassword())){
            throw new RuntimeException("Senha inválida");
        }
        String token = tokenService.gerarToken(medico);

        return ResponseEntity.ok(new TokenDto(token));
    }


}
