package br.com.elo.qa.tests.web.steps;

import br.com.elo.qa.framework.commons.exceptions.NoSuchEnvironmentException;
import br.com.elo.qa.testes.web.lib.funcionalidades.CadastroUsuarioFunc;
import br.com.elo.qa.testes.web.lib.funcionalidades.HomeDeslogadaFunc;
import br.com.elo.qa.testes.web.lib.page.factory.BasePage;
import br.com.elo.qa.testes.web.lib.utils.CpfGenerator;
import br.com.elo.qa.testes.web.lib.utils.enums.CheckboxCadastro;
import cucumber.api.java8.Pt;

@SuppressWarnings("deprecation")
public class CadastroUsuarioStep extends BasePage implements Pt {

	CadastroUsuarioFunc cadastroUsuario = new CadastroUsuarioFunc();
	HomeDeslogadaFunc homeDeslogada = new HomeDeslogadaFunc();
	String cpfCadastrado = "";

	public CadastroUsuarioStep() throws NoSuchEnvironmentException {

		Dado("que estou na tela de cadastro", () -> {
			waitForLoad(getDriver());
			getUrl("url");
			homeDeslogada.clicarBotaoCadastreSe();
		});

		Dado("^que realizo o preenchimento da tela com os dados \"([^\"]*)\", \"([^\"]*)\",\"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\"$",
				(String cpf, String nome, String dataNascimento, String celular, String email, String confEmail,
						String senha, String confSenha, Boolean liEConcordo) -> {
					if (cpf.equals("Random")) {
						cpf = CpfGenerator.gerarCpf(true);
					}
					cadastroUsuario
						.preencherDadosUsuario(cpf, nome, dataNascimento, celular, email, confEmail, senha, confSenha)
						.marcarCheckbox(CheckboxCadastro.LI_CONCORDO, liEConcordo);
					cpfCadastrado = cpf;
				});

		Quando("^clico no botão Cadastrar$", () -> {
			cadastroUsuario.clicarBotaoCadastrarStep1();
		});

		Então("^vejo a mensagem de erro \"([^\"]*)\"$", (String mensagemErro) -> {
			cadastroUsuario.verificarMensagem(mensagemErro);
		});

		Dado("^que preencho o campo CEP com valor \"([^\"]*)\"$", (String cep) -> {
			cadastroUsuario.preencherCep(cep);
		});

		Quando("^finalizar o loading da busca do cep$", () -> {
			cadastroUsuario.checkFinishLoading();
		});

		Entao("^será preenchido os campos de endereço com os valores \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$",
				(String endereco, String numero, String complemento, String bairro, String cidade, String estado) -> {
					cadastroUsuario.checarInformacoesEndereco(endereco, numero, complemento, bairro, cidade, estado);
				});

		Dado("^que preencho os campos \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$",
				(String cpf, String nome, String dataNascimento, String celular, String email, String senha,
						Boolean liEConcordo, Boolean checkEmail, Boolean checkSMS) -> {
					if (cpf.equals("Random")) {
						cpf = CpfGenerator.gerarCpf(true);
					}
					cadastroUsuario
						.preencherDadosUsuario(cpf, nome, dataNascimento, celular, email, email, senha, senha)
						.marcarCheckbox(CheckboxCadastro.LI_CONCORDO, liEConcordo)
						.marcarCheckbox(CheckboxCadastro.EMAIL, checkEmail)
						.marcarCheckbox(CheckboxCadastro.SMS, checkSMS);
					cpfCadastrado = cpf;
				});

		E("^preencho os campos \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$",
				(String cep, String endereco, String numero, String complemento, String bairro, String cidade,
						String estado) -> {
					cadastroUsuario.preencherEndereco(cep, endereco, numero, complemento, bairro, cidade, estado);
				});

		Entao("^será exibido o segundo passo do cadastro$", () -> {
			cadastroUsuario.verificarSeExibiuSegundoPasso();
		});

		E("^avanço para o passo 2$", () -> {
			cadastroUsuario.clicarBotaoCadastrarStep1()
				.checkFinishLoading();
		});

		Quando("^preencho na tela de cartão os valores \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$",
				(String binCartao, String mes, String ano) -> {
					cadastroUsuario.preencherCartao(binCartao, mes, ano);
				});

		E("^clico em Finalizar$", () -> {
			cadastroUsuario.clicarBotaoFinalizarStep2()
				.checkFinishLoading();
		});

		Entao("^vejo a mensagem de sucesso \"([^\"]*)\"$", (String mensagemSucesso) -> {
			cadastroUsuario.verificarMensagem(mensagemSucesso);
		});

		E("^o botão Navegar no site Elo$", () -> {
			cadastroUsuario.verificarBotaoNavegarSiteElo();
		});

		E("o usuário cadastrado será excluido da base via API", () -> {
			System.out.println("Excluindo usuário " + cpfCadastrado);
			cadastroUsuario.excluirUsuarioCadastrado(cpfCadastrado);
		});
	}

}