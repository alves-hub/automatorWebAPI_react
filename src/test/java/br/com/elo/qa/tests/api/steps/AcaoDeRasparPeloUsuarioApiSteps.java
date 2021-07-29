package br.com.elo.qa.tests.api.steps;

import java.io.IOException;

import br.com.elo.qa.tests.site.elo.lib.api.funcionalities.AcaoDeRasparPeloUsuarioApiFunc;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;

public class AcaoDeRasparPeloUsuarioApiSteps {

	AcaoDeRasparPeloUsuarioApiFunc raspando = new AcaoDeRasparPeloUsuarioApiFunc();

	@Dado("realizo o POST para raspar raspadinha do usuário")
	public void realizandoPOST(){
		raspando.raspaRaspadinhaDoUsuario();
	} 

	@Dado("realizo o POST para raspar raspadinha do usuário sem raspadinha")
	public void realizandoPOSTDadosIncorretos() {
		raspando.raspaRaspadinhaDoUsuarioBadRequest();
	}

	@Então("validando response raspagem da raspadinha com sucesso (.*)")
	public void validandoResponseComSucesso(int code) throws IOException {
		raspando.validandoResponseRasparRaspadinha(code);

	}

	@Então("validando response raspagem da raspadinha sem sucesso (.*)")
	public void validandoResponseSemSucesso(int code) {
		raspando.validandoResponseRasparRaspadinhaIncorreto(code);
	}
}