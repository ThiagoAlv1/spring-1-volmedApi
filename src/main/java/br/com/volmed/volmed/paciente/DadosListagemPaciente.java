package br.com.volmed.volmed.paciente;

import br.com.volmed.volmed.medico.Especialidade;
import br.com.volmed.volmed.medico.Medico;

public record DadosListagemPaciente(Long id, String nome, String email, String cpf) {

    public DadosListagemPaciente(Paciente paciente) {
        this(paciente.getId(), paciente.getNome(), paciente.getEmail(), paciente.getCpf());
    }

}