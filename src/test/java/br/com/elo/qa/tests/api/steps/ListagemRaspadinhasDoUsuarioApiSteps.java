package br.com.elo.qa.tests.api.steps;

import br.com.elo.qa.tests.site.elo.lib.api.funcionalities.ListagemRaspadinhasRaspadasDoUsuarioFunc;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;

public class ListagemRaspadinhasDoUsuarioApiSteps {

	ListagemRaspadinhasRaspadasDoUsuarioFunc listRaspadinha = new ListagemRaspadinhasRaspadasDoUsuarioFunc();

	@Dado("realizo o GET para exibir a lista da raspadinha do usuário")
	public void realizandoGET() {
		listRaspadinha.listagemRaspadinhasDoUsuario();
	}
	
	@Dado("realizo o GET para exibir a lista da raspadinha com client_id incorreto")
	public void realizandoGETDadosIncorretos() {
		listRaspadinha.listagemRaspadinhasDoUsuarioBadRequest();
	}

	@Então("validando response listagem da raspadinha com sucesso (.*)")
	public void validandoStatusResponse(int code) {
		listRaspadinha.validandoResponseRaspadinha(code);
	}

	@Então("validando response listagem da raspadinha sem sucesso (.*)")
	public void validandoResponse(int code) {
		listRaspadinha.validandoResponseRaspadinhaIncorreto(code);
	}
}