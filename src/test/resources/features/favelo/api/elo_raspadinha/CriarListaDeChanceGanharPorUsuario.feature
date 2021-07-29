#language: pt
#Author:Jefferson Alves (jefferson.alves@dextra-sw.com)

@API @availableSite @regressionSite @testAPI
Funcionalidade: API elo Raspadinha - Método para criar uma lista de chances de ganhar por usuário

  Esquema do Cenario: POST criar uma lista de chances de ganhar por usuário com Sucesso
    Dado realizo o POST para criar lista de chances de ganhar usuário 
    Então validando response lista de chances de ganhar raspadinha com sucesso <StatusCode>

    Exemplos: 
      | StatusCode |
      |        201 |


  Esquema do Cenario: POST criar uma lista de chances de ganhar por usuário sem Sucesso - Bad request
		Dado realizo o POST para criar lista de chances de ganhar usuário sem parametro isFirstScratchCard
    Então validando response lista de chances de ganhar raspadinha sem sucesso <StatusCode>

    Exemplos: 
      | StatusCode |
      |        422 |
      