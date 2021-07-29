package br.com.elo.qa.tests.api.steps;

import br.com.elo.qa.tests.site.elo.lib.api.funcionalities.VincularVoucherAoUsuarioApiFunc;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;

public class VincularVouchersAoUsuarioApiSteps {

	VincularVoucherAoUsuarioApiFunc vincular = new VincularVoucherAoUsuarioApiFunc();

	@Dado("^que realizo o POST para Vincular voucher ao usuario (.*)$")
	public void realizandoGETRetornoVoucher(int code) throws InterruptedException {

		vincular.vincularVoucherAoUsuario(code);
	}

	@Dado("^que realizo o POST para Vincular voucher ao usuario sem access token (.*)$")
	public void realizandoGETRetornoVoucherErro(int code) throws InterruptedException {
		vincular.vincularVoucherAoUsuario(code);
	}

	@Então("^validando response vincular voucher (.*)$")
	public void validandoResponseVoucher(int code) {
		vincular.validandoResponseStatusRetornoVoucher(code);
	}

}