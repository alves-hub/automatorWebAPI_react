package br.com.elo.qa.tests.api.steps;

import java.io.IOException;

import br.com.elo.qa.tests.site.elo.lib.api.funcionalities.CriarListaDeChanceGanharPorUsuarioFunc;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;

public class CriarListaDeChanceGanharPorUsuarioSteps {

	CriarListaDeChanceGanharPorUsuarioFunc create = new CriarListaDeChanceGanharPorUsuarioFunc();

	@Dado("realizo o POST para criar lista de chances de ganhar usuário")
	public void realizandoPOST() {
		create.criandoListaDeChanceDeGanhar();
	}

	@Dado("realizo o POST para criar lista de chances de ganhar usuário sem parametro isFirstScratchCard")
	public void realizandoPOSTDadosIncorretos() {
		create.criandoListaDeChanceDeGanharBadRequest();
	}

	@Então("validando response lista de chances de ganhar raspadinha com sucesso (.*)")
	public void validandoResponseComSucesso(int code) throws IOException {
		create.validandoResponseListaDeChanceGanhar(code);

	}

	@Então("validando response lista de chances de ganhar raspadinha sem sucesso (.*)")
	public void validandoResponseSemSucesso(int code) {
		create.validandoResponseListaDeChanceGanharBadRequest(code);
	}
}