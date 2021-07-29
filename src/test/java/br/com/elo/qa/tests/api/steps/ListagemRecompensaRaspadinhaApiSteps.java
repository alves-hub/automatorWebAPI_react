package br.com.elo.qa.tests.api.steps;

import br.com.elo.qa.tests.site.elo.lib.api.funcionalities.ListagemRecompensaOfertaRaspadinhaApiFunc;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;

public class ListagemRecompensaRaspadinhaApiSteps {

	ListagemRecompensaOfertaRaspadinhaApiFunc rewards = new ListagemRecompensaOfertaRaspadinhaApiFunc();

	@Dado("realizo o GET para exibir a lista")
	public void realizandoPost() {
		rewards.listagemCadastroRecompensa();
	}

	@Dado("realizo o GET para exibir a lista raffleuuid incorreto")
	public void realizandoPostDadosIncorretos() {
		rewards.listagemCadastroRecompensaBadRequest();
	}

	@Então("validando response listagem de recompensa com sucesso (.*)")
	public void validandoStatusResponse(int code) {
		rewards.validandoResponseRecompensaRaspadinha(code);
	}

	@Então("validando response listagem de recompensa sem sucesso (.*)")
	public void validandoResponse(int code) {
		rewards.validandoResponseRecompensaIncorreto(code);
	}
}