package br.com.elo.qa.tests.api.steps;

import br.com.elo.qa.tests.site.elo.lib.api.funcionalities.AtualizacaoOfertaRaspadinhaApiFunc;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;

public class AtualizarOfertaApiSteps {

	AtualizacaoOfertaRaspadinhaApiFunc raffle = new AtualizacaoOfertaRaspadinhaApiFunc();

	@Dado("que realizo o PUT na API Raspadinha para atualizacao")
	public void realizandoPut() {
		raffle.atualizacaoDeOferta();
	}
	
	@Dado("que realizo o PUT na API Raspadinha para atualizacao com dados incorreto")
	public void realizandoPutComHeaderIncorreto() {
		raffle.atualizacaoDeOfertaDadosIncorretos();
	}
	
	@Então("validar statusCode do response put com sucesso (.*)")
	public void validandoResponse(int code) {
		raffle.validarStatusCodeAtualizacaoCadastroOferta(code);
	}
	
	@Então("validar statusCode do response dados incorretos (.*)")
	public void validandoResponseDadosIncorretos(int code) {
		raffle.validarStatusCodeAtualizacaoCadastroOfertaIncorreto(code);
	}
}