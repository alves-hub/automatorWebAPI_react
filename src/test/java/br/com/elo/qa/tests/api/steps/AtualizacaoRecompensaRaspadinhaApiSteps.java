package br.com.elo.qa.tests.api.steps;

import br.com.elo.qa.tests.site.elo.lib.api.funcionalities.AtualizacaoRecompensaOfertaRaspadinhaApiFunc;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;

public class AtualizacaoRecompensaRaspadinhaApiSteps {

	AtualizacaoRecompensaOfertaRaspadinhaApiFunc rewards = new AtualizacaoRecompensaOfertaRaspadinhaApiFunc();

	@Dado("realizo o PUT para alterar e atualizar a nome e descricao")
	public void realizandoPost() {
		rewards.putAtualizarRecompensa();

	}

	@Dado("realizo o PUT para alterar e atualizar a nome e descrição com nome vazio")
	public void realizandoPostDadosIncorretos() {
		rewards.putAtualizarRecompensaBadRequest();
	}

	@Então("validando response atualizacao de recompensa com sucesso (.*)")
	public void validandoStatusResponse(int code) {
		rewards.validandoResponseRecompensaRaspadinha(code);

	}

	@Então("validando response atualizacao de recompensa sem sucesso (.*)")
	public void validandoResponse(int code) {
		rewards.validandoResponseRecompensaIncorreto(code);
	}
}