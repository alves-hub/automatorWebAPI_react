#language: pt
#Author: Bruno Pavanelli (bruno.pavanelli@dextra-sw.com)
@Web @applePay @regressionSite
Funcionalidade: Apple Pay
  Eu como usuario do site Elo 
  Desejo validar acesso a pagina Apple Pay
  Para garantir que a página está disponível

  @availableSite
  Esquema do Cenario: Validar disponibilidade da página Apple Pay
    Dado que acessei a página ApplePay
    Entao a pagina Apple Pay é apresentada contendo o texto "<Texto>"

    Exemplos: 
      | Texto                                    |
      | Como adicionar o cartão Elo no Apple Pay |
