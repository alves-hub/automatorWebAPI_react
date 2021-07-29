package br.com.elo.qa.tests.web.steps;

import br.com.elo.qa.framework.commons.exceptions.NoSuchEnvironmentException;
import br.com.elo.qa.testes.web.lib.funcionalidades.TrabalheConoscoFunc;
import br.com.elo.qa.testes.web.lib.page.factory.BasePage;
import cucumber.api.java8.Pt;

@SuppressWarnings("deprecation")
public class TrabalheConoscoStep extends BasePage implements Pt {

	public TrabalheConoscoFunc trabalheConosco = new TrabalheConoscoFunc();

	public TrabalheConoscoStep() throws NoSuchEnvironmentException {

		Dado("que acessei a página Trabalhe Conosco", () -> {
			trabalheConosco.acessarPagina();
		});

		Entao("a pagina Trabalhe Conosco é apresentada contendo os textos \"([^\"]*)\" e \"([^\"]*)\"",
				(String titulo, String subtitulo) -> {
					trabalheConosco.verificarTexto(titulo)
						.verificarTexto(subtitulo);
				});
	}

}