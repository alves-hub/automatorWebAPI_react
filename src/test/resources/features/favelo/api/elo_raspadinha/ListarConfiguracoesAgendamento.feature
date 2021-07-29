#language: pt
#Author:Jefferson Alves (jefferson.alves@dextra-sw.com)
@API @availableSite @regressionSite @testAPIs 
Funcionalidade: API elo Raspadinha - Listagem configurações de agendamento

  Esquema do Cenario: GET Listar configuracoes de agendamento - Ativa
    Dado que realizo o GET para Listar usuario ativo para funcao agendamento semanal <Agendamento>
    Então validando response lista configuracao agendamento ativo <StatusCode> <Agendamento>

    Exemplos: 
      | StatusCode | Agendamento |
      |        201 | false       |

  Esquema do Cenario: GET Listar configuracoes de agendamento - Inativo
    Dado que realizo o GET para Listar usuario Inativo para funcao agendamento semanal <Agendamento>
    Então validando response lista configuracao agendamento inativo <StatusCode> <Agendamento>

    Exemplos: 
      | StatusCode | Agendamento |
      |        201 | true     |
 
  Esquema do Cenario: GET Listar configuracoes de agendamento - Bad Request
    Dado que realizo o GET com Raffle invalido <Agendamento>
    Então validando response com raffle invalido <StatusCode> <Agendamento>

    Exemplos: 
      | StatusCode | Agendamento |
      |        404 | BadRequest  |
