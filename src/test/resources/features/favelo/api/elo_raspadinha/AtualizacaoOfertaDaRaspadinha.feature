#language: pt
#Author:Jefferson Alves (jefferson.alves@dextra-sw.com)

@API @availableSite @regressionSite
Funcionalidade: API Raspadinha - Atualização de Oferta do tipo raspadinha

  Esquema do Cenario: PUT - Atualizar Raffle com Sucesso
    Dado que realizo o PUT na API Raspadinha para atualizacao
    Então validar statusCode do response put com sucesso <StatusCode> 

    Exemplos: 
      | StatusCode |
      |        204 |
 

  Esquema do Cenario: PUT - Atualizar Raffle com dados incorretos
    Dado que realizo o PUT na API Raspadinha para atualizacao com dados incorreto
    Então validar statusCode do response dados incorretos <StatusCode>

    Exemplos: 
      | StatusCode |
      |        422 |
