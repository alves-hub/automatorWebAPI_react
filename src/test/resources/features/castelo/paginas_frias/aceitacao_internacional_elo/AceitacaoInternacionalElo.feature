#language: pt
#Author: Bruno Pavanelli (bruno.pavanelli@dextra-sw.com)
@Web @aceitacaoInternacionalElo @regressionSite
Funcionalidade: Aceitação Internacional Elo
  Eu como usuario do site Elo 
  Desejo validar acesso a pagina Aceitação Internacional Elo
  Para garantir que a página está disponível

  @availableSite
  Esquema do Cenario: Validar disponibilidade da página Aceitação Internacional Elo
    Dado que acessei a página Aceitação Internacional Elo
    Entao a pagina é apresentada contendo os textos "<Titulo>" e "<Subtitulo>"

    Exemplos: 
      | Titulo            | Subtitulo                                                       |
      | Elo Internacional | O seu cartão Elo acompanha você em suas viagens para o exterior |
