package rafa.dev.medcontrol.model;

import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "pacientes")
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String nome;

    @ManyToOne()
    @JoinColumn(name = "medico_id")
    private Medico medico;

    @OneToMany(mappedBy = "paciente" ,cascade = CascadeType.ALL, orphanRemoval = true)
    List<Observacao> observacoes;

    public Paciente(UUID id, String nome, Medico medico, List<Observacao> observacoes) {
        this.id = id;
        this.nome = nome;
        this.medico = medico;
        this.observacoes = observacoes;
    }

    public Paciente() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public List<Observacao> getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(List<Observacao> observacoes) {
        this.observacoes = observacoes;
    }
}
