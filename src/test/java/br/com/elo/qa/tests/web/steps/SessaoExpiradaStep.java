package br.com.elo.qa.tests.web.steps;

import br.com.elo.qa.framework.commons.exceptions.NoSuchEnvironmentException;
import br.com.elo.qa.testes.web.lib.funcionalidades.HomeDeslogadaFunc;
import br.com.elo.qa.testes.web.lib.funcionalidades.LoginFunc;
import br.com.elo.qa.testes.web.lib.funcionalidades.MeusCartoesFunc;
import br.com.elo.qa.testes.web.lib.funcionalidades.SessaoExpiradaFunc;
import br.com.elo.qa.testes.web.lib.page.factory.BasePage;
import cucumber.api.java8.Pt;

@SuppressWarnings("deprecation")
public class SessaoExpiradaStep extends BasePage implements Pt {

	public HomeDeslogadaFunc homeDeslogada = new HomeDeslogadaFunc();
	public MeusCartoesFunc meusCartoes = new MeusCartoesFunc();
	public LoginFunc login = new LoginFunc();
	public SessaoExpiradaFunc sessaoExpirada = new SessaoExpiradaFunc();

	public SessaoExpiradaStep() throws NoSuchEnvironmentException {

		E("fiz login com usuário \"([^\"]*)\" e senha \"([^\"]*)\"", (String cpf, String senha) -> {
			homeDeslogada.acessarLogin();
			login.preencherCpf(cpf)
				.preencherSenha(senha)
				.clicarBotaoEntrar()
				.checkFinishLoading();
		});

		Quando("expirar a sessão do usuário", () -> {
			sessaoExpirada.expirarSessaoUsuario();
		});

		E("acessar a página Meus Cartões com sessão expirada", () -> {
			meusCartoes.acessarPaginaMeusCartoes();
		});

		Entao("o modal de sessão expirada é exibido", () -> {
			sessaoExpirada.verificarModalExibido();
		});

		E("exibir o modal de sessão expirada", () -> {
			meusCartoes.acessarPaginaMeusCartoes();
			sessaoExpirada.verificarModalExibido();
		});

		E("preencher o modal de sessão expirada com a senha \"([^\"]*)\"", (String senha) -> {
			sessaoExpirada.preencherCampoSenha(senha);
		});

		E("clicar no botão Continuar do modal de sessão expirada", () -> {
			sessaoExpirada.clicarBotaoContinuar()
				.checkFinishLoading();
		});

		Entao("será exibido o modal de erro com o texto \"([^\"]*)\"", (String mensagem) -> {
			sessaoExpirada.verificarTexto(mensagem);
		});

		Entao("a sessão do usuário será renovada, com a página Meus Cartoes recarregada", () -> {
			meusCartoes.verificarCampoCartoes();
		});

	}

}