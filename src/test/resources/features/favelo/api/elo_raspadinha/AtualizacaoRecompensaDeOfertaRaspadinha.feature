#language: pt
#Author:Jefferson Alves (jefferson.alves@dextra-sw.com)

@API @availableSite @regressionSite
Funcionalidade: API Raspadinha - Atualização de recompensa da Oferta Raspadinha
  
  Esquema do Cenario: PUT Atualização das recompensas vinculadas a raspadinha.com Sucesso
    Dado realizo o PUT para alterar e atualizar a nome e descricao  
    Então validando response atualizacao de recompensa com sucesso <StatusCode>

    Exemplos: 
      | StatusCode |
      |        204 |


  Esquema do Cenario: PUT Atualização das recompensas vinculadas a raspadinha. - Bad request
		Dado realizo o PUT para alterar e atualizar a nome e descrição com nome vazio 
    Então validando response atualizacao de recompensa sem sucesso <StatusCode>

    Exemplos: 
      | StatusCode |
      |        400 |
      