package br.com.elo.qa.tests.web.steps;

import br.com.elo.qa.framework.commons.exceptions.NoSuchEnvironmentException;
import br.com.elo.qa.testes.web.lib.funcionalidades.HomeDeslogadaFunc;
import br.com.elo.qa.testes.web.lib.funcionalidades.LoginFunc;
import br.com.elo.qa.testes.web.lib.funcionalidades.LogoutFunc;
import br.com.elo.qa.testes.web.lib.funcionalidades.MeusCartoesFunc;
import br.com.elo.qa.testes.web.lib.page.factory.BasePage;
import cucumber.api.java8.Pt;

@SuppressWarnings("deprecation")
public class LogoutStep extends BasePage implements Pt {

	public HomeDeslogadaFunc homeDeslogada = new HomeDeslogadaFunc();
	public MeusCartoesFunc meusCartoes = new MeusCartoesFunc();
	public LoginFunc login = new LoginFunc();
	public LogoutFunc logout = new LogoutFunc();

	public LogoutStep() throws NoSuchEnvironmentException {

		E("realizei o login no site com usuario \"([^\"]*)\" e senha \"([^\"]*)\"", (String cpf, String senha) -> {
			homeDeslogada.acessarLogin();
			login.preencherCpf(cpf)
				.preencherSenha(senha)
				.clicarBotaoEntrar()
				.checkFinishLoading();
		});

		Quando("clico no link Sair", () -> {
			meusCartoes.clicarAgoraNaoModalOnboarding();
			homeDeslogada.clicarBotaoSair();
		});

		Entao("é exibido a home deslogada com o texto \"([^\"]*)\" após o logout", (String texto) -> {
			homeDeslogada.verificarTexto(texto);
		});

		E("os botões CadastreSe e Login é exibido no canto superior direito", () -> {
			homeDeslogada.verificarBotoesCadastreSeELogin();
		});

		E("o cookie \"([^\"]*)\" foi removido da lista de cookies", (String cookie) -> {
			logout.verificarSeCookieFoiRemovido(cookie);
		});

	}

}