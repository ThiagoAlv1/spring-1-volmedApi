package br.com.volmed.api.domain.consulta;

import br.com.volmed.api.domain.medico.Especialidade;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DadosAgendamentoConsulta(
        Long idMedico,

        @NotNull
        Long idPaciente,

        @NotNull
        @Future //essa anotacao é usada para dizer que a data é no futuro
        LocalDateTime data,

        Especialidade especialidade) {
}
