#language: pt
#Author:Jefferson Alves (jefferson.alves@dextra-sw.com)

@API @availableSite @regressionSite
Funcionalidade: API Raspadinha - Remoção recompensa da oferta

  Esquema do Cenario: DELETE  Remover recompensas vinculadas a raspadinha com Sucesso
    Dado realizo o DELETE para exclusao da recompensa cadastrada  
    Então validando response exclusao da recompensa com sucesso <StatusCode>

    Exemplos: 
      | StatusCode |
      |        204 |


  Esquema do Cenario: DELETE  Remover recompensas vinculadas a raspadinha sem Sucesso - Bad request
		Dado realizo o DELETE para exclusao da recompensa cadastrada com raffle incompleto
    Então validando response exclusao da recompensa sem sucesso <StatusCode>

    Exemplos: 
      | StatusCode |
      |        400 |
      