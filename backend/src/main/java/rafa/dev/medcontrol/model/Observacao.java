package rafa.dev.medcontrol.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "observacao")
public class Observacao {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String descricao;
    private String criadoAt = LocalDateTime.now().toString();

    @ManyToOne
    @JoinColumn(name = "paciente_id")
    private Paciente paciente;

    public Observacao(UUID id, String descricao, Paciente paciente) {
        this.id = id;
        this.descricao = descricao;
        this.paciente = paciente;
    }

    public Observacao() {
    }

    public String getCriadoAt() {
        return criadoAt;
    }

    public void setCriadoAt(String criadoAt) {
        this.criadoAt = criadoAt;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }
}
