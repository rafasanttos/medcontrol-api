package rafa.dev.medcontrol.service;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import rafa.dev.medcontrol.dto.ObservacaoRequestDto;
import rafa.dev.medcontrol.dto.ObservacaoResponseDto;
import rafa.dev.medcontrol.model.Medico;
import rafa.dev.medcontrol.model.Observacao;
import rafa.dev.medcontrol.model.Paciente;
import rafa.dev.medcontrol.repository.ObservacaoRepository;
import rafa.dev.medcontrol.repository.PacienteRepository;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.UUID;

@Service
public class ObservacaoService {

    private final ObservacaoRepository observacaoRepository;
    private final PacienteRepository pacienteRepository;

    public ObservacaoService(ObservacaoRepository observacaoRepository, PacienteRepository pacienteRepository){
        this.observacaoRepository = observacaoRepository;
        this.pacienteRepository = pacienteRepository;
    }

    public ObservacaoResponseDto criar(UUID id, ObservacaoRequestDto dto){

        Medico medicoLogado = (Medico) SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getPrincipal();

        Paciente idPaciente = pacienteRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Paciente não encontrado"));

        if(!idPaciente.getMedico().getId().equals(medicoLogado.getId())){
            throw new RuntimeException("Acesso negado");
        }



        Observacao observacao = new Observacao();
        observacao.setDescricao(dto.descricao());
        observacao.setCriadoAt(LocalDateTime.now());
        observacao.setPaciente(idPaciente);

        Observacao salva = observacaoRepository.save(observacao);

        return  new ObservacaoResponseDto(
                salva.getId(),
                salva.getDescricao(),
                salva.getPaciente().getNome(),
                salva.getCriadoAt()

        );
    }

    public List<ObservacaoResponseDto> listarPorPaciente(UUID pacienteId){
        Medico medicoLogado = (Medico) SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getPrincipal();

        Paciente paciente = pacienteRepository.findById(pacienteId)
                .orElseThrow(()-> new RuntimeException("Paciente não encontrado"));

        if(!paciente.getMedico().getId().equals(medicoLogado.getId())){
            throw new RuntimeException("Acesso negado");
        }

        List<Observacao> observacoes = observacaoRepository.findByPaciente_Id(paciente.getId());

        return observacoes.stream().map(this::toDto).toList();



    }

    public ObservacaoResponseDto toDto(Observacao observacao){
        return new ObservacaoResponseDto(
                observacao.getId(),
                observacao.getDescricao(),
                observacao.getPaciente().getNome(),
                observacao.getCriadoAt()

        );
    }
}
