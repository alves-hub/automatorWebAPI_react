#language: pt
#Author:Jefferson Alves (jefferson.alves@dextra-sw.com)
 @availableSite @regressionSite 
Funcionalidade: API elo Raspadinha - Raspar multiplas raspadinha

  Cenario: POST Acao de Raspar multiplos bilhetes com Sucesso
    Dado realizo o POST para raspar multiplas raspadinha do usuário
      |  10 |
      |  50 |
      | 100 |
    Então validando response raspagem multiplas raspadinhas com sucesso
      | 200 |

  Cenario: POST Acao de Raspar multiplos bilhetes com valor invalido
    Dado realizo o POST para raspar multiplas raspadinha do usuário
      |  11 |
      |  51 |
      | 101 |
    Então validando response raspagem multiplas raspadinhas com valor invalido
      | 400 |
@APIerror
  Cenario: POST Acao de Raspar multiplos bilhetes com processamento em andamento
    Dado realizo o POST para raspar multiplas raspadinha com processamento em andamento
      | 10  |
      | 50  |
      | 100 |
    Então validando response raspagem multiplas com processo em andamento
      | 404 |
