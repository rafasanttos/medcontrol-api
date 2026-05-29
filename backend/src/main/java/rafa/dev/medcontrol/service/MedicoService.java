package rafa.dev.medcontrol.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import rafa.dev.medcontrol.dto.MedicoRequestDto;
import rafa.dev.medcontrol.dto.MedicoResponseDto;
import rafa.dev.medcontrol.model.Medico;
import rafa.dev.medcontrol.repository.MedicoRepository;

@Service
public class MedicoService {

    private final MedicoRepository medicoRepository;

    public MedicoService(MedicoRepository medicoRepository){
        this.medicoRepository = medicoRepository;
    }



    public MedicoResponseDto criarMedico(MedicoRequestDto dto){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        Medico medicoNovo = new Medico();
        medicoNovo.setNome(dto.nome());
        medicoNovo.setEmail(dto.email());
        medicoNovo.setPassword(encoder.encode(dto.password()));

        Medico medicoSalvo = medicoRepository.save(medicoNovo);

        return new MedicoResponseDto(
                medicoSalvo.getId(),
                medicoSalvo.getNome(),
                medicoSalvo.getEmail()
        );
    }
}
