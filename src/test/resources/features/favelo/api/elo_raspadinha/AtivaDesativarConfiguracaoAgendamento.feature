#language: pt
#Author:Jefferson Alves (jefferson.alves@dextra-sw.com)
@API @availableSite @regressionSite @testAPIs 
Funcionalidade: API elo Raspadinha - Ativa ou cancela agendamento de raspagem.

  Esquema do Cenario: POST Ativa agendamento de raspagem.
    Dado que realizo o POST Ativando habilitando função de agendamento semanal <Agendamento>
    Então validando response post agendamento ativo <StatusCode> <Agendamento>

    Exemplos: 
      | StatusCode | Agendamento |
      |        201 | false        |
     
  Esquema do Cenario: POST Ativa agendamento de raspagem ja ativado
    Dado que realizo o POST com Raffle invalido <Agendamento>
    Então validando response post com raffleUuid invalido <StatusCode> <Agendamento>

    Exemplos: 
      | StatusCode | Agendamento    |
      |        412 | false |

  Esquema do Cenario: POST Desativar agendamento de raspagem.
    Dado que realizo o POST desativando habilitando função de agendamento semanal <Agendamento>
    Então validando response post agendamento desativado <StatusCode> <Agendamento>
 
    Exemplos: 
      | StatusCode | Agendamento |
      |        201 | true       |

  
