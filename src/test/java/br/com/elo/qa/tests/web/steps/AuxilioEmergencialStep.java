package br.com.elo.qa.tests.web.steps;

import br.com.elo.qa.framework.commons.exceptions.NoSuchEnvironmentException;
import br.com.elo.qa.testes.web.lib.funcionalidades.AuxilioEmergencialFunc;
import br.com.elo.qa.testes.web.lib.page.factory.BasePage;
import cucumber.api.java8.Pt;

@SuppressWarnings("deprecation")
public class AuxilioEmergencialStep extends BasePage implements Pt {

	public AuxilioEmergencialFunc auxilioEmergencial = new AuxilioEmergencialFunc();

	public AuxilioEmergencialStep() throws NoSuchEnvironmentException {

		Dado("que acessei a página Auxilio Emergencial", () -> {
			auxilioEmergencial.acessarPagina();
		});

		Entao("a pagina Auxilio Emergencial é apresentada contendo o texto \"([^\"]*)\"", (String texto) -> {
			auxilioEmergencial.verificarTexto(texto);
		});

		E("clico no link Onde comprar da opção \"([^\"]*)\"", (String opcao) -> {
			auxilioEmergencial.acessarPaginaInterna(opcao);
		});

		Entao("a pagina Auxilio Emergencial - \"([^\"]*)\" é apresentada contendo os textos \"([^\"]*)\" e \"([^\"]*)\"",
				(String pagina, String texto1, String texto2) -> {
					auxilioEmergencial.verificarTexto(texto1)
						.verificarTexto(texto2);
				});

		Dado("que estou na página de Auxílio Emergencial", () -> {
			auxilioEmergencial.acessarPagina();
		});

		E("cliquei no banner de Leads da página Auxílio Emergencial", () -> {
			auxilioEmergencial.acessarModalLeads();
		});

		Quando("preencher os campos com os valores \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\" e \"([^\"]*)\"",
				(String cpf, String nome, String dataNascimento, String celular, String email, Boolean recebeEmail,
						Boolean recebeSMS) -> {
					auxilioEmergencial.preencherCamposLeads(cpf, nome, dataNascimento, celular, email, recebeEmail,
							recebeSMS);
				});

		E("clicar no botão Enviar do Leads de Auxílio Emergencial", () -> {
			auxilioEmergencial.clicarBotaoEnviarLeads();
		});

		Entao("será exibido a mensagem de erro \"([^\"]*)\"", (String mensagemErro) -> {
			auxilioEmergencial.verificarTexto(mensagemErro);
		});

		Entao("será exibido a mensagem de sucesso \"([^\"]*)\" e \"([^\"]*)\"",
				(String mensagemSucesso1, String mensagemSucesso2) -> {
					auxilioEmergencial.verificarSucessoCadastroLeads(mensagemSucesso1, mensagemSucesso2);
				});
	}
}