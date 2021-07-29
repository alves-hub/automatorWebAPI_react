#language: pt
#Author:Jefferson Alves (jefferson.alves@dextra-sw.com)

@API @availableSite @regressionSite @testAPI
Funcionalidade: API elo Raspadinha - Aplicar ou não uma recompensa ao usuário com base nas regras

  Esquema do Cenario: POST Acao de Raspar pelo usuario com Sucesso
    Dado realizo o POST para raspar raspadinha do usuário 
    Então validando response raspagem da raspadinha com sucesso <StatusCode>

    Exemplos: 
      | StatusCode |
      |        201 |


  Esquema do Cenario: POST Acao de Raspar pelo usuario sem Sucesso - Bad request
		Dado realizo o POST para raspar raspadinha do usuário sem raspadinha
    Então validando response raspagem da raspadinha sem sucesso <StatusCode>

    Exemplos: 
      | StatusCode |
      |        400 |
      