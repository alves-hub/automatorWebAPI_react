package br.com.elo.qa.tests.web.steps;

import br.com.elo.qa.framework.commons.exceptions.NoSuchEnvironmentException;
import br.com.elo.qa.testes.web.lib.funcionalidades.CanaisDeContatoFunc;
import br.com.elo.qa.testes.web.lib.page.factory.BasePage;
import cucumber.api.java8.Pt;

@SuppressWarnings("deprecation")
public class CanaisDeContatoStep extends BasePage implements Pt {

	public CanaisDeContatoFunc canaisDeContato = new CanaisDeContatoFunc();

	public CanaisDeContatoStep() throws NoSuchEnvironmentException {

		Dado("que acessei a página Canais de Contato", () -> {
			canaisDeContato.acessarPagina();
		});

		Entao("^a pagina Canais de Contato é apresentada contendo os textos \"([^\"]*)\" e \"([^\"]*)\"$",
				(String titulo, String subtitulo) -> {
					canaisDeContato.verificarTexto(titulo);
					canaisDeContato.verificarTexto(subtitulo);
				});

		Dado("que estou na página de Canais de Contato", () -> {
			canaisDeContato.acessarPagina();
		});

		Quando("preencho o campo de busca com o valor \"([^\"]*)\"", (String valorBusca) -> {
			canaisDeContato.preencherValorCampoBusca(valorBusca);
		});

		Então("é exibido o contato \"([^\"]*)\" do tipo \"([^\"]*)\"", (String contato, String tipo) -> {
			canaisDeContato.verificarTexto(contato);
			canaisDeContato.verificarTexto(tipo);
		});

		E("a classificação do contato é da classificação \"([^\"]*)\"", (String classificacao) -> {
			canaisDeContato.verificarTexto(classificacao);
		});

		Então("será exibido a mensagem \"([^\"]*)\"", (String mensagem) -> {
			canaisDeContato.verificarTexto(mensagem);
		});
	}
}