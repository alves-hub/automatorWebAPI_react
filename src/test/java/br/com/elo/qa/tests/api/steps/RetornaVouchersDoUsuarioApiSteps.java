package br.com.elo.qa.tests.api.steps;

import br.com.elo.qa.tests.site.elo.lib.api.funcionalities.RetornaVouchersDoUsuarioApiFunc;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;

public class RetornaVouchersDoUsuarioApiSteps {

	RetornaVouchersDoUsuarioApiFunc vouchers = new RetornaVouchersDoUsuarioApiFunc();

	@Dado("^que realizo o GET para retornar voucher do usuario (.*)$")
	public void realizandoGETRetornoVoucher(int code) throws InterruptedException {

		vouchers.retornaVoucherDoUsuario(code);
	}

	@Dado("^que realizo o GET para retornar voucher sem access token (.*)$")
	public void realizandoGETRetornoVoucherErro(int code) throws InterruptedException {
		vouchers.retornaVoucherDoUsuario(code);
	}

	@Então("^validando response retorno voucher (.*)$")
	public void validandoResponseVoucher(int code) {
		vouchers.validandoResponseStatusRetornoVoucher(code);
	}

}