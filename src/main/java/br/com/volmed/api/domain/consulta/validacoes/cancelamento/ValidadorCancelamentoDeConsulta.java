package br.com.volmed.api.domain.consulta.validacoes.cancelamento;

import br.com.volmed.api.domain.consulta.DadosCancelamentoConsulta;

public interface ValidadorCancelamentoDeConsulta {
    void validar(DadosCancelamentoConsulta dados);
}