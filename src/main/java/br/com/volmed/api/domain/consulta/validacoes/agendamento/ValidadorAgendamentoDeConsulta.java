package br.com.volmed.api.domain.consulta.validacoes.agendamento;

import br.com.volmed.api.domain.consulta.DadosAgendamentoConsulta;

public interface ValidadorAgendamentoDeConsulta {
    void validar(DadosAgendamentoConsulta dados);
}
