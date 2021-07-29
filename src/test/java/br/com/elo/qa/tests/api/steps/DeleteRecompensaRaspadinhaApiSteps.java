package br.com.elo.qa.tests.api.steps;

import br.com.elo.qa.tests.site.elo.lib.api.funcionalities.DeleteRecompensaOfertaRaspadinhaApiFunc;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;

public class DeleteRecompensaRaspadinhaApiSteps {

	DeleteRecompensaOfertaRaspadinhaApiFunc rewards = new DeleteRecompensaOfertaRaspadinhaApiFunc();

	@Dado("realizo o DELETE para exclusao da recompensa cadastrada")
	public void realizandoPost() {
		rewards.deleteAtualizarRecompensa();
	}
	
	@Dado("realizo o DELETE para exclusao da recompensa cadastrada com raffle incompleto")
	public void realizandoPostDadosIncorretos() {
		rewards.deleteAtualizarRecompensaBadRequest();
	}
	
	@Então("validando response exclusao da recompensa com sucesso (.*)")
	public void validandoStatusResponse(int code) {
		rewards.validandoResponseRecompensaRaspadinha(code);
	}

	@Então("validando response exclusao da recompensa sem sucesso (.*)")
	public void validandoResponse(int code) {
		rewards.validandoResponseRecompensaIncorreto(code);
	}
}