#language: pt
#Author:Jefferson Alves (jefferson.alves@dextra-sw.com)

@API @availableSite @regressionSite
Funcionalidade: API Raspadinha - Cadastro de ofertas do tipo Raspadinha
  
  Esquema do Cenario: POST Criar Raffle com Sucesso
    Dado que realizo o post na API Raspadinha Criar Raffle
    Então validar response e statusCode <StatusCode>

    Exemplos: 
      | StatusCode |
      |        201 |


  Esquema do Cenario: POST Criar Raffle com dados incorretos
    Dado que realizo o post na API Raspadinha com dados incorretos
    Então validar statusCode do response Post dado incorreto <StatusCode>

    Exemplos: 	
      | StatusCode |
      |        422 |
      