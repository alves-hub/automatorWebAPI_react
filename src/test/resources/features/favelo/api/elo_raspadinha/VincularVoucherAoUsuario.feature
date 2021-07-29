#language: pt
#Author:Jefferson Alves (jefferson.alves@dextra-sw.com)
@API @availableSite @regressionSite @testAPIss
Funcionalidade: API elo Ofertas - Vincular voucher ao usuário

  Esquema do Cenario: POST Vincular voucher ao usuário
    Dado que realizo o POST para Vincular voucher ao usuario <StatusCode>
    Então validando response vincular voucher <StatusCode>

    Exemplos: 
      | StatusCode |
      |        200 |
 
  Esquema do Cenario: POST Vincular voucher ao usuário sem Access Token
    Dado que realizo o POST para Vincular voucher ao usuario <StatusCode>
    Então validando response vincular voucher <StatusCode>
  

    Exemplos: 
      | StatusCode |
      |        401 |