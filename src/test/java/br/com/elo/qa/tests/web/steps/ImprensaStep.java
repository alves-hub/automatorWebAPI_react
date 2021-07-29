package br.com.elo.qa.tests.web.steps;

import br.com.elo.qa.framework.commons.exceptions.NoSuchEnvironmentException;
import br.com.elo.qa.testes.web.lib.funcionalidades.ImprensaFunc;
import br.com.elo.qa.testes.web.lib.page.factory.BasePage;
import cucumber.api.java8.Pt;

@SuppressWarnings("deprecation")
public class ImprensaStep extends BasePage implements Pt {

	public ImprensaFunc imprensa = new ImprensaFunc();

	public ImprensaStep() throws NoSuchEnvironmentException {

		Dado("que acessei a página Imprensa", () -> {
			imprensa.acessarPagina();
		});

		Entao("a pagina Imprensa é apresentada contendo o texto \"([^\"]*)\"", (String titulo) -> {
			imprensa.verificarTexto(titulo);
		});

		Dado("que estou na página de Imprensa", () -> {
			imprensa.acessarPagina();
		});

		Quando("clico no saiba mais da notícia \"([^\"]*)\"", (String noticia) -> {
			imprensa.acessarDetalhesNoticia(noticia);
		});

		Entao("a página \"([^\"]*)\" é carregada", (String uri) -> {
			imprensa.verificarPaginaInternaCarregada(uri);
		});

		E("será apresentado os textos \"([^\"]*)\" e \"([^\"]*)\"", (String titulo, String subtitulo) -> {
			imprensa.verificarTexto(titulo);
			imprensa.verificarTexto(subtitulo);
		});
	}

}