package br.com.elo.qa.tests.web.steps;

import br.com.elo.qa.framework.commons.exceptions.NoSuchEnvironmentException;
import br.com.elo.qa.testes.web.lib.funcionalidades.AvisoDePrivacidadeFunc;
import br.com.elo.qa.testes.web.lib.page.factory.BasePage;
import cucumber.api.java8.Pt;

@SuppressWarnings("deprecation")
public class AvisoDePrivacidadeStep extends BasePage implements Pt {

	public AvisoDePrivacidadeFunc avisoDePrivacidade = new AvisoDePrivacidadeFunc();

	public AvisoDePrivacidadeStep() throws NoSuchEnvironmentException {

		Dado("que acessei a página Aviso de Privacidade", () -> {
			avisoDePrivacidade.acessarPagina();
		});

		Entao("a pagina Aviso de Privacidade é apresentada contendo os textos \"([^\"]*)\" e \"([^\"]*)\"",
				(String titulo, String subtitulo) -> {
					avisoDePrivacidade.verificarTexto(titulo)
						.verificarTexto(subtitulo);
				});
	}

}