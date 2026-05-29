package rafa.dev.medcontrol.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.w3c.dom.stylesheets.LinkStyle;
import rafa.dev.medcontrol.model.Observacao;

import java.awt.*;
import java.util.List;
import java.util.UUID;

@Repository
public interface ObservacaoRepository extends JpaRepository<Observacao, UUID> {
    List<Observacao> findByPaciente_Id(UUID pacienteId);
}
