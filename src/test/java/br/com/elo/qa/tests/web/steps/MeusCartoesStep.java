package br.com.elo.qa.tests.web.steps;

import br.com.elo.qa.framework.commons.exceptions.NoSuchEnvironmentException;
import br.com.elo.qa.testes.web.lib.funcionalidades.CadastroUsuarioFunc;
import br.com.elo.qa.testes.web.lib.funcionalidades.MeusCartoesFunc;
import br.com.elo.qa.testes.web.lib.page.factory.BasePage;
import cucumber.api.java8.Pt;

@SuppressWarnings("deprecation")
public class MeusCartoesStep extends BasePage implements Pt {

	public MeusCartoesFunc meusCartoes = new MeusCartoesFunc();
	public CadastroUsuarioFunc cadastroUsuario = new CadastroUsuarioFunc();

	String numeroCartaoNovo = "";

	public MeusCartoesStep() throws NoSuchEnvironmentException {

		Entao("a página Meus Cartões é exibida com o onboarding", () -> {
			meusCartoes.verificarPaginaComOnboardingCarregada()
				.verificarCampoCartoes();
		});

		Dado("que cliquei no botão de adicionar cartão", () -> {
			meusCartoes.clicarAgoraNaoModalOnboarding()
				.clicarBotaoAdicionarCartaoSelect();
		});

		Quando("preencho no modal de cartão os valores \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"",
				(String binCartao, String mes, String ano) -> {
					cadastroUsuario.preencherCartao(binCartao, mes, ano);
					numeroCartaoNovo = cadastroUsuario.resgatarNumeroCartao();
				});

		E("clico no botão Adicionar este cartão", () -> {
			meusCartoes.clicarBotaoFinalizarCadastroCartao();
		});

		Entao("vejo no modal de cadastro de cartão a mensagem de erro \"([^\"]*)\"", (String mensagemErro) -> {
			meusCartoes.checkFinishLoading()
				.verificarTexto(mensagemErro);
		});

		E("o cartão é adicionado com sucesso e é automaticamente selecionado no select de cartão, exibindo os 4 últimos dígitos",
				() -> {
					meusCartoes.checkFinishLoading()
						.verificarCartaoSelecionado(numeroCartaoNovo);
				});
		
		E("o cartão será excluido via api",
				() -> {
					meusCartoes.excluirCartoes();
				});

	}

}