#language: pt
#Author: Bruno Pavanelli (bruno.pavanelli@dextra-sw.com)
@Web @marcaElo @regressionSite
Funcionalidade: Marca Elo
  Eu como usuario do site Elo 
  Desejo validar acesso a pagina Marca Elo
  Para garantir que a página está disponível

  @availableSite
  Esquema do Cenario: Validar disponibilidade da página Marca Elo
    Dado que estou na página Marca Elo
    Entao a pagina Marca Elo é apresentada contendo os textos "<Titulo>" e "<Subtitulo>"

    Exemplos: 
      | Titulo                | Subtitulo                                                                            |
      | Como usar a marca Elo | Verifique as aplicações corretas da marca Elo. Confira o guia de aplicação completo. |
