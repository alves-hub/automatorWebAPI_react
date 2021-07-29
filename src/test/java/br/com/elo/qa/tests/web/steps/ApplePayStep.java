package br.com.elo.qa.tests.web.steps;

import br.com.elo.qa.framework.commons.exceptions.NoSuchEnvironmentException;
import br.com.elo.qa.testes.web.lib.funcionalidades.ApplePayFunc;
import br.com.elo.qa.testes.web.lib.page.factory.BasePage;
import cucumber.api.java8.Pt;

@SuppressWarnings("deprecation")
public class ApplePayStep extends BasePage implements Pt {

	public ApplePayFunc applePay = new ApplePayFunc();

	public ApplePayStep() throws NoSuchEnvironmentException {

		Dado("que acessei a página ApplePay", () -> {
			applePay.acessarPagina();
		});

		Entao("^a pagina Apple Pay é apresentada contendo o texto \"([^\"]*)\"$", (String texto) -> {
			applePay.verificarTexto(texto);
		});
	}

}