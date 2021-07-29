#language: pt
#Author: Bruno Pavanelli (bruno.pavanelli@dextra-sw.com)
@Web @sobreAElo @regressionSite
Funcionalidade: Sobre a Elo
  Eu como usuario do site Elo 
  Desejo validar acesso a pagina Sobre a Elo
  Para garantir que a página está disponível

  @availableSite
  Esquema do Cenario: Validar disponibilidade da página Sobre a Elo
    Dado que acessei a página Sobre a Elo
    Entao a pagina Sobre a Elo é apresentada contendo os textos "<Titulo>" e "<Subtitulo>"

    Exemplos: 
      | Titulo                   | Subtitulo                                                                                                                           |
      | Vai na sua. Vai com Elo. | Lançada em 2011, a Elo é a primeira bandeira 100% brasileira, com ampla variedade de produtos e serviços. Conheça mais sobre a Elo! |
