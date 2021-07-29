#language: pt
#Author:Jefferson Alves (jefferson.alves@dextra-sw.com)

@API @availableSite @regressionSite
Funcionalidade: API Raspadinha - Recompensa de oferta tipo Raspadinha

  Esquema do Cenario: POST Criar Rewards com Sucesso
    Dado que adiciono um premio na oferta do tipo raspadinha
    Então validando response cadastro de recompensa com sucesso <StatusCode>

    Exemplos: 
      | StatusCode |
      |        201 |


  Esquema do Cenario: POST Criar Rewards sem sucesso - Bad request
		Dado que adiciono um premio na oferta do tipo raspadinha sem nome da oferta
    Então validando response cadastro de recompensa sem sucesso <StatusCode>

    Exemplos: 
      | StatusCode |
      |        400 |
      