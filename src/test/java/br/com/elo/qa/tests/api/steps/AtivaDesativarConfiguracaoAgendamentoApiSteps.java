package br.com.elo.qa.tests.api.steps;

import br.com.elo.qa.tests.site.elo.lib.api.funcionalities.AtivarDesativarAgendamentoRaspagemApiFunc;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;

public class AtivaDesativarConfiguracaoAgendamentoApiSteps {

	AtivarDesativarAgendamentoRaspagemApiFunc configs = new AtivarDesativarAgendamentoRaspagemApiFunc();

	@Dado("^que realizo o POST Ativando habilitando função de agendamento semanal (.*)$")
	public void realizandoGETUserAtivo(String status) throws InterruptedException {

		configs.ativarDesativarFuncaoAgendamento(status);
	}

	@Dado("^que realizo o POST desativando habilitando função de agendamento semanal (.*)$")
	public void realizandoGETUserInativo(String status) throws InterruptedException {

		configs.ativarDesativarFuncaoAgendamento(status);
	}

	@Dado("^que realizo o POST com Raffle invalido (.*)$")
	public void realizandoGETBadRequest(String status) throws InterruptedException {
		configs.ativarDesativarFuncaoAgendamento(status);
	}

	@Então("^validando response post agendamento ativo (.*) (.*)$")
	public void validandoResponseConfigAtivo(int code, String status) {
		configs.validandoResponsePost(code, status);
	}

	@Então("^validando response post agendamento desativado (.*) (.*)$")
	public void validandoResponseConfigInativo(int code, String status) {
		configs.validandoResponsePost(code, status);
	}

	@Então("^validando response post com raffleUuid invalido (.*) (.*)$")
	public void validandoResponseBadRequest(int code, String status) {
		configs.validandoResponsePost(code, status);
	}

}