package br.com.elo.qa.tests.web.steps;

import br.com.elo.qa.framework.commons.exceptions.NoSuchEnvironmentException;
import br.com.elo.qa.testes.web.lib.funcionalidades.HomeDeslogadaFunc;
import br.com.elo.qa.testes.web.lib.page.factory.BasePage;
import cucumber.api.java8.Pt;

@SuppressWarnings("deprecation")
public class HomeDeslogadaStep extends BasePage implements Pt {

	HomeDeslogadaFunc homeDeslogada = new HomeDeslogadaFunc();

	public HomeDeslogadaStep() throws NoSuchEnvironmentException {

		Dado("que estou no site Elo", () -> {
			waitForLoad(getDriver());
			getUrl("url");
		});

		Entao("a página home deslogada é exibida, contendo os textos \"([^\"]*)\", \"([^\"]*)\" e \"([^\"]*)\"",
				(String texto1, String texto2, String texto3) -> {
					homeDeslogada.verificarTexto(texto1)
						.verificarTexto(texto2)
						.verificarTexto(texto3);
				});
	}

}
