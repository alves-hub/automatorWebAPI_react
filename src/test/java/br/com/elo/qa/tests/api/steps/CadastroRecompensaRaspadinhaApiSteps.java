package br.com.elo.qa.tests.api.steps;

import br.com.elo.qa.tests.site.elo.lib.api.funcionalities.CadastroRecompensaOfertaRaspadinhaApiFunc;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;

public class CadastroRecompensaRaspadinhaApiSteps {

	CadastroRecompensaOfertaRaspadinhaApiFunc rewards = new CadastroRecompensaOfertaRaspadinhaApiFunc();

	@Dado("que adiciono um premio na oferta do tipo raspadinha")
	public void realizandoPost() {
		rewards.postCadastroDeRecompensa();
	}

	@Dado("que adiciono um premio na oferta do tipo raspadinha sem nome da oferta")
	public void realizandoPostDadosIncorretos() {
		rewards.postCadastroDeRecompensaSemNome();
	}

	@Então("validando response cadastro de recompensa com sucesso (.*)")
	public void validandoStatusResponse(int code) {
		rewards.validandoResponseRecompensaRaspadinha(code);
	}

	@Então("validando response cadastro de recompensa sem sucesso (.*)")
	public void validandoResponse(int code) {
		rewards.validandoResponseRecompensaIncorreto(code);
	}
}