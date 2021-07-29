package br.com.elo.qa.tests.web.steps;

import br.com.elo.qa.framework.commons.exceptions.NoSuchEnvironmentException;
import br.com.elo.qa.testes.web.lib.funcionalidades.InstituicaoDomicilioFunc;
import br.com.elo.qa.testes.web.lib.page.factory.BasePage;
import cucumber.api.java8.Pt;

@SuppressWarnings("deprecation")
public class InstituicaoDomicilioStep extends BasePage implements Pt {

	public InstituicaoDomicilioFunc instituicaoDomicilio = new InstituicaoDomicilioFunc();

	public InstituicaoDomicilioStep() throws NoSuchEnvironmentException {

		Dado("que acessei a página Participantes do Arranjo Elo", () -> {
			instituicaoDomicilio.acessarPagina();
		});
		// \"([^\"]*)\"

		Entao("a pagina Instituicao de Domicilio é apresentada contendo os textos \"([^\"]*)\" e \"([^\"]*)\"",
				(String titulo, String subtitulo) -> {
					instituicaoDomicilio.verificarTexto(titulo)
						.verificarTexto(subtitulo);
				});

		Dado("que estou na página de Instituicao de Domicilio", () -> {
			instituicaoDomicilio.acessarPagina();
		});

		Quando("preencho o campo de busca de instituicao com o valor \"([^\"]*)\"", (String valorBusca) -> {
			instituicaoDomicilio.preencherValorCampoBusca(valorBusca);
		});

		Então("é exibido o participante \"([^\"]*)\" com CNPJ \"([^\"]*)\" arranjo \"([^\"]*)\" e papel no arranjo \"([^\"]*)\"",
				(String participante, String cnpj, String arranjo, String papelNoArranjo) -> {
					instituicaoDomicilio.verificarTexto(participante)
						.verificarTexto(cnpj)
						.verificarTexto(arranjo)
						.verificarTexto(papelNoArranjo);
				});

		Então("será exibido na tabela de instituicao a mensagem \"([^\"]*)\"", (String mensagem) -> {
			instituicaoDomicilio.verificarTexto(mensagem);
		});
	}
}