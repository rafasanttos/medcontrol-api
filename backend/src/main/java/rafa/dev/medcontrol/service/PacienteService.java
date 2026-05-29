package rafa.dev.medcontrol.service;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import rafa.dev.medcontrol.dto.PacienteRequestDto;
import rafa.dev.medcontrol.dto.PacienteResponseDto;
import rafa.dev.medcontrol.exception.ForbiddenException;
import rafa.dev.medcontrol.exception.NotFoundException;
import rafa.dev.medcontrol.model.Medico;
import rafa.dev.medcontrol.model.Paciente;
import rafa.dev.medcontrol.repository.MedicoRepository;
import rafa.dev.medcontrol.repository.PacienteRepository;

import java.util.List;
import java.util.UUID;

@Service
public class PacienteService {

    private final PacienteRepository pacienteRepository;
    private final MedicoRepository medicoRepository;

    public PacienteService(PacienteRepository pacienteRepository, MedicoRepository medicoRepository){
        this.pacienteRepository = pacienteRepository;
        this.medicoRepository =  medicoRepository;
    }

    public PacienteResponseDto criar(PacienteRequestDto dto){
        Medico medicoLogado = (Medico) SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getPrincipal();


        Paciente pacienteNovo = new Paciente();
        pacienteNovo.setNome(dto.nome());
        pacienteNovo.setMedico(medicoLogado);

        Paciente salvo = pacienteRepository.save(pacienteNovo);

        return new PacienteResponseDto(
                salvo.getId(),
                salvo.getNome(),
                salvo.getMedico().getNome()
        );
    }

    public List<PacienteResponseDto> listarPacientes(UUID medicoId){
        List<Paciente> pacientesEncontrados = pacienteRepository.findByMedicoId(medicoId);

        return pacientesEncontrados.stream().map(paciente -> toDto(paciente)).toList();
    }

    public PacienteResponseDto toDto(Paciente paciente){
        return new PacienteResponseDto(
                paciente.getId(),
                paciente.getNome(),
                paciente.getMedico().getNome()
        );
    }

    public List<PacienteResponseDto> listarMeusPacientes(){
        Medico medico = (Medico) SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getPrincipal();

        List<Paciente> pacientes = pacienteRepository.findByMedicoId(medico.getId());
        return pacientes.stream().map(this::toDto).toList();
    }

    public PacienteResponseDto buscarPorId(UUID id){
        Paciente paciente = buscarPacienteMedicoLogado(id);
        return toDto(paciente);
    }

    public Paciente buscarPacienteMedicoLogado(UUID pacienteId){
        Medico medicoLogado = (Medico) SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getPrincipal();

        Paciente paciente = pacienteRepository.findById(pacienteId)
                .orElseThrow(()-> new NotFoundException("Paciente não encontrado"));

        if(!paciente.getMedico().getId().equals(medicoLogado.getId())){
                throw new ForbiddenException("Vc não tem acesso");
        }

        return paciente;
    }

    public void deletarPaciente(UUID id){

       Medico medicoLogado = (Medico) SecurityContextHolder
               .getContext()
               .getAuthentication()
               .getPrincipal();

       Paciente paciente =  pacienteRepository.findById(id)
               .orElseThrow(()-> new NotFoundException("Paciente não encontrado"));

       if(!paciente.getMedico().getId().equals(medicoLogado.getId())){
          throw new ForbiddenException("Acesso negado");
       }

       pacienteRepository.delete(paciente);

    }

    public PacienteResponseDto atualizarPaciente(UUID id, PacienteRequestDto dto){
        Paciente paciente = buscarPacienteMedicoLogado(id);
        paciente.setNome(dto.nome());

        Paciente atualizado = pacienteRepository.save(paciente);
        return toDto(atualizado);
    }


}
