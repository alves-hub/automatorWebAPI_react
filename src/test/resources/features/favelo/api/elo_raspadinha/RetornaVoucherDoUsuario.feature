#language: pt
#Author:Jefferson Alves (jefferson.alves@dextra-sw.com)
@API @availableSite @regressionSite @testAPIss
Funcionalidade: API elo Ofertas - Retorna voucherdo usuário

  Esquema do Cenario: GET Retorna voucher do usuário
    Dado que realizo o GET para retornar voucher do usuario <StatusCode>
    Então validando response retorno voucher <StatusCode>

    Exemplos: 
      | StatusCode |
      |        200 |
 
  Esquema do Cenario: GET Retorna voucher do usuário sem acess token
    Dado que realizo o GET para retornar voucher sem access token <StatusCode>
    Então validando response retorno voucher <StatusCode>
  

    Exemplos: 
      | StatusCode |
      |        401 |