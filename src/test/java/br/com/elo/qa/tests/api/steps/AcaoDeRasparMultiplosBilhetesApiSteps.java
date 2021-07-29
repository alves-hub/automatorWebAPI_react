package br.com.elo.qa.tests.api.steps;

import java.io.IOException;
import java.util.List;

import br.com.elo.qa.tests.site.elo.lib.api.funcionalities.AcaoDeRasparMultiplosBilhetesApiFunc;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;

public class AcaoDeRasparMultiplosBilhetesApiSteps {

	private String mult = null;
	
	AcaoDeRasparMultiplosBilhetesApiFunc raspando = new AcaoDeRasparMultiplosBilhetesApiFunc();

	@Dado("^realizo o POST para raspar multiplas raspadinha do usuário$")
	public void realizandoPOST(DataTable multiplos) throws InterruptedException {
		List<String> list = multiplos.asList(String.class);

		for (int a = 0; a < 3;) {
			mult = list.get(a);
			a++;
			raspando.raspaMultiplasRaspadinhaDoUsuario(mult);
		}
	}

	@Dado("^realizo o POST para raspar multiplas raspadinha com processamento em andamento$")
	public void raspaMultiplasRaspadinhaDoUsuarioBadRequest(DataTable multiplos) throws InterruptedException {
		List<String> list = multiplos.asList(String.class);

		for (int a = 0; a < 3;) {
			mult = list.get(a);
			a++;
			raspando.raspaMultiplasComProcessamentoEmAndamento(mult);
		}
	}

	@Então("^validando response raspagem multiplas raspadinhas com sucesso$")
	public void validandoResponseComSucesso(int code) throws IOException {
		raspando.validandoResponseRasparMultiplasRaspadinha(code);

	}

	@Então("^validando response raspagem multiplas raspadinhas com valor invalido$")
	public void validandoResponseSemSucesso(int code) {
		raspando.validandoResponseRasparMultiplasComValorInvalido(code);
	}

	@Então("^validando response raspagem multiplas com processo em andamento$")
	public void validandoResponseComProcessoEmAndamento(int code) {
		raspando.validandoResponseRasparMultiplasComProcessamentoEmAndamento(code);
	}

}