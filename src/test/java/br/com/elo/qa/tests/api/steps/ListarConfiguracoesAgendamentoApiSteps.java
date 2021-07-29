package br.com.elo.qa.tests.api.steps;

import br.com.elo.qa.tests.site.elo.lib.api.funcionalities.ListarConfiguracoesAgendamentoApiFunc;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;

public class ListarConfiguracoesAgendamentoApiSteps {

	ListarConfiguracoesAgendamentoApiFunc configs = new ListarConfiguracoesAgendamentoApiFunc();

	@Dado("^que realizo o GET para Listar usuario ativo para funcao agendamento semanal (.*)$")
	public void realizandoGETUserAtivo(String agendamento) throws InterruptedException {

		configs.ativarDesativarFuncaoAgendamento(agendamento);
	}

	@Dado("^que realizo o GET para Listar usuario Inativo para funcao agendamento semanal (.*)$")
	public void realizandoGETUserInativo(String agendamento) throws InterruptedException {

		configs.ativarDesativarFuncaoAgendamento(agendamento);
	}

	@Dado("^que realizo o GET com Raffle invalido (.*)$")
	public void realizandoGETBadRequest(String agendamento) throws InterruptedException {
		configs.listarConfiguracaoAgendamento(agendamento);
	}

	@Então("^validando response lista configuracao agendamento ativo (.*) (.*)$")
	public void validandoResponseConfigAtivo(int code, String status) {
		configs.validandoResponseStatusConfigAgendamento(code, status);
	}

	@Então("^validando response lista configuracao agendamento inativo (.*) (.*)$")
	public void validandoResponseConfigInativo(int code, String status) {
		configs.validandoResponseStatusConfigAgendamento(code, status);
	}

	@Então("^validando response com raffle invalido (.*) (.*)$")
	public void validandoResponseBadRequest(int code, String status) {
		configs.validandoResponseStatusConfigAgendamento(code, status);
	}

}