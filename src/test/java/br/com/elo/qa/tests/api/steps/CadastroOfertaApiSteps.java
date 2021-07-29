package br.com.elo.qa.tests.api.steps;

import br.com.elo.qa.tests.site.elo.lib.api.funcionalities.CadastroOfertaRaspadinhaApiFunc;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;

public class CadastroOfertaApiSteps {

	CadastroOfertaRaspadinhaApiFunc raflle = new CadastroOfertaRaspadinhaApiFunc();

	@Dado("que realizo o post na API Raspadinha Criar Raffle")
	public void realizandoPost() {
		raflle.postCadastroDeOfertas();
	}

	@Dado("que realizo o post na API Raspadinha com dados incorretos")
	public void realizandoPostDadosIncorretos() {
		raflle.postCadastroDeOfertaDadosIncorretos();
	}

	@Então("validar response e statusCode (.*)")
	public void validandoStatusResponse(int code) {
		raflle.validarStatusCodeCadastroOferta(code);
	}

	@Então("validar statusCode do response Post dado incorreto (.*)")
	public void validandoResponse(int code) {
		raflle.validarStatusCodeCadastroOfertaIncorreto(code);
	}
}