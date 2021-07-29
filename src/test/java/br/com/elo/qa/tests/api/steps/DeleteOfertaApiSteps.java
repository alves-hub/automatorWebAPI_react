package br.com.elo.qa.tests.api.steps;

import br.com.elo.qa.tests.site.elo.lib.api.funcionalities.DeleteOfertaRaspadinhaApiFunc;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;

public class DeleteOfertaApiSteps {

	DeleteOfertaRaspadinhaApiFunc raffles = new DeleteOfertaRaspadinhaApiFunc();

	@Dado("que realizo o DELETE no raffleuuid da raspadinha")
	public void realizandoDelete() {
		raffles.deleteOferta();
	}
	@Dado("que realizo o DELETE no raffleuuid da raspadinha dado incorretos")
	public void realizandoDeletess() {
		raffles.deleteOfertaComDadosIncorretos();

	}
	@Então("validar statusCode do response Delete com sucesso (.*)")
	public void validandoResponse(int code) {
		raffles.validarStatusCodeDeleteCadastroOferta(code);

	}
	@Então("validar statusCode do response Delete com dado incorreto (.*)")
	public void validandoResponseDadosIncorretos(int code) {
		raffles.validarStatusCodeDeleteCadastroOfertaIncorreto(code);
	}
}