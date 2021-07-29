package br.com.elo.qa.tests.web.steps;

import br.com.elo.qa.framework.commons.exceptions.NoSuchEnvironmentException;
import br.com.elo.qa.testes.web.lib.funcionalidades.HomeDeslogadaFunc;
import br.com.elo.qa.testes.web.lib.funcionalidades.MarcaEloFunc;
import br.com.elo.qa.testes.web.lib.page.factory.BasePage;
import cucumber.api.java8.Pt;

@SuppressWarnings("deprecation")
public class MarcaEloStep extends BasePage implements Pt {

	public HomeDeslogadaFunc homeDeslogada = new HomeDeslogadaFunc();
	public MarcaEloFunc marcaElo = new MarcaEloFunc();

	public MarcaEloStep() throws NoSuchEnvironmentException {

		Dado("que estou na página Marca Elo", () -> {
			marcaElo.acessarPaginaMarcaElo();
		});

		Entao("^a pagina Marca Elo é apresentada contendo os textos \"([^\"]*)\" e \"([^\"]*)\"$",
				(String titulo, String subtitulo) -> {
					marcaElo.verificarTexto(titulo);
					marcaElo.verificarTexto(subtitulo);
				});
	}

}