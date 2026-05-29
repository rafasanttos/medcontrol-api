package rafa.dev.medcontrol.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rafa.dev.medcontrol.model.Paciente;

import java.util.List;
import java.util.UUID;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, UUID> {
    List<Paciente> findByMedicoId(UUID medicoId);
}
