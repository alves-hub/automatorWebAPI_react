package br.com.elo.qa.tests.web.steps;

import br.com.elo.qa.framework.commons.exceptions.NoSuchEnvironmentException;
import br.com.elo.qa.testes.web.lib.funcionalidades.HomeDeslogadaFunc;
import br.com.elo.qa.testes.web.lib.funcionalidades.LoginFunc;
import br.com.elo.qa.testes.web.lib.funcionalidades.MeusCartoesFunc;
import br.com.elo.qa.testes.web.lib.page.factory.BasePage;
import cucumber.api.java8.Pt;

@SuppressWarnings("deprecation")
public class LoginStep extends BasePage implements Pt {

	public HomeDeslogadaFunc homeDeslogada = new HomeDeslogadaFunc();
	public MeusCartoesFunc meusCartoes = new MeusCartoesFunc();
	public LoginFunc login = new LoginFunc();

	public LoginStep() throws NoSuchEnvironmentException {

		E("acessei a tela de login", () -> {
			homeDeslogada.acessarLogin();
		});

		Entao("a pagina de login é apresentada com os campos CPF e Senha", () -> {
			login.verificarCamposCPFESenha();
		});

		Quando("preencher os campos CPF e Senha com os valores \"([^\"]*)\" e \"([^\"]*)\"",
				(String cpf, String senha) -> {
					login.preencherCpf(cpf)
						.preencherSenha(senha);
				});

		E("clicar em Entrar", () -> {
			login.clicarBotaoEntrar();
		});

		Entao("valido na tela de login a mensagem de erro \"([^\"]*)\"", (String mensagem) -> {
			login.verificarTexto(mensagem);
		});

		Entao("a página Meus Cartões é exibida", () -> {
			meusCartoes.verificarPaginaComOnboardingCarregada()
				.verificarCampoCartoes();
		});

		E("os botões Cadastre-se e Login será substituido pelo texto \"([^\"]*)\"", (String textoOla) -> {
			meusCartoes.verificarTexto(textoOla);
		});

	}

}