#language: pt
#Author:Jefferson Alves (jefferson.alves@dextra-sw.com)

@API @availableSite @regressionSite
Funcionalidade: Validacão API elo Raspadinha - Remover uma recompensa viculada a oferta

  Esquema do Cenario: DELETE - Raffle com Sucesso
    Dado que realizo o DELETE no raffleuuid da raspadinha
    Então validar statusCode do response Delete com sucesso <StatusCode>

    Exemplos: 
      | StatusCode |
      |        204 |


  Esquema do Cenario: DELETE - Raffle com e dados incorretos
    Dado que realizo o DELETE no raffleuuid da raspadinha dado incorretos
    Então validar statusCode do response Delete com dado incorreto <StatusCode>

    Exemplos: 
      | StatusCode |
      |        400 |
