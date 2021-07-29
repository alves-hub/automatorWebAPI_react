package br.com.elo.qa.tests.web.steps;

import br.com.elo.qa.framework.commons.exceptions.NoSuchEnvironmentException;
import br.com.elo.qa.testes.web.lib.funcionalidades.SobreAEloFunc;
import br.com.elo.qa.testes.web.lib.page.factory.BasePage;
import cucumber.api.java8.Pt;

@SuppressWarnings("deprecation")
public class SobreAEloStep extends BasePage implements Pt {

	public SobreAEloFunc sobreElo = new SobreAEloFunc();

	public SobreAEloStep() throws NoSuchEnvironmentException {

		Dado("que acessei a página Sobre a Elo", () -> {
			sobreElo.acessarPagina();
		});

		Entao("^a pagina Sobre a Elo é apresentada contendo os textos \"([^\"]*)\" e \"([^\"]*)\"$",
				(String titulo, String subtitulo) -> {
					sobreElo.verificarTexto(titulo);
					sobreElo.verificarTexto(subtitulo);
				});
	}

}