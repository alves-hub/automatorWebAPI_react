package br.com.elo.qa.tests.web.steps;

import br.com.elo.qa.framework.commons.exceptions.NoSuchEnvironmentException;
import br.com.elo.qa.testes.web.lib.funcionalidades.GooglePayFunc;
import br.com.elo.qa.testes.web.lib.page.factory.BasePage;
import cucumber.api.java8.Pt;

@SuppressWarnings("deprecation")
public class GooglePayStep extends BasePage implements Pt {

	public GooglePayFunc googlePay = new GooglePayFunc();

	public GooglePayStep() throws NoSuchEnvironmentException {

		Dado("que acessei a página Google Pay", () -> {
			googlePay.acessarPagina();
		});

		Entao("^a pagina Google Pay é apresentada contendo os textos \"([^\"]*)\" e \"([^\"]*)\"$",
				(String titulo, String subtitulo) -> {
					googlePay.verificarTexto(titulo);
					googlePay.verificarTexto(subtitulo);
				});
	}

}