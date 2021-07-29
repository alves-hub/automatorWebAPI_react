#language: pt
#Author:Jefferson Alves (jefferson.alves@dextra-sw.com)

@API @availableSite @regressionSite
Funcionalidade: API elo Raspadinha - Listagem das raspadinhas premidas, raspadas ou não premiadas do usuário

  Esquema do Cenario: GET Listagem das raspadinhas com Sucesso
    Dado realizo o GET para exibir a lista da raspadinha do usuário 
    Então validando response listagem da raspadinha com sucesso <StatusCode>

    Exemplos: 
      | StatusCode |
      |        200 |


  Esquema do Cenario: GET Listagem das raspadinhas do usuario sem sucesso - Bad request
		Dado realizo o GET para exibir a lista da raspadinha com client_id incorreto
    Então validando response listagem da raspadinha sem sucesso <StatusCode>

    Exemplos: 
      | StatusCode |
      |        401 |
      