#language: pt
#Author: Bruno Pavanelli (bruno.pavanelli@dextra-sw.com)
@Web @homeDeslogada @regressionSite
Funcionalidade: Home Deslogada
  Eu como usuario do site Elo 
  Desejo validar o acesso a página Home deslogada do site

  @availableSite
  Esquema do Cenario: Validar disponibilidade da página home deslogada
    Dado que estou no site Elo
    Entao a página home deslogada é exibida, contendo os textos "<Texto1>", "<Texto2>" e "<Texto3>"

    Exemplos: 
      | Texto1                                               | Texto2                                            | Texto3                                                                                               |
      | Cartão Elo: O Cartão com mais Benefícios e Promoções | Com seu cartão Elo, você possui muitas vantagens! | O cartão Elo traz personalização e diversos benefícios para você utilizar no seu dia a dia. Confira! |
