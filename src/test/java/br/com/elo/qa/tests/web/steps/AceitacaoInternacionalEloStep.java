package br.com.elo.qa.tests.web.steps;

import br.com.elo.qa.framework.commons.exceptions.NoSuchEnvironmentException;
import br.com.elo.qa.testes.web.lib.funcionalidades.AceitacaoInternacionalEloFunc;
import br.com.elo.qa.testes.web.lib.page.factory.BasePage;
import cucumber.api.java8.Pt;

@SuppressWarnings("deprecation")
public class AceitacaoInternacionalEloStep extends BasePage implements Pt {

	AceitacaoInternacionalEloFunc aceitacaoInternacional = new AceitacaoInternacionalEloFunc();

	public AceitacaoInternacionalEloStep() throws NoSuchEnvironmentException {

		Dado("que acessei a página Aceitação Internacional Elo", () -> {
			aceitacaoInternacional.acessarPagina();
		});

		Entao("^a pagina é apresentada contendo os textos \"([^\"]*)\" e \"([^\"]*)\"$",
				(String titulo, String subtitulo) -> {
					aceitacaoInternacional.verificarTexto(titulo)
						.verificarTexto(subtitulo)
						.tirarScreenshot();
				});
	}
}