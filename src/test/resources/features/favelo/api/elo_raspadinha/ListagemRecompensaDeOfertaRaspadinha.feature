#language: pt
#Author:Jefferson Alves (jefferson.alves@dextra-sw.com)

@API @availableSite @regressionSite
Funcionalidade: API elo Raspadinha - Listagem das recompensas vinculadas com a raspadinha

  Esquema do Cenario: GET Listagem das recompensas vinculadas com a raspadinha com Sucesso
    Dado realizo o GET para exibir a lista  
    Então validando response listagem de recompensa com sucesso <StatusCode>

    Exemplos: 
      | StatusCode |
      |        200 |


  Esquema do Cenario: GET Listagem das recompensas vinculadas com a raspadinha sem sucesso - Bad request
		Dado realizo o GET para exibir a lista raffleuuid incorreto
    Então validando response listagem de recompensa sem sucesso <StatusCode>

    Exemplos: 
      | StatusCode |
      |        400 |
      